public class Order {

    private int orderId;
    private String customerName;
    private double totalPrice;
    private static int idCounter = 100;

    public Order(String name, double price) {
        this.customerName = name;
        this.totalPrice = price;
        this.orderId = --idCounter;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getName() {
        return this.customerName;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }
}