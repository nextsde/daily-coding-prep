package com.nextswe.prep.backtracking;

import com.nextswe.prep.utils.Utils;

import java.util.*;

//nicely explained
//https://www.youtube.com/watch?v=gBC_Fd8EE8A
public class SimpleMazeSolverIterative {
    private List<Integer> NR_solve_maze(List<List<Integer>> sample_maze, int start, int finish) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();

        visited.add(start);
        path.add(start);

        while(!path.isEmpty() && path.get(path.size()-1)!=finish){
            int currentPoint = path.get(path.size()-1);
            Iterator<Integer> connectedPathIterator = sample_maze.get(currentPoint).iterator();
            boolean foundPath = false;
            while(connectedPathIterator.hasNext()){
                int connectedPoint = connectedPathIterator.next();
                if(!visited.contains(connectedPoint)){
                    foundPath = true;
                    visited.add(connectedPoint);
                    path.add(connectedPoint);
                    break;
                }
            }
            if(!foundPath){
                path.remove(path.size()-1);
            }
        }
        return path;
    }
    public static void main(String[] args){
        SimpleMazeSolverIterative simpleMazeSolverIterative = new SimpleMazeSolverIterative();
        List<List<Integer>> sample_maze = new ArrayList<>();
        for(int i=0;i<9;i++){
            sample_maze.add(new ArrayList<>());
        }

        sample_maze.get(0).add(1);
        sample_maze.get(0).add(3);

        sample_maze.get(1).add(0);
        sample_maze.get(1).add(2);

        sample_maze.get(2).add(1);

        sample_maze.get(3).add(0);
        sample_maze.get(3).add(4);
        sample_maze.get(3).add(6);

        sample_maze.get(4).add(3);
        sample_maze.get(4).add(5);
        sample_maze.get(4).add(7);

        sample_maze.get(5).add(4);

        sample_maze.get(6).add(3);

        sample_maze.get(7).add(4);
        sample_maze.get(7).add(8);

        sample_maze.get(8).add(7);

        List<Integer> lst = simpleMazeSolverIterative.NR_solve_maze(sample_maze,1,8);
        Utils.printList(lst);
    }
}
