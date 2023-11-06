package algorithms;

public class Traverse {
    public void traverse(){
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);


        g.runBFSTraversal(4);
    }
}
