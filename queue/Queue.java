package queue;



public class Queue {

    private Node first;
    private Node last;
    private int length;

   class Node{
       int value;
       Node next;
       Node(int value){
           this.value = value;
       }
   }

   public Queue(int value){
       Node newNode = new Node(value);
       first = newNode;
       last = newNode;
       length = 1;
   }
    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getFirst() {
        if (first == null) {
            System.out.println("First: null");
        } else {
            System.out.println("First: " + first.value);
        }
    }

    public void getLast() {
        if (last == null) {
            System.out.println("Last: null");
        } else {
            System.out.println("Last: " + last.value);
        }
    }

    public void getLength() {
       System.out.println("Length: " + length);
    }

    public void enqueue(int value){
       Node newNode = new Node(value);
       if(length == 0){
           first = newNode;
           last = newNode;
       } else {
           last.next = newNode;
           last = newNode;
       }
       length++;
    }

    public Node dequeue(){
       if(length == 0) return null;
       Node temp = first;
       if(length == 1) {
           first = null;
           last = null;
       } else {
           first = first.next;
           temp.next = null;
       }
       length--;
       return temp;
    }

}

