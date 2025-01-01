package doublyLinkedlist;

public class DoublyLinkedList {

    // Head and tail pointers for the doubly linked list
    private Node head;
    private Node tail;
    private int length; // Tracks the current number of nodes in the list

    // Inner Node class representing each element in the doubly linked list
    class Node {
        int value; // Value of the node
        Node next; // Pointer to the next node
        Node prev; // Pointer to the previous node

        Node(int value) {
            this.value = value; // Initialize the value when creating a new node
        }
    }

    /**
     * Constructor to initialize the doubly linked list with a single node.
     *
     * @param value The value of the initial node.
     */
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value); // Create a new node
        head = newNode; // Set the new node as the head
        tail = newNode; // Set the new node as the tail
        length = 1; // The list starts with one node
    }

    /**
     * Prints all the values in the doubly linked list, starting from the head.
     */
    public void printList() {
        Node temp = head; // Start at the head
        while (temp != null) {
            System.out.println(temp.value); // Print the value of the current node
            temp = temp.next; // Move to the next node
        }
    }

    /**
     * Prints the value of the head node.
     */
    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    /**
     * Prints the value of the tail node.
     */
    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    /**
     * Prints the length of the doubly linked list.
     */
    public void getLength() {
        System.out.println("Length: " + length);
    }

    /**
     * Adds a new node with the specified value to the end of the list.
     *
     * @param value The value of the new node.
     */
    public void append(int value) {
        Node newNode = new Node(value); // Create a new node
        if (length == 0) { // If the list is empty
            head = newNode; // The new node becomes the head
            tail = newNode; // The new node becomes the tail
        } else {
            tail.next = newNode; // Link the current tail to the new node
            newNode.prev = tail; // Set the new node's previous pointer
            tail = newNode; // Update the tail to the new node
        }
        length++; // Increment the length of the list
    }

    /**
     * Removes and returns the first node of the list.
     *
     * @return The removed node, or null if the list is empty.
     */
    public Node removeFirst() {
        if (length == 0) return null; // Return null if the list is empty
        Node temp = head; // Store the current head
        if (length == 1) { // If there's only one node
            head = null; // Clear the head
            tail = null; // Clear the tail
        } else {
            head = head.next; // Move the head pointer to the next node
            head.prev = null; // Disconnect the old head
            temp.next = null; // Disconnect the old head's next pointer
        }
        length--; // Decrement the length of the list
        return temp; // Return the removed node
    }

    /**
     * Removes and returns the last node of the list.
     *
     * @return The removed node, or null if the list is empty.
     */
    public Node removeLast() {
        if (length == 0) return null; // Return null if the list is empty
        Node temp = tail; // Store the current tail
        if (length == 1) { // If there's only one node
            head = null; // Clear the head
            tail = null; // Clear the tail
        } else {
            tail = tail.prev; // Move the tail pointer to the previous node
            tail.next = null; // Disconnect the old tail
            temp.prev = null; // Disconnect the old tail's previous pointer
        }
        length--; // Decrement the length of the list
        return temp; // Return the removed node
    }

    /**
     * Adds a new node with the specified value to the beginning of the list.
     *
     * @param value The value of the new node.
     */
    public void prepend(int value) {
        Node newNode = new Node(value); // Create a new node
        if (length == 0) { // If the list is empty
            head = newNode; // The new node becomes the head
            tail = newNode; // The new node becomes the tail
        } else {
            head.prev = newNode; // Link the current head to the new node
            newNode.next = head; // Set the new node's next pointer
            head = newNode; // Update the head to the new node
        }
        length++; // Increment the length of the list
    }

    /**
     * Retrieves the node at the specified index.
     *
     * @param index The index of the node to retrieve.
     * @return The node at the specified index, or null if the index is invalid.
     */
    public Node get(int index) {
        if (index < 0 || index >= length) return null; // Check for invalid index
        Node temp;
        if (index < length / 2) { // Start from the head for indices in the first half
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else { // Start from the tail for indices in the second half
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp; // Return the node at the index
    }

    /**
     * Updates the value of the node at the specified index.
     *
     * @param index The index of the node to update.
     * @param value The new value.
     * @return True if the update was successful, false otherwise.
     */
    public boolean set(int index, int value) {
        Node temp = get(index); // Get the node at the index
        if (temp != null) {
            temp.value = value; // Update the value
            return true; // Indicate success
        }
        return false; // Indicate failure
    }

    /**
     * Inserts a new node with the specified value at the specified index.
     *
     * @param index The index to insert the new node at.
     * @param value The value of the new node.
     * @return True if the insertion was successful, false otherwise.
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false; // Check for invalid index
        if (index == 0) { // Insert at the beginning
            prepend(value);
            return true;
        }
        if (index == length) { // Insert at the end
            append(value);
            return true;
        }
        Node newNode = new Node(value); // Create a new node
        Node before = get(index - 1); // Node before the insertion point
        Node after = before.next; // Node after the insertion point
        newNode.prev = before; // Link the new node to the previous node
        newNode.next = after; // Link the new node to the next node
        before.next = newNode; // Update the previous node's next pointer
        after.prev = newNode; // Update the next node's previous pointer
        length++; // Increment the length of the list
        return true; // Indicate success
    }

    /**
     * Removes and returns the node at the specified index.
     *
     * @param index The index of the node to remove.
     * @return The removed node, or null if the index is invalid.
     */
    public Node remove(int index) {
        if (index < 0 || index >= length) return null; // Check for invalid index
        if (index == 0) return removeFirst(); // Remove the first node
        if (index == length - 1) return removeLast(); // Remove the last node
        Node temp = get(index); // Get the node at the index
        temp.next.prev = temp.prev; // Update the next node's previous pointer
        temp.prev.next = temp.next; // Update the previous node's next pointer
        temp.next = null; // Disconnect the next pointer
        temp.prev = null; // Disconnect the previous pointer
        length--; // Decrement the length of the list
        return temp; // Return the removed node
    }
}
