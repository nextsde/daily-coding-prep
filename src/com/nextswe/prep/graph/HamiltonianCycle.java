package com.nextswe.prep.graph;

import com.nextswe.prep.utils.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.youtube.com/watch?v=dQr4wZCiJJ4
//not completed
public class HamiltonianCycle {
    public void hamiltonian(Graph G, int[] x, int k){
        do{
            nextvertex(G, x,k);
            if(x[k]==0)return;
            if(k==G.nv){
                Utils.printArray(x);
                return;
            }
            else hamiltonian(G, x,k+1);
        }while(true);
    }

    public void nextvertex(Graph G, int[] x, int k){
        do{
            x[k] = (x[k]+1)%(G.nv+1);
            if(x[k]==0)return;
            if(G.isEdge(x[k-1],x[k])!=0){
                int j;
                for(j=1;j<=k-1;j++){
                    if(x[j]==x[k]){
                        break;
                    }
                }
                if(j==k){
                    if(k<G.nv || (k==G.nv && G.isEdge(x[G.nv],x[1])!=0))
                        return;
                }
            }
        }while(true);
    }

    public static void main(String[] args){
//        Graph graph = new Graph(6);
//        graph.addEdge(1,2);
//        graph.addEdge(2,3);
//        graph.addEdge(3,4);
//        graph.addEdge(4,5);
//        graph.addEdge(5,1);
//        graph.addEdge(3,1);
//
//        int[] x = new int[]{0,1,0,0,0,0};
//
//        HamiltonianCycle hm = new HamiltonianCycle();
//        hm.hamiltonian(graph,x,2);

    }
}

class Graph{
    int[][] adjMatrix;
    int nv;
    public Graph(int nv){
        this.nv = nv;
        this.adjMatrix = new int[nv][nv];
        for(int i = 1;i<nv;i++){
            for(int j=1;j<nv;j++){
                this.adjMatrix[i][j] = 0;
            }
        }
    }
    void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    int isEdge(int i, int j) {
        return adjMatrix[i][j];
    }
}
