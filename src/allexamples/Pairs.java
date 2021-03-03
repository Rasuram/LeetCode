package allexamples;

import java.util.Arrays;
import java.util.List;

public class Pairs {
    public static int countPairs(List<Integer> numbers, int k) {
        // Write your code here
        int pairs=0;

        for(int i=1;i<numbers.size();i++){
            if(numbers.get(i)==(numbers.get(i-1))+k){
                pairs++;
            }
        }
        return pairs;

    }

    public static void main(String[] args) {
        System.out.println(countPairs(Arrays.asList(1,2,3,4,5,6),2));
    }
}
