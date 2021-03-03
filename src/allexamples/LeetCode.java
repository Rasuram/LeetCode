package allexamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode {


    public static void main(String[] args) {

        //code1
       /* int[] number = new int[]{3, 2, 6, 1, 5, 9};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (number[i] < number[j]) {
                    int temp = number[j];
                    number[j] = number[i];
                    number[i] = temp;
                }
            }
        }

      //  int[] number = new int[]{3, 2, 6, 1, 5, 9};
      //  List<Integer> missingElements = new ArrayList<>();
        int smallestNumber=0;
        for(int k=1;k<number.length-1;k++){

            if(number[k]+1!=number[k+1]){
                if(smallestNumber==0 || smallestNumber > number[k]+1){
                    smallestNumber = number[k]+1;
                }
            }

        }

        System.out.println(smallestNumber);*/


        //code2:

        Calander calander = new Calander("10:30","11:00");
        Calander calander1 = new Calander("12:30","1:30");

        Calander calanderx = new Calander("11:30","12:30");
        Calander calander1y = new Calander("12:30","1:30");

        List<Calander> calanders = new ArrayList<>();
        calanders.add(calander);
        calanders.add(calander1y);

        List<Calander> calanders1 = new ArrayList<>();
        calanders1.add(calanderx);
        calanders1.add(calander1);

        Map<String,Integer> map = new HashMap<>();
        calc(calanders, map);
        calc(calanders1, map);

    }

    private static void calc(List<Calander> calanders, Map<String, Integer> map) {
        for (int i=1;i<calanders.size();i++){
            Calander curr = calanders.get(i-1);
            Calander next = calanders.get(i);
            int endTime = Integer.parseInt(curr.getEndDate().split(":")[1]);
            int startTime = Integer.parseInt(next.getStartDate().split(":")[1]);

            if((startTime-endTime)>=30) {
                if (map.containsKey(curr.getEndDate())) {
                    map.put(curr.getEndDate(), map.get(curr.getEndDate())+1);
                }else{
                    map.put(curr.getEndDate(), 1);
                }
            }

        }
    }


    static class Calander{
        public String getStartDate() {
            return startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        String startDate;
        String endDate;
        Calander( String startDate, String endDate){
            this.startDate = startDate;
            this.endDate = endDate;
        }

    }

}
