public class Main {
    public static void main(String[] args) {

        new Inventory("Adidas", 12, 2000);
        new Inventory("Lenskart", 15, 1500);
        Inventory.delete(1);
        Inventory.update(2, "Netradip", 5, 768);
    }
}