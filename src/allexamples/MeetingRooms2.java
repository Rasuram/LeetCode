package allexamples;

/*
* Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
* */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MeetingRooms2 {

    public static int minimumConferenceRooms(int[][] meetings) {

        //{0, 30}, {5, 10}, {15, 20}
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int counter = 0;
        int meetingEnd = meetings[0][1];
        Stack<Integer> schedule = new Stack<>();
        schedule.push(meetingEnd);
        for (int i = 1; i < meetings.length; i++) {
            if (meetingEnd >= meetings[i][1]) {
                schedule.pop();
                meetingEnd = meetings[i][1];
                schedule.push(meetings[i][1]);
            } else {
                schedule.push(meetings[i][1]);
                meetingEnd = meetings[i][1];

            }
        }

        return schedule.size();
    }

    public static void main(String[] args) {

        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        int[][] meetings1 = {{7, 10}, {2, 4}};
        int[][] meetings2 = {{5, 8}, {6, 8}};
        int[][] meetings4 = {{6, 15}, {13, 20}, {6, 17}};
        System.out.println(minimumConferenceRooms(meetings));
        System.out.println(33/2);
        System.out.println(33%2);
    }

}
