package com.nextswe.prep.ds_goodrich.chapter14;

public interface Graph<V,E> {
    /* Returns the number of vertices of the graph. */
    int numVertices();
    /* Returns the number of edges of the graph. */
    int numEdges();
    /* Returns an iteration of all the vertices of the graph. */
    Iterable<Vertex<V>> vertices();
    /* Returns an iteration of all the edges of the graph. */
    Iterable<Edge<E>> edges();
    /* Returns the number of outgoing edges from vertex v. */
    int outDegree(Vertex<V> v) throws IllegalArgumentException;
    /*
     * Returns the number of incoming edges to vertex v.
     * For an undirected graph, this returns the same value as does outDegree(v).
     */
    int inDegree(Vertex<V> v) throws IllegalArgumentException;
    /* Returns an iteration of all outgoing edges from vertex v. */
    Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException;
    /*
     * Returns an iteration of all incoming edges to vertex v.
     * For an undirected graph, this returns the same collection as does outgoingEdges(v).
     */
    Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException;
    /*
     * Returns the vertices of edge e as an array of length two.
     * If the graph is directed, the first vertex is the origin, and
     * the second is the destination. If the graph is undirected, the order is arbitrary
     */
    Vertex<V>[] endVertices(Edge<E> e) throws IllegalArgumentException;
    /* Returns the vertex opposite to vertex v on edge e */
    Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException;
    /* Inserts and returns a new vertex with the given element */
    Vertex<V> insertVertex(V element);
    /* Inserts and returns a new edge between vertices u and v, storing given element */
    Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) throws IllegalArgumentException;
    /* Returns the edge from u to v, or null if they are not adjacent */
    Edge<E> getEdge(Vertex<V> u, Vertex<V> v);
    /* Removes a vertex and all its incident edges from the graph */
    void removeVertex(Vertex<V> v) throws IllegalArgumentException;
    /* Removes an edge from the graph */
    void removeEdge(Edge<E> e) throws IllegalArgumentException;
}
