package hashTable;

import java.util.ArrayList;

public class HashTable {

    // Default size of the hash table.
    private int size = 7;

    // Array of nodes representing the hash table.
    private Node[] dataMap;

    /**
     * Inner class representing a node in the hash table.
     * Each node contains a key, value, and a reference to the next node (for handling collisions).
     */
    public class Node {
        private String key;  // The key for the node.
        private int value;   // The value associated with the key.
        private Node next;   // Reference to the next node (if there's a collision).

        /**
         * Constructor to initialize a node with a key and value.
         *
         * @param key   The key for the node.
         * @param value The value associated with the key.
         */
        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Constructor to initialize the hash table with the default size.
     */
    public HashTable() {
        dataMap = new Node[size];
    }

    /**
     * Prints the contents of the hash table.
     * Each index is displayed along with the key-value pairs stored at that index.
     */
    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next; // Traverse the linked list at this index.
            }
        }
    }

    /**
     * Hash function to compute the index for a given key.
     *
     * @param key The key to hash.
     * @return The computed index based on the hash function.
     */
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray(); // Convert the key to a character array.
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i]; // Get the ASCII value of the character.
            hash = (hash + asciiValue * 23) % dataMap.length; // Compute the hash value.
        }
        return hash; // Return the computed index.
    }

    /**
     * Inserts a key-value pair into the hash table.
     * Handles collisions using separate chaining with linked lists.
     *
     * @param key   The key to insert.
     * @param value The value associated with the key.
     */
    public void set(String key, int value) {
        int index = hash(key); // Compute the index using the hash function.
        Node newNode = new Node(key, value); // Create a new node.
        if (dataMap[index] == null) {
            // If the index is empty, insert the node directly.
            dataMap[index] = newNode;
        } else {
            // Handle collisions by appending to the linked list.
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    /**
     * Retrieves the value associated with a given key.
     *
     * @param key The key to look up.
     * @return The value associated with the key, or 0 if the key is not found.
     */
    public int get(String key) {
        int index = hash(key); // Compute the index using the hash function.
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) { // Check if the key matches.
                return temp.value; // Return the value if the key is found.
            }
            temp = temp.next; // Traverse the linked list.
        }
        return 0; // Return 0 if the key is not found.
    }

    /**
     * Retrieves all the keys stored in the hash table.
     *
     * @return An ArrayList containing all the keys in the hash table.
     */
    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>(); // Initialize an ArrayList to store keys.
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.key); // Add each key to the ArrayList.
                temp = temp.next; // Traverse the linked list.
            }
        }
        return allKeys; // Return the list of keys.
    }
}
