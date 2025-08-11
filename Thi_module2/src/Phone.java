public class Phone {
    private int id;
    private String phoneName;
    private String price;
    private int quantity;
    private String brand;

    public Phone(int id, String phoneName, String price, int quantity, String brand) {
        this.id = id;
        this.phoneName = phoneName;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
    }

    public Phone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String toCSV() {
        return id + "," +
                phoneName + "," +
                price + "," +
                quantity + "," +
                brand;
    }

    @Override
    public String toString() {
        return id + ", " + phoneName + ", " + price + ", " + quantity + ", " + brand;
    }
}
