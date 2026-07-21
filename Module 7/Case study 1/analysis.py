import pandas as pd
import numpy as np
import json

customers = pd.read_csv("data/customers.csv")
loans = pd.read_csv("data/loans.csv")
credit = pd.read_csv("data/credit_score.csv")

# Merge all three files
df = customers.merge(loans, on="CustomerID")
df = df.merge(credit, on="CustomerID")

# Replace missing Salary with Median
df["Salary"] = df["Salary"].fillna(df["Salary"].median())

# Replace missing Credit Score with Mean
df["CreditScore"] = df["CreditScore"].fillna(df["CreditScore"].mean())

# Replace missing Interest Rate with previous value
df["InterestRate"] = df["InterestRate"].ffill()


limit = df["LoanAmount"].quantile(0.99)

df = df[df["LoanAmount"] <= limit]

print(df.head())
mean_loan = np.mean(df["LoanAmount"])

median_salary = np.median(df["Salary"])

interest_percentile = np.percentile(df["InterestRate"], 90)

correlation = np.corrcoef(df["Salary"], df["LoanAmount"])[0][1]

std = np.std(df["LoanAmount"])

print("Mean Loan Amount:", mean_loan)
print("Median Salary:", median_salary)
print("90th Percentile Interest Rate:", interest_percentile)
print("Correlation:", correlation)
print("Standard Deviation:", std)



# Find High Risk Customers
risk_customers = df[
    (df["CreditScore"] < 650) &
    (df["Salary"] < 60000) &
    (df["LoanAmount"] > 1000000) &
    (df["DefaultFlag"] == 1)
]

top20 = risk_customers.head(20)

print("\nTop Risky Customers")
print(top20)


df["DebtToIncomeRatio"] = df["LoanAmount"] / df["Salary"]

print("\nAverage Debt-to-Income Ratio:",
      df["DebtToIncomeRatio"].mean())



df["LoanUtilization"] = df["PaidEMIs"] / df["Tenure"]

print("Average Loan Utilization:",
      df["LoanUtilization"].mean())



default_percentage = df["DefaultFlag"].mean() * 100

print("Default Percentage:",
      default_percentage)


npa_percentage = (df["DefaultFlag"] == 1).mean() * 100

print("NPA Percentage:",
      npa_percentage)


average_emi = df["EMI"].mean()

print("Average EMI:",
      average_emi)


df["ExpectedLoss"] = df["LoanAmount"] * 0.40 * df["DefaultFlag"]

expected_loss = df["ExpectedLoss"].sum()

print("Expected Loss:",
      expected_loss)

top20.to_csv(
    "output/high_risk_customers.csv",
    index=False
)

print("High Risk Customers CSV Created")



with pd.ExcelWriter("output/risk_report.xlsx") as writer:

    df.to_excel(writer,
                index=False,
                sheet_name="All Customers")

    top20.to_excel(writer,
                   index=False,
                   sheet_name="Risk Customers")

print("Excel Report Created")




summary = {
    "Mean Loan Amount": float(mean_loan),
    "Median Salary": float(median_salary),
    "90th Percentile Interest": float(interest_percentile),
    "Correlation": float(correlation),
    "Standard Deviation": float(std),
    "Default Percentage": float(default_percentage),
    "NPA Percentage": float(npa_percentage),
    "Average EMI": float(average_emi),
    "Expected Loss": float(expected_loss)
}

with open("output/summary.json", "w") as file:
    json.dump(summary, file, indent=4)

print("Summary JSON Created")


