package doordash;

/*
Given a list of time blocks where a particular person is already booked/busy, a start and end time to search between, a minimum duration to search for, find all the blocks of time that a person is free for a potential meeting that will last the aforementioned duration.

Given: start_time, end_time, duration, meetings_list -> suggested_meeting_times

Let's assume we abstract the representation of times as simple integers, so a valid time is any valid integer supported by your environment. Here is an example input:

meetings_list: [3,20], [-2, 0], [0,2], [16,17], [19,23], [30,40], [27, 33]

start_time: -5

end_time: 27

min_duration: 2

expected answer:

free_time: [-5, -2], [23,27]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindAvailableTime {


    void findAvailableTime() {
        int[][] meetingList = {{3, 20}, {-2, 0}, {0, 2}, {16, 17}, {19, 23}, {30, 40}, {27, 33}};
        int start = -5;
        int end = 27;
        int duration = 2;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(meetingList, Comparator.comparingInt(o -> o[0]));
        for (int[] ints : meetingList) {
            int curEnd = Math.min(ints[0], end);
            if (curEnd - start >= duration) {
                ans.add(Arrays.asList(start, curEnd));
            }
            start = Math.max(start, ints[1]);
            if (start >= end)
                break;
        }
        if (end - start >= duration)
            ans.add(Arrays.asList(start, end));

        System.out.println(ans);
    }


    public static void main(String[] args) {

        FindAvailableTime f = new FindAvailableTime();
        f.findAvailableTime();

        //char[] str = "123".toCharArray();


    }
}
