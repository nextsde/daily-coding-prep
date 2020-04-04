package com.nextswe.prep.tusharroy;

import java.util.*;

//awesome graph adt implementation by tushar roy
//nothing fancy, implemented by seeing tushar roy's code
//https://github.com/mission-peace/interview/tree/master/src/com/interview/graph
//https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/Graph.java

public class TRGraphADT<T> {

    private List<TREdge<T>> allEdges;
    private Map<Long, TRVertex<T>> allVertex;
    boolean isDirected = false;

    public TRGraphADT(boolean isDirected) {
        allEdges = new ArrayList<>();
        allVertex = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addEdge(long id1, long id2) {
        addEdge(id1, id2, 0);
    }

    public void addEdge(long id1, long id2, int weight) {
        TRVertex<T> v1 = null;
        if (allVertex.containsKey(id1)) {
            v1 = allVertex.get(id1);
        } else {
            v1 = new TRVertex<T>(id1);
            allVertex.put(id1, v1);
        }

        TRVertex<T> v2 = null;
        if (allVertex.containsKey(id2)) {
            v2 = allVertex.get(id2);
        } else {
            v2 = new TRVertex<T>(id2);
            allVertex.put(id2, v2);
        }

        TREdge<T> edge = new TREdge<T>(v1, v2, isDirected, weight);
        allEdges.add(edge);
        v1.addEdgeNeighbour(edge, v2);
        if (!isDirected) {
            v2.addEdgeNeighbour(edge, v1);
        }
    }

    public List<TREdge<T>> getAllEdges() {
        return allEdges;
    }

    //only for directed graphs
    public void addVertex(TRVertex<T> v){
        if(allVertex.containsKey(v.getId())){
            return;
        }
        allVertex.put(v.getId(),v);
        for(TREdge<T> e:v.getEdges()){
            allEdges.add(e);
        }
    }

    public TRVertex<T> addSingleVertex(long id){
        if(allVertex.containsKey(id)){
            return allVertex.get(id);
        }
        TRVertex<T> v = new TRVertex<>(id);
        allVertex.put(id,v);
        return v;
    }

    public Collection<TRVertex<T>> getAllVertex() {
        return allVertex.values();
    }

    public void setDataForVertex(long id, T data) {
        if(allVertex.containsKey(id)){
            TRVertex<T> v = allVertex.get(id);
            v.setData(data);
        }
    }
}

class TRVertex<T>{
    long id;
    private T data;
    private List<TREdge<T>> edges = new ArrayList<>();
    private List<TRVertex<T>> neighbours = new ArrayList<>();
    TRVertex(long id){
        this.id = id;
    }
    public long getId(){ return this.id; }
    public void setData(T data){ this. data = data;}
    public T getData(){return this.data;}
    public void addEdgeNeighbour(TREdge<T> e, TRVertex<T> v){this.edges.add(e);this.neighbours.add(v);}
    public String toString(){return String.valueOf(id);}
    public List<TRVertex<T>> getNeighbours(){return this.neighbours;}
    public List<TREdge<T>> getEdges(){return this.edges;}
    public int getDegree(){return edges.size();}
    @Override
    public int hashCode(){
        final int prime = 37;
        int result = 1;
        result = prime * result + (int)(id^ ( id>>>32 ));
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null) return false;
        if(getClass()!=obj.getClass()) return false;
        TRVertex other = (TRVertex) obj;
        if(id!=other.id) return false;
        return true;
    }
}

class TREdge<T>{
    private boolean isDirected = false;
    private TRVertex<T> v1,v2;
    private int weight;

    TREdge(TRVertex<T> v1, TRVertex<T> v2){this.v1 = v1;this.v2 = v2;}
    TREdge(TRVertex<T> v1, TRVertex<T> v2, boolean isDirected){
        this(v1,v2);
        this.isDirected = isDirected;
    }
    TREdge(TRVertex<T> v1, TRVertex<T> v2, boolean isDirected, int weight){
        this(v1,v2,isDirected);
        this.weight = weight;
    }
    TRVertex<T> getVertex1(){return v1;}
    TRVertex<T> getVertex2(){return v2;}
    int getWeight(){return this.weight;}
    public boolean isDirected(){return this.isDirected;}
    @Override
    public int hashCode(){
        final int prime = 37;
        int result = 1;
        result = prime * result + ((v1==null)?0:v1.hashCode());
        result = prime * result + ((v2==null)?0:v2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null) return false;
        if(getClass()!=obj.getClass())return false;
        TREdge other = (TREdge)obj;
        if(v1==null){
            if(other.v1 != null) return false;
        }else if(!v1.equals(other.v1)) return false;
        if(v2==null){
            if(other.v2!=null) return false;
        }else if(!v2.equals(other.v2)) return false;
        return true;
    }
}
