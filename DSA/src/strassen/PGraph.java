package strassen;

import java.util.Arrays;

class PGraph {

    public void Prim(int G[][], int V) {

        int INF = 9999999;

        int no_edge; // number of edge

        // create a array to track selected vertex
        // selected will become true otherwise false
        boolean[] selected = new boolean[V];

        // set selected false initially
        Arrays.fill(selected, false);

        // set number of edge to 0
        no_edge = 0;

        // the number of egde in minimum spanning tree will be
        // always less than (V -1), where V is number of vertices in
        // graph

        // choose 0th vertex and make it true
        selected[0] = true;

        // print for edge and weight
        System.out.println("Edge : Weight");

        while (no_edge < V - 1) {
            // For every vertex in the set S, find the all adjacent vertices
            // , calculate the distance from the vertex selected at step 1.
            // if the vertex is already in the set S, discard it otherwise
            // choose another vertex nearest to selected vertex at step 1.

            int min = INF;
            int x = 0; // row number
            int y = 0; // col number

            for (int i = 0; i < V; i++) {
                if (selected[i] == true) {
                    for (int j = 0; j < V; j++) {
                        // not in selected and there is an edge
                        if (!selected[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " :  " + G[x][y]);
            selected[y] = true;
            no_edge++;
        }
    }

    public static void main(String[] args) {
        PGraph g = new PGraph();

        // number of vertices in grapj
        int V = 8;

        // 2 dimensional  array of size 8x8
        //Below is  a adjacency matrix representation
        int[][] G = {
                { 0, 6, 14, 8, 5, 0, 0, 0},
                { 6, 0, 0, 0, 12, 0, 0, 0},
                { 14, 0, 0, 3, 0, 0, 0, 0},
                { 8, 0, 3, 0, 0, 10, 0, 0},
                { 5, 12, 0, 0, 0, 7, 9 ,0},
                { 0, 0, 0, 10, 7, 0, 0,15},
                { 0, 0, 0, 0, 9, 0, 0, 0},
                { 0, 0, 0, 0, 0, 15, 0,0 }
        };

        g.Prim(G, V);
    }

}