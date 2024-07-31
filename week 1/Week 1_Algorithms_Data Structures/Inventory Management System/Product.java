public class Product {

    private int productId;
    private double price;
    private int quantity;
    private String productName;
    private static int idCounter = 0;

    public Product(String name, int quantity, double price) {
        this.price = price;
        this.productName = name;
        this.quantity = quantity;
        this.productId = ++idCounter;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return productName;
    }

    public void setName(String newName) {
        this.productName = newName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
}