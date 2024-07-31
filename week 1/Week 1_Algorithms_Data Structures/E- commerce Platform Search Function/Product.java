public class Product {

    private int productId;
    private String category;
    private String productName;
    private static int idCounter = 0;

    public Product(String name, String category) {
        this.productName = name;
        this.category = category;
        this.productId = ++idCounter;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return this.productName;
    }

    public String getCategory() {
        return this.category;
    }
}
