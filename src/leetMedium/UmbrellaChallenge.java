package leetMedium;

import java.util.Arrays;
import java.util.Comparator;

public class UmbrellaChallenge {

    public static int maxEvents(int[] arrivals, int[] departures) {

        int[][] events = new int[arrivals.length][2];
        for (int i = 0; i < arrivals.length; i++) {
            events[i][0] = arrivals[i];
            events[i][1] = arrivals[i] + departures[i];
        }

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int totalEvents = 0;
        int currentEventEndTime = events[0][1];

        for (int i = 1; i < events.length - 1; i++) {
            if (currentEventEndTime <= events[i + 1][0]) {
                currentEventEndTime = events[i + 1][1];
                totalEvents++;
            }
        }
        return totalEvents + 1;
    }


    public static void main(String[] args) {
        int[] arrivals = {1, 3, 3, 5, 7};
        int[] duration = {2, 2, 1, 2, 1};
        System.out.println(maxEvents(arrivals, duration));

    }
}
