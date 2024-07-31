public class Main {
    public static void main(String[] args) {

        new Inventory("Adidas", "Shoes");
        new Inventory("Lenskart", "spectacles");

        System.out.println(Inventory.linearSearch(1));
        System.out.println(Inventory.binarySearch(2));
    }
}
