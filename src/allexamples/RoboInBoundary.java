package allexamples;

/*
Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.
Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
*
* */

public class RoboInBoundary {


    public static boolean isInBoundary(String instructions) {
        int x = 0;
        int y = 0;
        int[][] arr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        char[] instruct = instructions.toCharArray();
        int direction = 0;
        for (char c : instruct) {
            if (c == 'G') {
                x += arr[direction % 4][0];
                y += arr[direction % 4][1];
            } else if (c == 'R') {
                direction += 1;
            } else if (c == 'L') {
                direction -= 1;
            }

        }
        return (x == 0 && y == 0) || direction % 4 != 0;
    }


    public static void main(String[] args) {
        System.out.println(isInBoundary("GL"));
        System.out.println(isInBoundary("GGLLGG"));

    }
}
