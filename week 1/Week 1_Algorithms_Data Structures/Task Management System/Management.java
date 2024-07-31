
// 1. A singly linked list is a linear data structure consisting of a sequence of nodes, where each node contains a data element and a reference (or pointer) to the next node in the sequence. This allows for efficient insertion and deletion of nodes, as it only requires updating the pointers of adjacent nodes. However, because each node points only to the next node, traversing the list in reverse or accessing nodes randomly can be less efficient, requiring a linear search from the head of the list.

// 1. A doubly linked list is similar to a singly linked list but with an added complexity: each node contains two references—one to the next node and another to the previous node. This bidirectional structure allows for traversal in both directions, making operations like insertion and deletion at both ends of the list more efficient. However, it requires more memory to store the additional pointer, which can lead to slightly increased overhead compared to singly linked lists.

public class Management {

    private Node head;
    private Node tail;
    private int size;

    public Management() {
        this.size = 0;
    }

    private void addFirst(String name, boolean status) {
        Node node = new Node(name, status);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    private void addLast(String name, boolean status) {
        if (tail == null) {
            addFirst(name, status);
            return;
        }
        Node node = new Node(name, status);
        tail.next = node;
        tail = node;
        size++;
    }

    public void add(String name, boolean status, int index) {

        // 2. Adding a node at the beginning is done in constant time O(1) by updating
        // the head pointer.

        if (index == 0) {
            addFirst(name, status);
            return;
        }

        // 2. Adding a node at the end is done in constant time O(1) by updating
        // the tail pointer.

        if (index == size) {
            addLast(name, status);
            return;
        }

        // 2. For other indices, it requires traversing to the index, which takes
        // linear time O(n).

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(name, status, temp.next);
        temp.next = node;

        size++;
    }

    private Task deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        Task val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public Task delete(int index) {

        // 2. Deleting the first node O(1) is done in constant time by updating the head
        // pointer.

        if (index == 0) {
            return deleteFirst();
        }

        // 2. If the list has more than one node, it traverses to find the second last
        // node, resulting in linear time complexity O(n).

        if (index == size - 1) {
            return deleteLast();
        }

        // 2. It requires traversing to the specified index to find the previous node,
        // leading to linear time complexity O(n).

        Node prev = get(index - 1);
        Task val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    public String search(int value) {

        // 2. The search operation requires traversing the entire list in the worst case
        // to find a node, which takes linear time O(n).

        Node node = head;
        while (node != null) {
            if (node.value.getId() == value) {
                return node.value.getName();
            }
            node = node.next;
        }
        return null;
    }

    private Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private Task deleteFirst() {
        Task val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public void traverse() {

        // 2. This operation requires visiting each node in the list, leading to linear
        // time complexity O(n).

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value.getName() + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private Task value;
        private Node next;

        public Node(String name, boolean status) {
            Task task = new Task(name, status);
            this.value = task;
        }

        public Node(String name, boolean status, Node next) {
            Task task = new Task(name, status);
            this.value = task;
            this.next = next;
        }
    }

    // 2. In summary, the operations that involve traversing the list (such as add,
    // delete, search, and get) have a time complexity of O(n), while operations
    // that add or remove nodes at the beginning (like addFirst and deleteFirst)
    // have a time complexity of O(1).

}

// 3. Linked lists offer several advantages over arrays for dynamic data:

// 3. Dynamic Size: Linked lists can easily grow or shrink in size by adding or
// removing nodes, while arrays have a fixed size and require resizing or
// reallocating memory to accommodate additional elements.

// 3. Efficient Insertions/Deletions: Inserting or deleting nodes in a linked
// list is efficient (O(1) for the first or last node, O(n) for specific
// positions) because it involves adjusting pointers rather than shifting
// elements as in arrays.

// 3. Memory Utilization: Linked lists can utilize memory more efficiently by
// allocating memory only as needed for each node, avoiding wasted space
// associated with larger arrays that may be partially filled.

// 3. No Need for Contiguous Memory: Linked lists do not require contiguous
// memory allocation, making them less prone to fragmentation and better suited
// for applications with unpredictable memory needs.