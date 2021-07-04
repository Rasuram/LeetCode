package allexamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode3 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        // because we will stop searching the next possible combination if target minus the candidate is less than zero
        // , so we need to sort the candidates to make the order by ascending
        //   Arrays.sort(candidates);
        exchange(candidates, 0, target, answer, new LinkedList<>());

        return answer;
    }

    private static void exchange(int[] candidates, int start, int target, List<List<Integer>> answer, LinkedList<Integer> temp) {
        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            exchange(candidates, i, target - candidates[i], answer, temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        int combinationSum[] = new int[]{2,3,5};
        List<List<Integer>> list = combinationSum(combinationSum, 8);
        System.out.println(list);
    }
}
