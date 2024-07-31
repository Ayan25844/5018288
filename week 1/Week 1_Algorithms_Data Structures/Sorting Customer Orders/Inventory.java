// Q1. Explain different sorting algorithms (Bubble Sort, Insertion Sort, Quick Sort, Merge Sort).
// A1. Bubble Sort: Bubble sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. This process is repeated until the list is sorted. It gets its name because smaller elements "bubble" to the top of the list. While easy to understand, bubble sort is inefficient for large datasets, with a time complexity of O(n²).
// A1. Insertion Sort: Insertion sort builds a sorted array one element at a time by taking an unsorted element and inserting it into its correct position in the already sorted part of the array. It works similarly to how one might sort playing cards in hand. This algorithm is efficient for small datasets and has a time complexity of O(n²) in the average and worst cases, but O(n) in the best case when the array is already sorted.
// A1. Quick Sort: Quick sort is a highly efficient sorting algorithm that uses a divide-and-conquer approach. It selects a 'pivot' element from the array and partitions the other elements into two sub-arrays according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively. Quick sort has an average-case time complexity of O(n log n) and is often faster in practice than other O(n log n) algorithms.
// A1. Merge Sort: Merge sort is another divide-and-conquer algorithm that splits the array into two halves, sorts each half, and then merges the sorted halves back together. This process continues recursively until the entire array is sorted. Merge sort is particularly efficient for large datasets and has a time complexity of O(n log n) in all cases, making it a stable sorting algorithm suitable for linked lists and large datasets.

import java.util.ArrayList;

public class Inventory {

    private static ArrayList<Order> list = new ArrayList<>();

    public Inventory(String name, double price) {
        Order order = new Order(name, price);
        this.add(order);
    }

    private static void print() {

        System.out.println("{");
        for (Order i : list) {
            System.out.println(" { " + i.getOrderId() + " : " + i.getName() + " , " + i.getTotalPrice() + " } ");
        }

        System.out.println("}");
        System.out.println();
    }

    public void add(Order order) {
        list.add(order);
        System.out.print("Order item " + order.getOrderId() + " added : ");
        print();
    }
// Q2. Compare the performance (time complexity) of Bubble Sort and Quick Sort.
    public static void bubbleSort() {

        // A2. Bubble sort has a time complexity of O(n²) in the average and worst
        // cases, as it requires nested loops to compare and potentially swap elements,
        // making it inefficient for large datasets. The best case is O(n) if the list
        // is already sorted, as it can terminate early if no swaps occur.

        for (int i = 0; i < list.size() - 1; i++) {
            boolean swapped = false;
            for (int j = 1; j <= list.size() - i - 1; j++) {
                if (list.get(j).getOrderId() < list.get(j - 1).getOrderId()) {
                    swapped = true;
                    Order temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.print("Cart items after bubble sort: ");
        print();
    }

    public static void quickSort(int low, int high) {

        // A2. Quick sort has an average-case time complexity of O(n log n), which
        // makes it much more efficient for larger datasets. In the worst case, which
        // occurs when the smallest or largest element is consistently chosen as the
        // pivot (leading to unbalanced partitions), its time complexity can degrade to
        // O(n²). However, with good pivot selection strategies,
        // quick sort typically performs significantly better than bubble sort.

        if (low >= high) {
            return;
        }
        int start = low, end = high, mid = start + (end - start) / 2, pivot = list.get(mid).getOrderId();
        while (start <= end) {
            while (list.get(start).getOrderId() < pivot) {
                start++;
            }
            while (list.get(end).getOrderId() > pivot) {
                end--;
            }
            if (start <= end) {
                Order temp = list.get(start);
                list.set(start, list.get(end));
                list.set(end, temp);
                start++;
                end--;
            }
        }
        quickSort(low, end);
        quickSort(start, high);
        System.out.print("Cart items after quick sort: ");
        print();
    }

    public static int getListSize() {
        return list.size();
    }

    // A2. In summary, quick sort is generally more efficient than bubble sort,
    // especially for larger lists.
}
// Q3. Discuss why Quick Sort is generally preferred over Bubble Sort.
// A3. Quick sort is generally preferred over bubble sort for several reasons:

// A3. Efficiency: Quick sort has an average time complexity of O(n log n),
// making it significantly faster than bubble sort's O(n²) for large datasets.
// This efficiency allows quick sort to handle larger lists much more
// effectively.
// A3. Divide-and-Conquer: Quick sort uses a divide-and-conquer approach, which
// allows it to sort subarrays independently and efficiently. This method of
// partitioning leads to faster sorting compared to the repeated comparisons and
// swaps of bubble sort.
// A3. Less Comparisons: Quick sort performs fewer comparisons on average
// compared to bubble sort, especially in cases where the data is large and not
// sorted. This reduces the number of operations needed to sort the data.
// A3. Adaptability: Quick sort can be optimized with better pivot selection
// methods, further improving its performance in
// practical scenarios. In contrast, bubble sort's straightforward approach
// lacks such optimizations.
