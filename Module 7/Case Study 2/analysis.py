import pandas as pd
import numpy as np
import os

try:
    # -----------------------------
    # Read CSV Files
    # -----------------------------
    funds = pd.read_csv("funds.csv")
    investors = pd.read_csv("investors.csv")
    transactions = pd.read_csv("transactions.csv")
    nav = pd.read_csv("nav_history.csv")

    print("CSV Files Loaded Successfully.\n")

    # -----------------------------
    # Data Cleaning
    # -----------------------------
    funds.drop_duplicates(inplace=True)
    investors.drop_duplicates(inplace=True)
    transactions.drop_duplicates(inplace=True)
    nav.drop_duplicates(inplace=True)

    # Missing values
    nav["NAV"] = nav["NAV"].ffill()
    investors["InvestorType"] = investors["InvestorType"].fillna("Retail")

    # Remove negative NAV
    nav = nav[nav["NAV"] >= 0]

    # Convert dates
    transactions["PurchaseDate"] = pd.to_datetime(
        transactions["PurchaseDate"].astype(str).str.strip(),
        errors="coerce"
    )

    nav["Date"] = pd.to_datetime(
        nav["Date"].astype(str).str.strip(),
        errors="coerce"
    )

    # Remove invalid dates
    transactions.dropna(subset=["PurchaseDate"], inplace=True)
    nav.dropna(subset=["Date"], inplace=True)

    # -----------------------------
    # Latest NAV
    # -----------------------------
    latest_nav = (
        nav.sort_values("Date")
           .groupby("FundID")
           .last()
           .reset_index()[["FundID", "NAV"]]
    )

    latest_nav.rename(columns={"NAV": "LatestNAV"}, inplace=True)

    # -----------------------------
    # Merge Data
    # -----------------------------
    df = transactions.merge(investors, on="InvestorID")
    df = df.merge(funds, on="FundID")
    df = df.merge(latest_nav, on="FundID")

    # -----------------------------
    # Create New Columns
    # -----------------------------
    df["InvestmentAmount"] = (
        df["UnitsPurchased"] * df["PurchaseNAV"]
    )

    df["CurrentValue"] = (
        df["UnitsPurchased"] * df["LatestNAV"]
    )

    df["Profit"] = (
        df["CurrentValue"] - df["InvestmentAmount"]
    )

    df["ROI"] = (
        df["Profit"] / df["InvestmentAmount"]
    ) * 100

    # -----------------------------
    # NumPy Calculations
    # -----------------------------
    avg_nav = np.mean(df["LatestNAV"])
    max_nav = np.max(df["LatestNAV"])
    min_nav = np.min(df["LatestNAV"])
    variance_nav = np.var(df["LatestNAV"])
    std_nav = np.std(df["LatestNAV"])

    df["RollingAverage"] = (
        df["LatestNAV"]
        .rolling(window=5)
        .mean()
    )

    # -----------------------------
    # Pandas Analysis
    # -----------------------------
    top_investors = (
        df.sort_values(
            "InvestmentAmount",
            ascending=False
        ).head(5)
    )

    top_funds = (
        df.groupby("FundName")[["Profit", "ROI", "LatestNAV"]]
        .mean()
        .sort_values("Profit", ascending=False)
        .head(5)
    )

    worst_fund = (
        df.groupby("FundName")["ROI"]
        .mean()
        .idxmin()
    )

    highest_nav_fund = (
        df.loc[df["LatestNAV"].idxmax(), "FundName"]
    )

    lowest_nav_fund = (
        df.loc[df["LatestNAV"].idxmin(), "FundName"]
    )

    # -----------------------------
    # Group By Category
    # -----------------------------
    category_summary = (
        df.groupby("Category")
        .agg(
            AverageROI=("ROI", "mean"),
            AverageNAV=("LatestNAV", "mean"),
            TotalInvestment=("InvestmentAmount", "sum")
        )
    )

    # -----------------------------
    # Group By AMC
    # -----------------------------
    amc_summary = (
        df.groupby("AMC")
        .agg(
            NumberOfFunds=("FundID", "count"),
            AverageNAV=("LatestNAV", "mean"),
            TotalInvestment=("InvestmentAmount", "sum")
        )
    )

    # -----------------------------
    # Group By State
    # -----------------------------
    state_summary = (
        df.groupby("State")
        .agg(
            NumberOfInvestors=("InvestorID", "count"),
            TotalInvestment=("InvestmentAmount", "sum"),
            AverageROI=("ROI", "mean")
        )
    )

    # -----------------------------
    # Group By Investor Type
    # -----------------------------
    investor_summary = (
        df.groupby("InvestorType")
        .agg(
            TotalInvestment=("InvestmentAmount", "sum"),
            AverageProfit=("Profit", "mean")
        )
    )

    # -----------------------------
    # Detect Issues
    # -----------------------------
    duplicate_nav = nav[nav.duplicated()]
    negative_nav = nav[nav["NAV"] < 0]
    future_dates = nav[nav["Date"] > pd.Timestamp.today()]
    missing_fund = df[df["FundID"].isna()]
    missing_investor = df[df["InvestorID"].isna()]
    invalid_purchase_nav = df[df["PurchaseNAV"] < 0]

    # -----------------------------
    # Finance Metrics
    # -----------------------------
    df["AbsoluteReturn"] = df["Profit"]
    df["AnnualReturn"] = df["ROI"]

    volatility = np.std(df["LatestNAV"])
    risk_free_rate = 6

    df["SharpeRatio"] = (
        df["ROI"] - risk_free_rate
    ) / volatility

    # -----------------------------
    # Export Reports
    # -----------------------------
    os.makedirs("output", exist_ok=True)

    top_funds.to_excel(
        "output/TopFunds.xlsx"
    )

    investor_summary.to_excel(
        "output/InvestorSummary.xlsx"
    )

    category_summary.to_csv(
        "output/CategorySummary.csv"
    )

    # -----------------------------
    # Output
    # -----------------------------
    print("\n========== SUMMARY ==========")
    print("Average NAV :", avg_nav)
    print("Maximum NAV :", max_nav)
    print("Minimum NAV :", min_nav)
    print("Variance :", variance_nav)
    print("Standard Deviation :", std_nav)

    print("\nTop Investors")
    print(top_investors)

    print("\nTop Funds")
    print(top_funds)

    print("\nWorst Fund :", worst_fund)
    print("Highest NAV Fund :", highest_nav_fund)
    print("Lowest NAV Fund :", lowest_nav_fund)

    print("\nReports Generated Successfully!")
    print("Check output folder.")

except FileNotFoundError as e:
    print("File Not Found :", e)

except Exception as e:
    print("Error :", e)