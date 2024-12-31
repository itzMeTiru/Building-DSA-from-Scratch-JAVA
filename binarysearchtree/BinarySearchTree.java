package binarysearchtree;

public class BinarySearchTree {

    //to be able to create an empty tree atm constructor should be pointing to null
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        private Node(int value){
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        //if tree is empty
        if(root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if(newNode.value == temp.value) return false;
            if(newNode.value < temp.value){
                if(temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                //move to next node if it is reserved
                temp = temp.left;
            } else {
                if(temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value){
        // no need for check for null
//        if(root == null) return false;
        Node temp = root;
        while( temp != null) {
            if(value < temp.value){
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

}
