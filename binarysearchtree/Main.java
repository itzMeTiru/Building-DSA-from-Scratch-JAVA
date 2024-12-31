package binarysearchtree;

public class Main {
     public static void main(String[] args){

//         BinarySearchTree myBST = new BinarySearchTree();
//         System.out.println("Root = " + myBST.root);

             BinarySearchTree myBST = new BinarySearchTree();

             myBST.insert(2);
             myBST.insert(1);
             myBST.insert(3);

        /*
            THE LINES ABOVE CREATE THIS TREE:
                         2
                        / \
                       1   3
        */



             // ROOT MUST BE PUBLIC FOR THESE LINES TO WORK
             System.out.println("Root: " + myBST.root.value);
             System.out.println("\nRoot->Left: " + myBST.root.left.value);
             System.out.println("\nRoot->Right: " + myBST.root.right.value);


        /*
            EXPECTED OUTPUT:
            ----------------
            Root: 2

            Root->Left: 1

            Root->Right: 3

        */

         }



}
