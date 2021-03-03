package allexamples;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * max heap. root should be greater than their descendents
 * mini heap- root should be lesser than their descendants
 *
 * time taken for insert max heap : o(logn)
 * for swapping elements min O(1) to O(logn)
 *
 * element insert left 2*i
 * right 2*i+1
 * parent node always i/2;
 *
 * max time to delete elements in heap O(logn)
 *
 *
 * heapSort: delete the element and insert into free spaces in array[][][]|[-]
 * 1.create heap, insert O(nlogn)
 * 2. delete heap, insert into empty
 *
 * heapify uses insert, delete  take O(N)
 *
 *
 *
 * smaller number higher priority
 * larger number higher priority
 *
 *time complexity O(N)
 *
 * if smaller number priority queue use  MINI heap
 * if larger number priority queue use MAX heap
 * */


public class PriorityQueueExam {

    public void mergeAllListsSort(PriorityQueue<List<Integer>> p) {

        List<List<Integer>> li = new LinkedList<>();
        PriorityQueue<List<Integer>> priorityQueue = p;
        while (!priorityQueue.isEmpty()) {
            li.add(priorityQueue.poll());
        }
        System.out.println(li);
    }


    public static void main(String[] args) {
        PriorityQueue<List<Integer>> p = new PriorityQueue<>();
        p.add(Arrays.asList(10, 20, 15, 40, 26));
        p.add(Arrays.asList(60, 67, 12, 77, 23));
        p.add(Arrays.asList(23, 20, 67, 12, 67));
        p.add(Arrays.asList(54, 23, 56, 12, 78));
        //System.out.println(p.poll());
        System.out.println(p);
        System.out.println(p.poll());
        System.out.println(p.poll());
    }
}
