package DoublyLinkedlist;

public class Main {
    public static void main(String[] args){
//        DoublyLinkedList myDLL = new DoublyLinkedList(7);
//        myDLL.getHead();
//        myDLL.getTail();
//        myDLL.getLength();
//        myDLL.printList();

//        DoublyLinkedList myDLL = new DoublyLinkedList(1);
//        myDLL.printList();
//        myDLL.append(2);
//        myDLL.printList();


//        DoublyLinkedList myDLL = new DoublyLinkedList(1);
//        myDLL.append(2);
//
//        // (2) Items - Returns 2 Node
//        System.out.println(myDLL.removeLast().value);
//        // (1) Item - Returns 1 Node
//        System.out.println(myDLL.removeLast().value);
//        // (0) Items - Returns null
//        System.out.println(myDLL.removeLast());


//        DoublyLinkedList myDLL = new DoublyLinkedList(2);
//        myDLL.append(3);
//
//        System.out.println("Before prepend():");
//        System.out.println("-----------------");
//        myDLL.getHead();
//        myDLL.getTail();
//        myDLL.getLength();
//
//        System.out.println("\nDoubly Linked List:");
//        myDLL.printList();
//
//        myDLL.prepend(1);
//
//        System.out.println("\n\nAfter prepend():");
//        System.out.println("----------------");
//        myDLL.getHead();
//        myDLL.getTail();
//        myDLL.getLength();
//
//        System.out.println("\nDoubly Linked List:");
//        myDLL.printList();


//        DoublyLinkedList myDLL = new DoublyLinkedList(0);
//        myDLL.append(1);
//        myDLL.append(2);
//        myDLL.append(3);
//
//
//        System.out.println(myDLL.get(3).value);



        DoublyLinkedList myDLL = new DoublyLinkedList(0);
        myDLL.append(1);
        myDLL.append(2);
        myDLL.append(3);

        System.out.println("DLL before set():");
        myDLL.printList();

        myDLL.set(2, 99);

        System.out.println("\nDLL after set():");
        myDLL.printList();





    }
}
