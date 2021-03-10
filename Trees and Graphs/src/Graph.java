import java.util.ArrayList;
import java.util.List;

public class Graph {
    int vertices;
    List<List<Integer>> adj;

    Graph(int v) {
        this.vertices = v;
        for(int i=0; i<vertices; i++)
            adj.add(new ArrayList<>());
    }
}
