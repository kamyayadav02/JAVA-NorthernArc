import pandas as pd
import numpy as np

# ============================================
# STEP 1 : Read CSV Files
# ============================================

print("=" * 50)
print("Loading CSV Files...")
print("=" * 50)

customers = pd.read_csv("customers.csv")
loan_application = pd.read_csv("loan_application.csv")
loan_payments = pd.read_csv("loan_payments.csv")

print("✓ Files Loaded Successfully\n")

# ============================================
# STEP 2 : Dataset Information
# ============================================

print("=" * 50)
print("Dataset Shapes")
print("=" * 50)

print("Customers :", customers.shape)
print("Loan Application :", loan_application.shape)
print("Loan Payments :", loan_payments.shape)

# ============================================
# STEP 3 : Remove Duplicate Records
# ============================================

print("\n" + "=" * 50)
print("Removing Duplicate Records")
print("=" * 50)

customers.drop_duplicates(inplace=True)
loan_application.drop_duplicates(inplace=True)
loan_payments.drop_duplicates(inplace=True)

print("✓ Duplicate Records Removed")

# ============================================
# STEP 4 : Check Missing Values
# ============================================

print("\n" + "=" * 50)
print("Missing Values")
print("=" * 50)

print("\nCustomers")
print(customers.isnull().sum())

print("\nLoan Application")
print(loan_application.isnull().sum())

print("\nLoan Payments")
print(loan_payments.isnull().sum())

# ============================================
# STEP 5 : Fill Missing Numeric Values
# ============================================

print("\n" + "=" * 50)
print("Handling Missing Values")
print("=" * 50)

# Fill Salary with Median
if "Salary" in customers.columns:
    customers["Salary"] = customers["Salary"].fillna(
        customers["Salary"].median()
    )

# Fill CreditScore with Mean
if "CreditScore" in customers.columns:
    customers["CreditScore"] = customers["CreditScore"].fillna(
        customers["CreditScore"].mean()
    )

print("✓ Missing Values Handled")

# ============================================
# STEP 6 : Convert Date Columns
# ============================================

print("\n" + "=" * 50)
print("Converting Date Columns")
print("=" * 50)

if "ApplicationDate" in loan_application.columns:
    loan_application["ApplicationDate"] = pd.to_datetime(
        loan_application["ApplicationDate"],
        errors="coerce"
    )

if "LastPaymentDate" in loan_payments.columns:
    loan_payments["LastPaymentDate"] = pd.to_datetime(
        loan_payments["LastPaymentDate"],
        errors="coerce"
    )

print("✓ Date Conversion Completed")

# ============================================
# STEP 7 : Remove Invalid Dates
# ============================================

print("\n" + "=" * 50)
print("Removing Invalid Dates")
print("=" * 50)

if "ApplicationDate" in loan_application.columns:
    loan_application.dropna(
        subset=["ApplicationDate"],
        inplace=True
    )

if "LastPaymentDate" in loan_payments.columns:
    loan_payments.dropna(
        subset=["LastPaymentDate"],
        inplace=True
    )

print("✓ Invalid Dates Removed")

# ============================================
# STEP 8 : Standardize Customer IDs
# ============================================

print("\n" + "=" * 50)
print("Standardizing Customer IDs")
print("=" * 50)

if "CustomerID" in customers.columns:
    customers["CustomerID"] = customers["CustomerID"].astype(str)
    customers["CustomerID"] = customers["CustomerID"].apply(
        lambda x: x if x.startswith("C") else "C" + x
    )

if "CustomerID" in loan_application.columns:
    loan_application["CustomerID"] = loan_application["CustomerID"].astype(str)
    loan_application["CustomerID"] = loan_application["CustomerID"].apply(
        lambda x: x if x.startswith("C") else "C" + x
    )

print("✓ Customer IDs Standardized")

# ============================================
# STEP 9 : Remove Invalid Numeric Values
# ============================================

print("\n" + "=" * 50)
print("Removing Invalid Numeric Records")
print("=" * 50)

if "Salary" in customers.columns:
    customers = customers[customers["Salary"] >= 0]

if "LoanAmount" in loan_application.columns:
    loan_application = loan_application[
        loan_application["LoanAmount"] > 0
    ]

if "EMI" in loan_payments.columns:
    loan_payments = loan_payments[
        loan_payments["EMI"] > 0
    ]

print("✓ Invalid Numeric Records Removed")

# ============================================
# STEP 10 : Final Dataset Shapes
# ============================================

print("\n" + "=" * 50)
print("Final Dataset Shapes")
print("=" * 50)

print("Customers :", customers.shape)
print("Loan Application :", loan_application.shape)
print("Loan Payments :", loan_payments.shape)

# ============================================
# STEP 11 : Preview Data
# ============================================

print("\n" + "=" * 50)
print("Customers Preview")
print("=" * 50)
print(customers.head())

print("\n" + "=" * 50)
print("Loan Application Preview")
print("=" * 50)
print(loan_application.head())

print("\n" + "=" * 50)
print("Loan Payments Preview")
print("=" * 50)
print(loan_payments.head())

# ============================================
# STEP 12 : Save Cleaned Files (Optional)
# ============================================

customers.to_csv("customers_cleaned.csv", index=False)
loan_application.to_csv("loan_application_cleaned.csv", index=False)
loan_payments.to_csv("loan_payments_cleaned.csv", index=False)

print("\n" + "=" * 50)
print("Data Cleaning Completed Successfully")
print("Cleaned CSV files have been saved.")
print("=" * 50)