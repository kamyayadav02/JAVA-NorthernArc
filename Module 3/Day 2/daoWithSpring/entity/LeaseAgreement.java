package entity;

public class LeaseAgreement {

    private int id;
    private String assetName;
    private String customerName;
    private double leaseAmount;
    private int durationMonths;
    private boolean active;

    public LeaseAgreement(int id, String assetName, String customerName,
                          double leaseAmount, int durationMonths, boolean active) {
        this.id = id;
        this.assetName = assetName;
        this.customerName = customerName;
        this.leaseAmount = leaseAmount;
        this.durationMonths = durationMonths;
        this.active = active;
    }

    public LeaseAgreement(String assetName, String customerName,
                          double leaseAmount, int durationMonths, boolean active) {
        this.assetName = assetName;
        this.customerName = customerName;
        this.leaseAmount = leaseAmount;
        this.durationMonths = durationMonths;
        this.active = active;
    }

    public LeaseAgreement() {}

    public int getId() { return id; }
    public String getAssetName() { return assetName; }
    public String getCustomerName() { return customerName; }
    public double getLeaseAmount() { return leaseAmount; }
    public int getDurationMonths() { return durationMonths; }
    public boolean isActive() { return active; }

    public void setId(int id) { this.id = id; }
    public void setAssetName(String assetName) { this.assetName = assetName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setLeaseAmount(double leaseAmount) { this.leaseAmount = leaseAmount; }
    public void setDurationMonths(int durationMonths) { this.durationMonths = durationMonths; }
    public void setActive(boolean active) { this.active = active; }

    @Override
    public String toString() {
        return "LeaseAgreement{" +
                "id=" + id +
                ", assetName='" + assetName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", leaseAmount=" + leaseAmount +
                ", durationMonths=" + durationMonths +
                ", active=" + active +
                '}';
    }
}
