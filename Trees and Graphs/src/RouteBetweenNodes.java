import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        //building graph
        graph.adj.get(0).add(1);
        graph.adj.get(1).add(2);
        graph.adj.get(3).add(1);
        graph.adj.get(3).add(2);

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.vertices];
        boolean found = false;

        Arrays.fill(visited, false);
        int target = 3;
        q.offer(0);

        while(! q.isEmpty()) {
            int node = q.poll();

            if(! visited[node]) {
                visited[node] = true;

                if(graph.adj.get(node) != null) {
                    for (int neighbor : graph.adj.get(node)) {
                        if (neighbor == target) {
                            found = true;
                            break;
                        }
                        if (!visited[neighbor])
                            q.offer(neighbor);
                    }
                }
            }
        }

        if(found)
            System.out.println("true");
        else
            System.out.println("false");

    }
}
