package queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/*FIFO*/
public class QueueExample {


    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            q.add(i);
            q.add(i);
        }
        System.out.println("Element-===>" + q);

        q.remove();
        int head = q.peek();
        System.out.println(head);

        int size = q.size();

        System.out.println("size is===>>" + size);


        Queue<String> pq = new PriorityQueue<>();
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");

        System.out.println(pq);

        //read top element not remove
        System.out.println(pq.peek());

        //read and remove top element
        System.out.println(pq.poll());
        System.out.println(pq.remove());
        System.out.println(pq);
    }
}
