package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

import java.util.*;
///tried solving a leetcode easy problem with graph+bfs
//not a efficient solution, could've been better
//accepted
//did not do any cleanup to this code for future me :D
public class P997 {
    class Edge{
        int y;
        Edge next;
    }

    class Vertex{
        int x;
        int indegree = 0;
        int outdegree = 0;
    }

    class Graph{
        Map<Integer, Edge> edges;
        Map<Integer,Vertex> vertices;
        int nV;
        int nE;
    }

    public void bfs(Graph graph){
        Set<Vertex> visited = new HashSet<Vertex>();
//        Vertex vertex = graph.vertices.get(start);
        Queue<Vertex> queue = new LinkedList<>();
        Edge p;
        int y;
        Collection<Vertex> verts = getAllVertex(graph);
        Iterator itr = verts.iterator();
        while(itr.hasNext()){
            Vertex vertex = (Vertex) itr.next();
            if(!visited.contains(vertex)) {
//                System.out.println("vertex " + vertex.x);
                queue.add(vertex);
                visited.add(vertex);
                while (!queue.isEmpty()) {
                    Vertex vq = queue.poll();
//                    System.out.println("vx.x " + vq.x);
//                    System.out.println("vx.indegree " + vq.indegree);
                    p = graph.edges.getOrDefault(vq.x, null);
//                    p = graph.edges.size() > vq.x ? graph.edges.get(vq.x) : null;
                    while (p != null) {
                        Vertex vy = graph.vertices.get(p.y);
                        if (!visited.contains(vy)) {
                            visited.add(vy);
                            queue.add(vy);
                        }
                        vq.outdegree = vq.outdegree + 1;
                        vy.indegree = vy.indegree + 1;


//                        System.out.println("333 vertex " + vy.x);
//                        System.out.println("333 indegree " + vy.indegree);
//                        System.out.println("333 outdegree " + vy.outdegree);
                        p = p.next;
                    }
                }
            }
//            if(!visited.contains(vertex)){
//                queue.add(vertex);
//                visited.add(vertex);
//                while(!queue.isEmpty()){
//                    Vertex vx = queue.poll();
//                    System.out.println("vx.x "+vx.x);
//                    System.out.println("vx.rank "+vx.rank);
//                    p = graph.nE>=vx.x?graph.edges[vx.x]:null;
//                    while(p!=null){
//                        Vertex vy = graph.vertices.get(p.y);
//                        if(!visited.contains(vy)){
//                            vy.rank = 1;
//                            visited.add(vy);
//                            queue.add(vy);
//                        }else{
//                            vy.rank = vy.rank+1;
//                        }
//                        p = p.next;
//                    }
//                }
//            }
        }
    }

    public void insert_edge(Graph graph, int v1, int v2){
//        System.out.println("v1: "+v1+" v2: "+v2);

        if(!graph.vertices.containsKey(v1)){
            graph.nV++;
            Vertex vertex = new Vertex();
            vertex.x = v1;
            vertex.indegree = 0;
            graph.vertices.put(v1,vertex);
        }

        if(!graph.vertices.containsKey(v2)){
            graph.nV++;
            Vertex vertex = new Vertex();
            vertex.x = v2;
            vertex.indegree = 0;
            graph.vertices.put(v2,vertex);
        }

        Edge edge = new Edge();
        edge.y = v2;
        edge.next = graph.edges.getOrDefault(v1,null);
        graph.edges.put(v1,edge);
    }

    public int findJudge(int N, int[][] trust) {
        if(N==1){
            return 1;
        }
        Graph graph = new Graph();
        graph.nV = 0;
        graph.nE = trust.length;
        graph.edges = new HashMap<>();
        graph.vertices = new HashMap<>();

        for(int i = 1;i<=graph.nE;i++){
            insert_edge(graph,trust[i-1][0],trust[i-1][1]);
        }

        bfs(graph);

        Collection<Vertex> verts = getAllVertex(graph);
        Iterator itr = verts.iterator();
        int vPos = -1;
        int count = 0;
        while(itr.hasNext()){
            Vertex vertex = (Vertex) itr.next();
            if(vertex.indegree==N-1 && vertex.outdegree==0) {
                vPos = vertex.x;
                count++;
//                System.out.println("count " + count);
//                System.out.println("vertex.x: "+ vertex.x+"  vertex.indegree:" + vertex.indegree+"  vertex.outdegree:" + vertex.outdegree);
            }
        }
        if(count==1){
            return vPos;
        }else{
            return -1;
        }
    }

    public Collection<Vertex> getAllVertex(Graph grap){
        return grap.vertices.values();
    }

    public static void main(String args[]){
        P997 p997 = new P997();
//        Utils.println(p997.findJudge(2,new int[][]{{2,1}}));
//        Utils.println(p997.findJudge(3,new int[][]{{1,3},{2,3}}));
//        Utils.println(p997.findJudge(3,new int[][]{{1,3},{2,3},{3,1}}));
//        Utils.println(p997.findJudge(3,new int[][]{{1,2},{2,3}}));
        Utils.println(p997.findJudge(4,new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));

//        Utils.println(p997.findJudge(4,new int[][]{{1,3},{2,3},{3,1},{1,4},{2,4},{3,4}}));
    }
}
