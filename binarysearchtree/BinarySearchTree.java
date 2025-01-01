package binarysearchtree;

public class BinarySearchTree {

    // Root node of the tree, initially pointing to null to represent an empty tree.
    Node root;

    /**
     * Inner class representing a node in the binary search tree.
     * Each node contains a value and references to its left and right children.
     */
    class Node {
        int value;    // Value stored in the node.
        Node left;    // Reference to the left child.
        Node right;   // Reference to the right child.

        /**
         * Constructor to initialize a node with a specific value.
         *
         * @param value The value to store in the node.
         */
        private Node(int value) {
            this.value = value;
        }
    }

    /**
     * Inserts a value into the binary search tree.
     *
     * @param value The value to insert.
     * @return true if the value was successfully inserted, false if the value already exists.
     */
    public boolean insert(int value) {
        Node newNode = new Node(value); // Create a new node with the given value.

        // If the tree is empty, set the root to the new node.
        if (root == null) {
            root = newNode;
            return true; // Value inserted successfully as the root node.
        }

        Node temp = root; // Start at the root node.
        while (true) {
            if (newNode.value == temp.value) return false; // Duplicate value, not inserted.

            if (newNode.value < temp.value) {
                // Move to the left if the new value is smaller.
                if (temp.left == null) {
                    temp.left = newNode; // Insert as the left child.
                    return true; // Value inserted successfully.
                }
                temp = temp.left; // Move to the left child.
            } else {
                // Move to the right if the new value is larger.
                if (temp.right == null) {
                    temp.right = newNode; // Insert as the right child.
                    return true; // Value inserted successfully.
                }
                temp = temp.right; // Move to the right child.
            }
        }
    }

    /**
     * Checks whether a value exists in the binary search tree.
     *
     * @param value The value to search for.
     * @return true if the value exists in the tree, false otherwise.
     */
    public boolean contains(int value) {
        Node temp = root; // Start at the root node.

        // Traverse the tree while the current node is not null.
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left; // Move to the left child if the value is smaller.
            } else if (value > temp.value) {
                temp = temp.right; // Move to the right child if the value is larger.
            } else {
                return true; // Value found in the tree.
            }
        }
        return false; // Value not found in the tree.
    }
}
