package com.nextswe.prep.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

public class P797 {
    public void allPathsSourceTarget(int[][] graph, int start_vertex, int end_vertex, List<Integer> paths, List<List<Integer>> finalList) {
        if(start_vertex==end_vertex){
            paths.add(end_vertex);
            List<Integer> lst = new ArrayList<>(paths);
            finalList.add(lst);
        }else{
            paths.add(start_vertex);
            int[] vertices = graph[start_vertex];
            for(int vertex : vertices){
                allPathsSourceTarget(graph, vertex, end_vertex,paths,finalList);
                paths.remove(paths.size()-1);
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        allPathsSourceTarget(graph,0,graph.length-1,paths,finalList);
        return finalList;
    }
}
