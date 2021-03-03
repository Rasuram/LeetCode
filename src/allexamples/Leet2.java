package allexamples;

import java.util.Arrays;

public class Leet2 {



    public static String interpret(String command) {
        StringBuilder s = new StringBuilder();
        for(int i=0;i<command.length();i++){
            char c = command.charAt(i);

            if(command.charAt(i)=='G' && i==command.length()-1){
                s.append("G");
                break;
            }
            if(c=='G' && command.charAt(i+1)=='(' || c=='G' && command.charAt(i+1)=='G' ){
                s.append("G");

            }
            if(c=='(' && command.charAt(i+1)==')'){
                s.append("o");

            }

            if(c=='(' && command.charAt(i+1)=='a'){
                s.append("al");
            }

        }
        return s.toString();

    }

    public static void main(String[] args) {
        String command = "GGG" ;

        System.out.println(interpret(command));
        System.out.println(Math.ceil(63));
        System.out.println(Math.floor(63));
        System.out.println(Math.round(63/5)*5+5);
    }
}
