package allexamples;

public class CustomSort {


    static boolean isSortedOrder(String[] words, char[] sorOrder) {
        //words s = ["cat","dog","tiger"] //sort order c = ['a','t','d'];
        int lastFound = 0;
        for (String word : words) {
            char c = word.charAt(0);
            boolean itsFound=false;
            for (int j = lastFound; j < sorOrder.length; j++) {
                if (c == sorOrder[j] && j >= lastFound) {
                    lastFound = j;
                    itsFound=true;
                    break;
                }
                itsFound=false;
            }
            if(!itsFound){
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        String[] s = {"cat", "tiger","deer"};
        char[] c = {'c', 't', 't','d'};
        System.out.println(isSortedOrder(s, c));
    }
}
