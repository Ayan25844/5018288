// Q1. Explain why data structures and algorithms are essential in handling large inventories.
// A1. Data structures and algorithms are essential for managing large inventories because they enable efficient storage, retrieval, and manipulation of data.

// Q2. Discuss the types of data structures suitable for this problem.
// A2. In a large inventory the amount of data will be huge. To efficiently access and manipulate them, we need a proper structure to store data so that the data can be maintained easily. If we don't structure them properly, due to the huge size of the data, it will take a lot of time to search, create, update and delete them.

import java.util.HashMap;

public class Inventory {

    private static HashMap<Integer, Product> map = new HashMap<>();

    public Inventory(String name, int quantity, double price) {
        Product product = new Product(name, quantity, price);
        this.add(product);
    }

    private static void print() {
        System.out.println("{");
        for (int i : map.keySet()) {
            System.out.println(
                    " { " + i + " : " + map.get(i).getName() + " , " + map.get(i).getQuantity() + " , "
                            + map.get(i).getPrice()
                            +
                            " } ");
        }
        System.out.println("}");
        System.out.println();
    }

    // Q3. Analyze the time complexity of each operation (add, update, delete) in your chosen data structure.

    public void add(Product product) {

        // A3. This will simply create a new product and due to that the autoGenID will
        // be incremented, then we will simply map the autoGenID to the new Product.
        // This will be done in constant time complexity O(1)

        map.put(product.getProductId(), product);
        System.out.print("Product item " + product.getProductId() + " added : ");
        print();
    }

    public static void update(int id, String newName, int newQuantity, double newPrice) {

        // A3. This will find the product using product_id. If it exists then it will be
        // updated else the else block will be executed. To access the product, the time
        // complexity will be O(1)

        map.get(id).setName(newName);
        map.get(id).setQuantity(newQuantity);
        map.get(id).setPrice(newPrice);
        System.out.println("Product item " + id + " updated: ");
        print();
    }

    public static void delete(int id) {

        // A3. This will find the product using product_id. If it exists then it will be
        // updated else the else block will be executed. To access the product, the time
        // complexity will be O(1)

        map.remove(id);
        System.out.print("Product item " + id + " deleted : ");
        print();
    }
}
