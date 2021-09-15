import java.util.LinkedList;
import java.util.Queue;

public class BFSGraphExample {

    private int V;
    private LinkedList<Integer> edges[];


    BFSGraphExample(int v) {
        V = v;
        edges = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    private void addEdge(int source, int destination) {
        edges[source].add(destination);
    }


    public void BFS(int target) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target);
        visited[target] = true;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            System.out.println(poll + "----->");
            for (int n : edges[target]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSGraphExample bfsGraphExample = new BFSGraphExample(4);
        bfsGraphExample.addEdge(0, 1);
        bfsGraphExample.addEdge(0, 2);
        bfsGraphExample.addEdge(1, 2);
        bfsGraphExample.addEdge(2, 0);
        bfsGraphExample.addEdge(2, 3);
        bfsGraphExample.addEdge(3, 3);
        bfsGraphExample.BFS(2);
    }


}
