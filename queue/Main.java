package queue;

public class Main {
    public static void main(String[] args) {

//        Queue myQueue = new Queue(4);
//
//        myQueue.getFirst();
//        myQueue.getLast();
//        myQueue.getLength();
//
//        System.out.println("\nQueue:");
//        myQueue.printQueue();

//        Queue myQueue = new Queue(1);
//        myQueue.enqueue(2);
//        myQueue.printQueue();

        Queue myQueue = new Queue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        myQueue.dequeue();
        myQueue.printQueue();









    }
}
