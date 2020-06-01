package com.nextswe.prep.leetcode.daily;

import java.util.*;

public class P685_trylater {
    class Vertex{
        int data;
        List<Vertex> incoming;
        List<Vertex> outgoing;
    }
    class Edge{
        int v1;
        int v2;
        public Edge(int v1, int v2){
            this.v1 = v1;
            this.v2 = v2;
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        Map<Integer,Vertex> vertexMap = new HashMap<>();
        for(int i=1;i<=edges.length;i++){
            Vertex vv = new Vertex();
            vv.data = i;
            vv.incoming = new ArrayList<>();
            vv.outgoing = new ArrayList<>();
            vertexMap.put(i,vv);
        }
        for(int[] edge: edges){
            Vertex v1 = vertexMap.get(edge[0]);
            Vertex v2 = vertexMap.get(edge[1]);
            v1.outgoing.add(v2);
            v2.incoming.add(v1);
        }
        int min = Integer.MAX_VALUE;
        Vertex root = null;
        for(int i=1;i<=edges.length;i++){
            if(vertexMap.get(i).incoming.size()<min){
                min = vertexMap.get(i).incoming.size();
                root = vertexMap.get(i);
            }
        }
        // System.out.println(root.data);
        List<Edge> list = new ArrayList<>();
        dfs(root, new HashSet<>(),list);
        for(int i=list.size()-1;i>=0;i--){
            Vertex vtx = vertexMap.get(list.get(i).v2);
//            vtx.incoming.get(vtx.incoming.size()-1).data;
            return new int[]{vtx.incoming.get(vtx.incoming.size()-1).data,list.get(i).v2};
//            Vertex vtx = vertexMap.get(list.get(i).v2);
//            if(vtx.incoming.size()>1){
//                for(int j=vtx.incoming.size()-1;j>=0;j--){
//                    if(vtx.incoming.get(j).data!=root.data){
//                        return new int[]{list.get(i).v1,vtx.incoming.get(j).data};
//                    }
//                }
//            }else{
//                return new int[]{list.get(i).v1,list.get(i).v2};
//            }
        }
        return new int[]{};
    }

    private void dfs(Vertex root, Set<Integer> seen, List<Edge> vtxs){
        seen.add(root.data);
        for(Vertex vt: root.outgoing){
            if(seen.contains(vt.data)){
                // System.out.println(vt.data);
                vtxs.add(new Edge(root.data, vt.data));
            }else{
                dfs(vt, seen, vtxs);
            }
        }
    }
}
