public class Main {
    public static void main(String[] args) {

        new Inventory("Shoes", 15);
        new Inventory("Spectacles", 20);

        Inventory.bubbleSort();
        new Inventory("Cutlery", 5);
        Inventory.quickSort(0, Inventory.getListSize() - 1);
    }
}
