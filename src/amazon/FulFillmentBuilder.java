package amazon;

import java.util.Arrays;

public class FulFillmentBuilder {


    static int numberOfParts(int[] parts) {
        int startIndex = 0;
        int endIndex = 1;
        int sum = 0;
        Arrays.sort(parts);
        while (endIndex <= parts.length - 1) {
            parts[endIndex] = parts[startIndex] + parts[endIndex];
            sum+=parts[endIndex];
            startIndex = endIndex;
            endIndex++;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] parts = {8, 4, 6, 12};
        System.out.println(numberOfParts(parts));
    }
}
