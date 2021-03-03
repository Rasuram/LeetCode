package allexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIveStar {

    private int fiveStarReviews(List<List<Integer>> productRatings, int ratingThreshold) {

        int count = 0;
        int i = 0;
        int j = 0;

        while (i < productRatings.size()) {
            int five = productRatings.get(i).get(0);
            int totalrevie = productRatings.get(i).get(1);
            if (Math.ceil(five + j) * 100 / (totalrevie + j) < ratingThreshold) {
                j++;
                count++;
            } else {
                i++;
                j = 0;
            }
        }

        return count;

    }


    public int findCircleNum(List<String> isConnected) {
        boolean[] visited = new boolean[isConnected.size()];
        int size = isConnected.size();
        int[][] a = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = Integer.parseInt(String.valueOf(isConnected.get(i).charAt(j)));
            }
        }
        int cnt = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i, a, visited);
                cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int v, int[][] mat, boolean[] visited) {
        if (!visited[v]) {
            visited[v] = true;
        }
       //  "101010",
        // "01101",
        // "01010",
        // "10101",
        // "10010"
        for (int i = 0; i < mat.length; i++) {
            if (mat[v][i] == 1 && !visited[i]) {
                dfs(i, mat, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        l1.add(4);
        l1.add(10);

        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(2);

        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(9);

        List<Integer> l4 = new ArrayList<>();
        l4.add(2);
        l4.add(3);


        List<Integer> l5 = new ArrayList<>();
        l5.add(3);
        l5.add(6);

        List<Integer> l6 = new ArrayList<>();
        l6.add(0);
        l6.add(2);


        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);
        l.add(l5);
        l.add(l6);

        FIveStar f = new FIveStar();
        System.out.println(f.fiveStarReviews(l, 44));

        List<String> isConnected = new ArrayList<>();

        f.findCircleNum(Arrays.asList("10101", "01101", "01010", "10101", "10010"));
    }
}
