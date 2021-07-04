package allexamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayPermutation {


    public static int[][] getMinimumSubset(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();
        // permuteHelper(result, new ArrayList<>(), arr);
        System.out.println(result);
        return null;
    }


    public static void printCombination(int[] arr, int totalSum) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int k : arr) {
            int n = list.size();
            for (int j = 0; j < n; j++) {
                List<Integer> result = new ArrayList<>(list.get(j));
                result.add(k);
                list.add(result);
            }
        }

        List<List<Integer>> subsets = null;
        int totalDiff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Integer first = list.get(i).stream()
                    .reduce(0, Integer::sum);
            for (int j = i + 1; j < list.size(); j++) {
                Integer second = list.get(j).stream()
                        .reduce(0, Integer::sum);
                int s = (second - first);
                List<Integer> firstSize = list.get(i);
                List<Integer> secondSize = list.get(j);
                int size = firstSize.size() + secondSize.size();
                if (s > 0 && size == arr.length && first + second == totalSum && totalDiff > s) {
                    subsets = new ArrayList<>();
                    subsets.add(firstSize);
                    subsets.add(secondSize);
                    totalDiff = second - first;
                }
            }


        }
        System.out.println(subsets);

    }



    public static void main(String[] args) {

        int[] arr = {5, 10, 15, 20, 25};

        printCombination(arr, 75);
    }
}
