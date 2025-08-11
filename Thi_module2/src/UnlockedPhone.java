public class UnlockedPhone extends Phone {
    private String sourceCountry;
    private int status;

    public UnlockedPhone(int id, String phoneName, String price, int quantity, String brand, String sourceCountry, int status) {
        super(id, phoneName, price, quantity, brand);
        this.sourceCountry = sourceCountry;
        this.status = status;
    }

    public UnlockedPhone() {
    }

    public String getSourceCountry() {
        return sourceCountry;
    }

    public void setSourceCountry(String sourceCountry) {
        this.sourceCountry = sourceCountry;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

//    public String toCSV() {
//        return super.getId() + "," +
//                super.getPhoneName() + "," +
//                super.getPrice() + "," +
//                super.getQuantity() + "," +
//                super.getBrand() + "," + warrantyDuration + "," + warrantyCoverage;
//    }

    @Override
    public String toString() {
        return super.toString() + "UnlockedPhone{" +
                "sourceCountry='" + sourceCountry + '\'' +
                ", status=" + status +
                '}';
    }
}
