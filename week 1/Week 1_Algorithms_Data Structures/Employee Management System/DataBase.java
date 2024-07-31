
// 1. Arrays are represented in memory as a contiguous block of memory locations, where each element is stored sequentially. The first element is accessed using a base address, and subsequent elements are accessed by adding an offset (index multiplied by the element size).

// 1. Advantages of arrays:

// 1. Fast Access: Constant time O(1) access to elements via indexing.
// 1. Memory Efficiency: Contiguous allocation minimizes overhead and improves cache locality.
// 1. Simplicity: Easy to implement and use, especially for fixed-size collections of elements.
// 1. Data Structure Compatibility: Can be easily used to implement other data structures like stacks, queues, and matrices.

public class DataBase {

    private static int index = 0;
    private static Employee[] list = new Employee[100];

    public DataBase(String name, float salary, String position) {
        Employee employee = new Employee(name, salary, position);
        this.add(employee);
    }

    private static void traverse() {

        // 2. Time Complexity: O(n)
        // 2. Reason: It iterates through the entire list to print each non-null
        // employee.

        System.out.println("{");
        for (Employee i : list) {
            if (i != null) {
                System.out.println(" { " + i.getEmployeeId() + " : " + i.getName() + " , " + i.getSalary() + " , "
                        + i.getPosition() + " } ");
            }
        }

        System.out.println("}");
        System.out.println();
    }

    public void add(Employee employee) {

        // 2.Time Complexity: O(1)
        // 2. Reason: It checks the index and adds an employee in constant time if
        // there's space.

        if (index < list.length) {
            list[index++] = employee;
            System.out.print("Employee record " + employee.getEmployeeId() + " added : ");
            traverse();
        } else {
            System.out.println(" Cannot add more employees. The list is full.");
        }
    }

    public static String search(int target) {

        // 2. Time Complexity: O(n)
        // 2. Reason: It iterates through the entire list to find the employee with the
        // target ID.

        for (Employee i : list) {
            if (i != null && i.getEmployeeId() == target) {
                return ("Employee found: " + i.getName());
            }
        }
        return ("Employee not found.");
    }

    public static String delete(int target) {

        // 2. Time Complexity: O(n)
        // 2. Reason: It iterates through the list to find the target employee, and then
        // shifts elements, which can take up to O(n) in the worst case.

        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].getEmployeeId() == target) {
                for (int j = i; j < list.length - 1; j++) {
                    list[j] = list[j + 1];
                }
                list[list.length - 1] = null;
                index--;
                return ("Employee with ID " + target + " deleted.");
            }
        }
        return ("Employee with ID " + target + " not found.");
    }

    // 2. In summary:

    // 2. Traverse: O(n)
    // 2. Add: O(1) + O(n) (due to traverse)
    // 2. Search: O(n)
    // 2. Delete: O(n)
}

// 3. Limitations of Arrays:

// 3. Fixed Size: Once declared, the size of an array cannot be changed, leading
// to potential wasted space or overflow if the capacity is exceeded.
// 3. Inefficient Insertions/Deletions: Adding or removing elements (except at
// the end) requires shifting elements, which can be time-consuming O(n).
// 3. Homogeneous Elements: Arrays can typically only store elements of the same
// data type, limiting flexibility.
// 3. Memory Allocation: Contiguous memory allocation can lead to fragmentation,
// especially in large arrays.

// 3. When to Use Arrays:

// 3. When the size of the dataset is known in advance and remains constant.
// 3. For applications that require fast access to elements using indices.
// 3. When working with homogeneous data types and simple data structures (like
// matrices).
// 3. In scenarios where memory efficiency is crucial, and you can benefit from
// contiguous memory allocation.