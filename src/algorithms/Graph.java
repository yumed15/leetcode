package algorithms;

import java.util.Iterator;
import java.util.LinkedList;
// DFS algorithm in Java

import java.util.*;

public class Graph {
    private int vertices; // Number of vertices
    private List<Integer>[] adjacencyList; // Adjacency list

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v); // For an undirected graph
    }

    // Depth-First Search (DFS) starting from a given vertex
    private void DFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (Integer neighbor : adjacencyList[v]) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }

    void BFS(int s) {
        boolean visited[] = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            for (Integer n : adjacencyList[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void runDFSTraversal(int v) {
        boolean[] visited = new boolean[vertices];
        System.out.println("Following is Depth First Traversal");
        DFS(v, visited);
    }

    public void runBFSTraversal(int v) {
        System.out.println("\nFollowing is Breadth First Traversal");
        BFS(v);
    }

}