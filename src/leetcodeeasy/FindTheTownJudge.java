package leetcodeeasy;

/*
* In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
* */

import java.util.Arrays;

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] marked = new int[N + 1];
        boolean[] trustAnotherPerson = new boolean[N + 1];
        Arrays.fill(marked, 1);
        for (int[] trustRelation : trust) {
            marked[trustRelation[1]]++;
            marked[trustRelation[0]]--;
            // trustAnotherPerson[trustRelation[0]] = true;
        }
        int res = -1;
        for (int index = 1; index <= N; index++) {
            if (marked[index] == N) {
                res = index;
                break;
            }
        }
        return res;
    }

    public int findJudge1(int N, int[][] trust) {
        int[] marked = new int[N + 1];
        boolean[] trustAnotherPerson = new boolean[N + 1];
        Arrays.fill(marked, 1);
        for (int[] trustRelation : trust) {
            marked[trustRelation[1]] += 1;
            trustAnotherPerson[trustRelation[0]] = true;
        }
        int res = -1;
        for (int index = 1; index <= N; index++) {
            if (marked[index] == N && !trustAnotherPerson[index]) {
                res = index;
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        FindTheTownJudge findJudge = new FindTheTownJudge();
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        int[][] trust2 = {{1, 3}, {2, 3}, {3, 1}};
        int[][] trust1 = {{1, 2}};
        //System.out.println(findJudge.findJudge(2, trust1));
        System.out.println(findJudge.findJudge(4, trust));

    }
}
