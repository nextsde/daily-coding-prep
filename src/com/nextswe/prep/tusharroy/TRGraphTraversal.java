package com.nextswe.prep.tusharroy;

import com.nextswe.prep.skiena.chapter5.SKGraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//from tushar roy's code
public class TRGraphTraversal {

    public void DFS(TRGraphADT<Integer> graph){
        Set<Long> visited = new HashSet<>();
        for(TRVertex<Integer> vert:graph.getAllVertex()){
            if(!visited.contains(vert.getId())){
                DFSTraverse(vert,visited);
            }
        }
    }

    private void DFSTraverse(TRVertex<Integer> v, Set<Long> visited){
        visited.add(v.getId());
        System.out.print(v.getId()+" ");
        for(TRVertex<Integer> vert: v.getNeighbours()){
            if(!visited.contains(vert.getId()))
                DFSTraverse(vert,visited);
        }
    }

    public void BFS(TRGraphADT<Integer> graph){
        Set<Long> visited = new HashSet<>();
        Queue<TRVertex<Integer>> q = new LinkedList<>();

        for(TRVertex<Integer> vertex:graph.getAllVertex()){
            if(!visited.contains(vertex.getId())){
                q.add(vertex);
                visited.add(vertex.getId());
                while(!q.isEmpty()){
                    TRVertex<Integer> vq = q.poll();
                    System.out.print(vq.getId()+" ");
                    for(TRVertex<Integer> vvv:vq.getNeighbours()){
                        if(!visited.contains(vvv.getId())){
                            q.add(vvv);
                            visited.add(vvv.getId());
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args){
        TRGraphADT trGraph = new TRGraphADT(true);
//        loadGraph(trGraph,"data/graph11.txt");
        trGraph.addEdge(1, 2);
        trGraph.addEdge(1, 3);
        trGraph.addEdge(2, 4);
        trGraph.addEdge(3, 4);
        trGraph.addEdge(4, 6);
        trGraph.addEdge(6, 5);
        //  graph.addEdge(5, 1);
        trGraph.addEdge(5,3);
        TRGraphTraversal trGraphTraversal = new TRGraphTraversal();
        trGraphTraversal.DFS(trGraph);
    }

    //Copied & adjusted according to my need this method from
    //UCSD UCSDGraphs course material from coursera
    //UCSD has a nice course on coursera, do have plans to complete that one later
    /**
     * Loads a graph from a file.  The file is specified with each
     * line representing an edge.  Vertices are numbered from
     * 0..1-numVertices.
     *
     * The first line of the file contains a single int which is the
     * number of vertices in the graph.
     * and the second line number of edges
     * e.g.
     * 4
     * 5
     * 1 2
     * 2 4
     * 4 3
     * 3 1
     * 1 4
     * @param filename The file containing the graph
     */
    public static void loadGraph(TRGraphADT trGraph, String filename)
    {
        BufferedReader reader = null;
        try {
            String nextLine;
            reader = new BufferedReader(new FileReader(filename));
            while((nextLine = reader.readLine()) != null){
                String[] verts = nextLine.split(" ");
                trGraph.addEdge(Integer.parseInt(verts[0]),Integer.parseInt(verts[1]));
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Problem loading graph file: " + filename);
            e.printStackTrace();
        }
    }
}
