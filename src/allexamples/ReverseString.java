package allexamples;

public class ReverseString {



    void reverse(){
        String str = "Hello world";
        String reverse="";
        for(int i=str.length()-1;i>=0;i--){
            reverse+=str.charAt(i);
        }
        System.out.println(reverse);
    }




    public static void main(String[] args) {
        ReverseString rev = new ReverseString();
        rev.reverse();
    }
}
