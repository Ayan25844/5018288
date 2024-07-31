// Q1. Explain Big O notation and how it helps in analyzing algorithms.
// A1. Big O notation is a mathematical concept used to describe the efficiency of algorithms in terms of their time and space complexity. It characterizes the worst-case scenario of an algorithm's growth rate as the size of the input increases, providing an upper bound on the performance.
// A1. Big O helps in comparing algorithms, allowing developers to choose the most efficient one for their needs, especially when dealing with large datasets.

// Q2. Describe the best, average, and worst-case scenarios for search operations.
// A2. For search operations, the best, average, and worst-case scenarios can be described as follows:

// A2. Best Case: The target element is found immediately, typically at the first position (e.g., in a linear search). Time complexity is O(1).
// A2. Average Case: The target element is found somewhere in the middle of the dataset. For linear search, the average time complexity is O(n), while for binary search (on a sorted array), it is O(log n).
// A2. Worst Case: The target element is not found at all, or it is located at the last position in the dataset. For linear search, this is O(n), and for binary search, if the target is not present, it still results in O(log n) due to the need to search through the entire structure.

import java.util.ArrayList;

public class Inventory {

    private static ArrayList<Product> list = new ArrayList<>();

    public Inventory(String name, String category) {
        Product product = new Product(name, category);
        this.add(product);
    }

    private static void print() {

        System.out.println("{");
        for (Product i : list) {
            System.out.println(" { " + i.getProductId() + " : " + i.getName() + " , " + i.getCategory() + " } ");
        }

        System.out.println("}");
        System.out.println();
    }

    public void add(Product product) {
        list.add(product);
        System.out.print("Cart item " + product.getProductId() + " added : ");
        print();
    }
// Q3. Compare the time complexity of linear and binary search algorithms.
    public static String linearSearch(int target) {

        // A3. Time Complexity: O(n)
        // A3. Description: The method iterates through the entire list, checking each
        // product's ID until it finds the target or reaches the end. In the worst case,
        // it examines all elements.

        for (Product i : list) {
            if (i.getProductId() == target) {
                return ("Product found: " + i.getName());
            }
        }
        return ("Product not found");
    }

    public static String binarySearch(int target) {

        // A3. Time Complexity: O(log n)
        // A3. Description: This method requires the list to be sorted. It repeatedly
        // divides the search interval in half, significantly reducing the number of
        // comparisons needed to find the target.

        int start = 0, end = list.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == list.get(mid).getProductId()) {
                return ("Product found: " + list.get(mid).getName());
            } else if (target > list.get(mid).getProductId()) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ("Product not found");
    }

    public static ArrayList<Product> getList() {
        return list;
    }

    // A3. Linear search is less efficient for large datasets compared to binary
    // search, which is much faster due to its logarithmic nature. However, binary
    // search requires the list to be sorted beforehand.
}
// Q4. Discuss which algorithm is more suitable for your platform and why.
// A4. The more suitable algorithm for this platform is binary search as t
// provides faster search times O(log n).
