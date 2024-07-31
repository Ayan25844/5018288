// Q1. Explain linear search and binary search algorithms.
// A1. Linear search is a simple algorithm that checks each element in a list sequentially until the target value is found or the end of the list is reached. It is easy to implement and works on any list, but is inefficient for large lists with a time complexity of O(n).
// A1. Binary search, on the other hand, is more efficient with a time complexity of O(log n) but requires the list to be sorted. It works by repeatedly dividing the search interval in half: starting with the entire list, it compares the target value to the middle element, and if they are not equal, it eliminates half of the remaining elements based on whether the target is greater or less than the middle element.

import java.util.ArrayList;
import java.util.Collections;

public class Library {

    private static ArrayList<Book> list = new ArrayList<>();

    public Library(String title, String author) {
        Book book = new Book(title, author);
        this.add(book);
    }

    private static void print() {

        System.out.println("{");
        for (Book i : list) {
            System.out.println(" { " + i.getBookId() + " : " + i.getTitle() + " , " + i.getAuthor() + " } ");
        }

        System.out.println("}");
        System.out.println();
    }

    public void add(Book book) {
        list.add(book);
        Collections.sort(list, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        System.out.print("Book item " + book.getBookId() + " added : ");
        print();
    }
// Q2. Compare the time complexity of linear and binary search.
    public static String linearSearch(String target) {

        // A2. The linear search method has a time complexity of O(n), as it iterates
        // through each element in the list one by one until it finds the target or
        // reaches the end.

        for (Book i : list) {
            if (i.getTitle() == target) {
                return ("Book found: " + i.getAuthor());
            }
        }
        return ("Book not found");
    }

    public static String binarySearch(String target) {

        // A2. The binary search method has a time complexity of O(log n), as it
        // repeatedly divides the search interval in half, significantly reducing the
        // number of comparisons needed.

        int start = 0, end = list.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int comparison = target.compareTo(list.get(mid).getTitle());
            if (comparison == 0) {
                return ("Book found: " + list.get(mid).getTitle() + " by " + list.get(mid).getAuthor());
            } else if (comparison > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ("Book not found");
    }

    // A2. Therefore, binary search is more efficient for large, sorted lists, while
    // linear search is simpler but less efficient for large lists.
}
// Q3. Discuss when to use each algorithm based on the data set size and order.

// A3. Linear search should be used for small or unsorted datasets since it is
// simple and does not require the data to be in any specific order. It is also
// useful when the dataset is dynamically changing and sorting is not practical.

// A3. Binary search should be used for large, sorted datasets as it is
// significantly faster, reducing the number of comparisons needed to find the
// target. However, binary search requires the dataset to be sorted in advance,
// so it is not suitable for unsorted or frequently changing datasets.
