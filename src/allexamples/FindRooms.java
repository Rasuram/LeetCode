package allexamples;
/*
*
* Good morning! Here's your coding interview problem for today.

This problem was asked by Snapchat.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
*
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

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


    //
    //     5 7
    //            30 31
    //            6,8
    //            10 12
    //            31 34
    //            6 7
    //            9 10
    //
    // input: [
    //                [[5, 7], [30, 31]],           // device 1
    //                [[6, 8], [10, 12], [31, 34]], // device 2
    //                [[6, 7], [9, 10]],            // device 3
    // ]
    // output: [[5, 8], [9, 12], [30, 34]]

    public static int[][] to2dArrayFromList(ArrayList<ArrayList<Integer>> result) {
        int[][] resArray = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> row = result.get(i);
            resArray[i] = new int[]{row.get(0), row.get(1)};
        }
        return resArray;
    }


      // int[][][] intArray = {{{5, 7}, {30, 31}}, {{6, 8}, {10, 12}, {31, 34}}, {{6, 7}, {9, 10}}};
/*    * Solution Approach:
    *
    * converting 3d to 2d array and sort them as like what we dis in first approach
    *  // int[][] intArray = {{{5, 7},{6, 7},{6, 8},{9, 10},{10, 12} {30, 31}},{31, 34}}};
    * once sort complete
      moving pointers by comparing the values of each array and determine the ON and OFF cases
      its just swapping concept and finally im copying until point of intervals participated.
    *
    *
    * */

    public static int[][] twoDimArrayToString(int[][][] offlineIntervals) {
        // int[][][] intArray = {{{5, 7}, {30, 31}}, {{6, 8}, {10, 12}, {31, 34}}, {{6, 7}, {9, 10}}};
        List<int[]> list = new LinkedList<>();
        list.addAll(Arrays.asList(offlineIntervals[0]));
        list.addAll(Arrays.asList(offlineIntervals[1]));
        list.addAll(Arrays.asList(offlineIntervals[2]));

        int[][] intervals = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            int[] row = list.get(i);
            intervals[i] = row;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        // int[][] intArray = {{{5, 7},{6, 7},{6, 8},{9, 10},{10, 12} {30, 31}},{31, 34}}};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int size = 0;
        int first = intervals[0][0];
        int second = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (second >= intervals[i][0] && second <= intervals[i][1]) {
                second = intervals[i][1];
            } else {
                intervals[size][0] = first;
                intervals[size][1] = second;
                first = intervals[i][0];
                second = intervals[i][1];
                size++;
            }
        }
        intervals[size][0] = first;
        intervals[size][1] = second;
        return Arrays.copyOf(intervals, size + 1);
    }

    /*static String[] getMovieTitles(String substr) {
        String response;
        int startPage = 1;
        int totalPages = Integer.MAX_VALUE;
        List<String> titles = new ArrayList<>();
        while (startPage <= totalPages) {
            try {
                URL obj = new URL("https://jsonmock.hackerrank.com/api/food_outlets/?city=Denver&page=" + 1);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((response = in.readLine()) != null) {
                    Outlets convertedObject = new Gson().fromJson(response, Outlets.class);
                    totalPages = convertedObject.get("total_pages").getAsInt();
                    JsonArray data = convertedObject.getAsJsonArray("data");
                    for (int i = 0; i < data.size(); i++) {
                        String title = data.get(i).getAsJsonObject().get("Title").getAsString();
                        titles.add(title);
                    }
                }
                in.close();
                startPage++;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        Collections.sort(titles);
        return titles.toArray(new String[0]);
    }*/

    class Outlets {
        int page;
        int per_page;
        int total;
        int total_pages;
        Restaurant data;
    }


    class Restaurant {
        String city;
        String name;
        int estimated_cost;
        Rating user_rating;
        int id;
    }

    class Rating {
        double average_rating;
        int votes;
    }


    public static void main(String[] args) {
        FindRooms f = new FindRooms();
        int[][] meetingList = {{30, 75}, {0, 50}, {0, 60}, {0, 40}, {60, 150}, {110, 200}};
        System.out.println(f.numberOfRooms(meetingList));
        int[][][] intArray = {{{5, 7}, {30, 31}}, {{6, 8}, {10, 12}, {31, 34}}, {{6, 7}, {9, 10}}};
        System.out.println(twoDimArrayToString(intArray));

        // System.out.println(countWords("How many eggs are in a half-dozen, 13?"));

        //System.out.println(getMovieTitles("Denver"));

        System.out.println("tes123cchhh".matches(".*\\d.*"));
    }
}
