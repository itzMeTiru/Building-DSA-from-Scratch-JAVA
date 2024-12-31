package linkedlist;


public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        //if the LL is empty
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else { //if LL have values
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        //--if LL is empty we don't have any node to return
        if (length == 0) return null;
        //--if multiple items in LL
        Node temp = head;
        head = head.next;
        //remove the first node and decrement length by 1
        temp.next = null;
        length--;
        //--if LL had only one item we have to fix the tail pointing to the removed node
        if (length == 0) {
            tail = null;
        }
        //return the removed node
        return temp;
    }

    public Node get(int index){
        //--Check if the particular index is in the range of indexes
        if(index < 0 || index >= length ) {
            return null; //if not return null
        };
        Node temp = head;
        //move the temp variable to the index that we want to return
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        //set method has the same rules about index range as same as get method
        //so as a shortcut we can you get() to set the temp variable to the node we want
        Node temp = get(index);//return null if node is out of available range
        //if node is the valid range se can change the value
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }


    public boolean insert(int index, int value){
        if(index < 0 || index > length ) return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}