package allexamples;/*
*
In a soccer match, a team either earns a win, tie or loss. A win is worth 3 points, a tie is worth 1 point, and a loss is worth 0 points.

Given the number of games played by a soccer team in a season and the number of points earned by the team, give the number of possible combination of wins, ties and losses that the team could have gotten to achieve the given total points.

Input Format

The first input line contains a positive integer, T,denoting the number of teams.

In a soccer match, a team either earns a win, tie or loss. A win is worth 3 points, a tie is worth 1 point, and a loss is worth 0 points.

Given the number of games played by a soccer team in a season and the number of points earned by the team, give the number of possible combination of wins, ties and losses that the team could have gotten to achieve the given total points.

Input Format

The first input line contains a positive integer, T,denoting the number of teams.

Each of these T lines contains two space separated integers: g and p, representing the number of games played and the total points earned by the team,respectively.

Constraints

1<= T <=100000

1<= g <= 10^18

0<= p <= 10^18

Output Format

Print n lines, each line of which contains:

Total number of possible combination of wins, ties and losses.

Sample Input 0

3
6 10
1 3
4 4
Sample Output 0

2
1
2
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoccerMatch {


    void matchResults(int k, int j) {
        int ties = 0;
        int wins = 0;
        while (k > 0) {
            if (j >= 3 && k <= 3) {
                j = j - 3;
                wins = 1;
            } else {
                if (j >= 1) {
                    ties = 1;
                    j = j - 1;
                }
            }
            k--;
        }
        System.out.println(ties + wins);

    }


    public static void main(String[] args) {

        SoccerMatch soccerMatch = new SoccerMatch();
        Scanner scanner = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n > 0) {
            String s[] = scanner.nextLine().split(" ");
            int[] in = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
            list.add(in);
            n--;
        }
        scanner.close();
        for (int[] i : list) {
            soccerMatch.matchResults(i[0], i[1]);
        }
    }

}
