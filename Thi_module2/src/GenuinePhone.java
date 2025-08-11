public class GenuinePhone extends Phone {
    private String warrantyDuration;
    private String warrantyCoverage;

    public GenuinePhone(int id, String phoneName, String price, int quantity, String brand, String warrantyDuration, String warrantyCoverage) {
        super(id, phoneName, price, quantity, brand);
        this.warrantyDuration = warrantyDuration;
        this.warrantyCoverage = warrantyCoverage;
    }

    public GenuinePhone() {
    }

    public String getWarrantyDuration() {
        return warrantyDuration;
    }

    public void setWarrantyDuration(String warrantyDuration) {
        this.warrantyDuration = warrantyDuration;
    }

    public String getWarrantyCoverage() {
        return warrantyCoverage;
    }

    public void setWarrantyCoverage(String warrantyCoverage) {
        this.warrantyCoverage = warrantyCoverage;
    }

    public String toCSV() {
        return super.getId() + "," +
                super.getPhoneName() + "," +
                super.getPrice() + "," +
                super.getQuantity() + "," +
                super.getBrand() + "," + warrantyDuration + "," + warrantyCoverage;
    }

    @Override
    public String toString() {
        return super.toString() + "GenuinePhone{" +
                "warrantyDuration='" + warrantyDuration + '\'' +
                ", warrantyCoverage='" + warrantyCoverage + '\'' +
                '}';
    }
}
