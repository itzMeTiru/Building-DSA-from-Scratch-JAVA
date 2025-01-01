package binarysearchtree;

public class Main {

    public static void main(String[] args) {

        // Example usage

        /*
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values into the binary search tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Check if specific values exist in the tree
        System.out.println(bst.contains(50)); // true
        System.out.println(bst.contains(25)); // false

        // Attempt to insert a duplicate value
        System.out.println(bst.insert(50)); // false

        // Tree structure visualization (optional)
        System.out.println("Tree structure:");
        printTree(bst.root, 0);
        */

    }

    /**
     * Helper method to print the tree structure.
     * @param node Current node being printed.
     * @param level Depth of the current node in the tree.
     */

    /*
        *Node class is set to default visibility in the Main class\
        * To execute this set it to public
    */
    /*
    public static void printTree(BinarySearchTree.Node node, int level) {
        if (node != null) {
            printTree(node.right, level + 1);
            System.out.println("  ".repeat(level) + node.value);
            printTree(node.left, level + 1);
        }
    } */
}
