package allexamples;

class Solution1 {
    public static int maxNumberOfBalloons(String text) {
        int []c = new int[5];
        int min = Integer.MAX_VALUE;
        
        for(char i : text.toCharArray()){
            if(i == 'b')c[0]++;
            else if(i == 'a')c[1]++;
            else if(i == 'l')c[2]++;
            else if(i == 'o')c[3]++;
            else if(i == 'n')c[4]++;
        }
        
        c[2] /= 2;
        c[3] /= 2;
        
        for(int i : c){
            if(i < min)
                min = i;
        }
        
        return min;
    }

    public static void main(String[] args) {
        String s="baonxxoll";
        String s1="qawabawonl";

        String s2="aoollnnololgax";

        System.out.println( maxNumberOfBalloons(s2));



    }
}