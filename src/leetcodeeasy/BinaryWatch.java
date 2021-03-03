package leetcodeeasy;

import java.util.ArrayList;
import java.util.List;

/*
*
* A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
Each LED represents a zero or one, with the least significant bit on the right.
* For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
* */
public class BinaryWatch {

    public static List<String> readBinaryWatch(int num) {
        List<String> binaryWatch = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == num) {
                    String binary = hour + ":";
                    if (minute < 10) {
                        binary += "0";
                    }
                    binary += minute;
                    binaryWatch.add(binary);
                }
            }
        }
        return binaryWatch;
    }

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
    }
}
