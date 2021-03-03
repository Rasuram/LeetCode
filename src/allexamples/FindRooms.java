package allexamples;
/*
*
* Good morning! Here's your coding interview problem for today.

This problem was asked by Snapchat.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
* */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindRooms {


    public int numberOfRooms(int[][] timeIntervals) {
        Arrays.sort(timeIntervals, Comparator.comparingInt(o -> o[1]));
        //({0, 40}, (0, 50),(0, 60) (30, 75), (60, 150)
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < timeIntervals.length; i++) {
            int[] timeslot = timeIntervals[i];
            for (int j = i + 1; j < timeIntervals.length; j++) {
                int key = timeIntervals[j][1];
                if (timeslot[0] < timeIntervals[j][0] && timeslot[1] < timeIntervals[j][1]) {
                    m.put(key, 1);
                }
            }
        }

        return m.size();
    }


    public static void main(String[] args) {
        FindRooms f = new FindRooms();
        int[][] meetingList = {{30, 75}, {0, 50}, {0, 60}, {0, 40}, {60, 150},{110, 200}};
        System.out.println(f.numberOfRooms(meetingList));
    }
}
