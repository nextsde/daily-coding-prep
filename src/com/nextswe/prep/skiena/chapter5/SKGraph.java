package com.nextswe.prep.skiena.chapter5;

public class SKGraph {
    public int MAX_VERTEX = 0; //MAXIMUM number of vertices
    public SKEdgeNode[] edges; //adjacency info
    public int[] degree; //outdegree for each vertex
    public int nvertices; //number of vertices in graph
    public int nedges; //number of edges in graph
    public boolean directed; //is the graph directed?

    public SKGraph(int max_vertex, boolean _directed){
        MAX_VERTEX = max_vertex;
        edges = new SKEdgeNode[MAX_VERTEX+1];
        degree = new int[MAX_VERTEX+1];
        nvertices = 0;
        nedges = 0;
        directed = _directed;
    }
}
