package leetcodeeasy;

/*
*
* Example 1:

Input: s = "III"
Output: 3
Example 2:

Input: s = "IV"
Output: 4
Example 3:

Input: s = "IX"
Output: 9
Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*
* */
public class RomanNumber {
    public int romanToInt(String s) {
        int counter = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            switch (c) {
                case 'I':
                    counter += 1;
                    break;
                case 'V':
                    if (i - 1 >= 0 && arr[i - 1] == 'I') {
                        counter += 3;
                    } else {
                        counter += 5;
                    }
                    break;
                case 'X':
                    if (i - 1 >= 0 && arr[i - 1] == 'I') {
                        counter += 8;
                    } else {
                        counter += 10;
                    }
                    break;
                case 'L':
                    if (i - 1 >= 0 && arr[i - 1] == 'X') {
                        counter += 30;
                    } else {
                        counter += 50;
                    }
                    break;
                case 'C':
                    if (i - 1 >= 0 && arr[i - 1] == 'X') {
                        counter += 80;
                    } else {
                        counter += 100;
                    }
                    break;
                case 'D':
                    if (i - 1 >= 0 && arr[i - 1] == 'C') {
                        counter += 300;
                    } else {
                        counter += 500;
                    }
                    break;
                case 'M':
                    if (i - 1 >= 0 && arr[i - 1] == 'C') {
                        counter += 800;
                    } else {
                        counter += 1000;
                    }
                    break;
            }
        }
        return counter;

    }

    public static void main(String[] args) {
        RomanNumber r = new RomanNumber();
         System.out.println(r.romanToInt("III"));
        System.out.println(r.romanToInt("IV"));
        System.out.println(r.romanToInt("IX"));
        System.out.println(r.romanToInt("LVIII"));
        System.out.println(r.romanToInt("MCMXCIV"));
        System.out.println(r.romanToInt("MCDLXXVI"));


    }
}
