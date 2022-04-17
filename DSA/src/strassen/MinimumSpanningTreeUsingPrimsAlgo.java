//KAKOLLU NARESH KUMAR 11200862  CSCE 5150.003 Program No.4
package strassen;

import java.util.Arrays;

public class MinimumSpanningTreeUsingPrimsAlgo {
    public void findMinMST(int Graph[][], int Vertices) {


        int MAX = 9999999;

        int no_of_edges; // number of edges

        // Array to store visited vertices
        // Visted vertices  will become true otherwise false by default
        boolean[] visited = new boolean[Vertices];

        // Fill visited array with false initially as there will be no edges in graph.
        Arrays.fill(visited, false);

        // Make number of edges to 0
        no_of_edges = 0;

       /* In a minimum spanning tree, the maximum number of egdes will always be fewer than (V -1),
           where V is the number of vertices in the graph.
        */

        //Randomly choose any vertex but for simplicity choose 0th vertex and make it true
        visited[0] = true;

        // print all edges and relative weights
        System.out.println("Edge between  two vertices : Relative Weight");

        while (no_of_edges < Vertices - 1) {
          /*  Find all nearby vertices for each vertex in the collection S
          and calculate the distance from the vertex chosen in step 1.
           If the vertex already exists in the set S, discard it; otherwise, in step 1,
           choose another vertex that is closest to the selected vertex.
           */

            int min = MAX;
            int x = 0; // row of matrix
            int y = 0; // column of matrix

            for (int i = 0; i < Vertices; i++) {
                if (visited[i] == true) {
                    for (int j = 0; j < Vertices; j++) {
                        // if the vertex is not selected and there is an edge between two vertices
                        if (!visited[j] && Graph[i][j] != 0) {
                            if (min > Graph[i][j]) {
                                min = Graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " :  " + Graph[x][y]);
            visited[y] = true;
            no_of_edges++;
        }
    }

    public static void main(String[] args) {
        MinimumSpanningTreeUsingPrimsAlgo g = new MinimumSpanningTreeUsingPrimsAlgo();

        // number of vertices in graph
        int Vertices = 8;

        // 2 dimensional  array of size 8x8
        //Below is  a adjacency matrix representation using weighted graph
        //Verified graph given in pdf PA4 and this algorithm is working as expected
        int[][] Graph = {
                { 0, 6, 14, 8, 5, 0, 0, 0},
                { 6, 0, 0, 0, 12, 0, 0, 0},
                { 14, 0, 0, 3, 0, 0, 0, 0},
                { 8, 0, 3, 0, 0, 10, 0, 0},
                { 5, 12, 0, 0, 0, 7, 9 ,0},
                { 0, 0, 0, 10, 7, 0, 0,15},
                { 0, 0, 0, 0, 9, 0, 0, 0},
                { 0, 0, 0, 0, 0, 15, 0,0 }
        };

        g.findMinMST(Graph, Vertices);
    }
}
