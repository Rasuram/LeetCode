package queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://www.freecodecamp.org/news/priority-queue-implementation-in-java/
 * */
public class PriorityQueueCheck {

    private void testStringsNaturalOrdering() {
        Queue<String> testStringsPQ = new PriorityQueue<>();
        testStringsPQ.add("abcd");
        testStringsPQ.add("1234");
        testStringsPQ.add("23bc");
        testStringsPQ.add("zzxx");
        testStringsPQ.add("abxy");

        System.out.println("Strings Stored in Natural Ordering in a Priority Queue\n");
        while (!testStringsPQ.isEmpty()) {
            System.out.println(testStringsPQ.poll());
        }
    }


    private void testIntNaturalOrder() {
        Queue<Integer> testStringsPQ = new PriorityQueue<>(new PriorityComparator());
        testStringsPQ.add(1);
        testStringsPQ.add(5);
        testStringsPQ.add(8);
        testStringsPQ.add(3);
        testStringsPQ.add(6);

        System.out.println("Strings Stored in Natural Ordering in a Priority Queue\n");
        while (!testStringsPQ.isEmpty()) {
            System.out.println(testStringsPQ.poll());
        }
    }

    public static void main(String[] args) {
        PriorityQueueCheck p = new PriorityQueueCheck();
        p.testStringsNaturalOrdering();
        p.testIntNaturalOrder();
    }


    class PriorityComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
}
