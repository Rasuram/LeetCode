package allexamples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;

public class OfficeDesign {


    static int getMaxColors(int[] colors, int k) {
        int max = 0;
        for (int i = 0; i < colors.length; i++) {
            int sum_so_far = 0;
            for (int j = i; j < colors.length; j++) {
                // sum of elements so far
                sum_so_far += colors[j];
                // if the sum so far is equal to the given sum
                if (sum_so_far <= k) {
                    max = Math.max(max, (j + 1) - i);
                }
            }
        }
        return max;
    }


    public static Map<Integer, List<Integer>> sortByValueCount(final LinkedHashMap<Integer, List<Integer>> homeListMap) {
        return homeListMap.entrySet()
                .stream().
                        filter(map -> map.getValue().size() > 1)
                .sorted(comparingInt(e -> e.getValue().size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static Map<Integer, List<Integer>> sortByValueCount1(final LinkedHashMap<Integer, List<Integer>> homeListMap) {
        return homeListMap.entrySet()
                .stream().
                        filter(map -> map.getValue().size() == 1)
                .sorted(comparingInt(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static List<Integer> getAscOrder(int[] arr) {
        LinkedHashMap<Integer, List<Integer>> myHashMap = new LinkedHashMap<>();
        for (Integer number : arr) {
            myHashMap.computeIfAbsent(number, age -> new ArrayList<>()).add(number);
        }

        Map<Integer, List<Integer>> map1 = sortByValueCount1(myHashMap);
        Map<Integer, List<Integer>> map = sortByValueCount(myHashMap);
        List<Integer> integers = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map1.entrySet()) {
            integers.add(entry.getKey());
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            integers.addAll(entry.getValue());
        }
        return integers;

    }


    public static void main(String[] args) {

        int[] colors1 = {4, 5, 6, 5, 4, 3};
        int[] colors = {2, 3, 5, 1, 1, 2, 1};
        System.out.println(getMaxColors(colors, 7));
        System.out.println(getAscOrder(colors));

    }
}
