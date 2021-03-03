package allexamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode3 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        for (int value : candidates) {
            List<Integer> list1 = new ArrayList<>();
            int counter1=0;
            while(true){
                counter1+=value;
                list1.add(value);
                if(counter1==target && candidates.length>1){
                    Collections.sort(list1);
                    list.add(list1);
                    break;
                }
                if(counter1 > target){
                    break;
                }
            }
            int counter = value;
            List<Integer> list2 = new ArrayList<>();
            for (int i=0;i< candidates.length ; i++) {
                if (counter == target) {
                    list2.add(value);
                    Collections.sort(list2);
                    list.add(list2);
                    break;
                }
                if(value+candidates[i]==target){
                    List<Integer> list3 = new ArrayList<>();
                    list3.add(candidates[i]);
                    list3.add(value);
                    Collections.sort(list3);
                    list.add(list3);
                    break;
                }
                list2.add(candidates[i]);
                counter += candidates[i];

            }

        }
        return list;
    }

    public static void main(String[] args) {
        int combinationSum[] = new int[]{1};
        combinationSum(combinationSum,2);
    }
}
