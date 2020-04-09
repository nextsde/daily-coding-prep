package com.nextswe.prep.backtracking;

import com.nextswe.prep.utils.Utils;

import java.util.*;

//nicely explained
//https://www.youtube.com/watch?v=gBC_Fd8EE8A
public class SimpleMazeSolverRecursive {
    private boolean R_solve_maze(List<List<Integer>> sample_maze, int start, int finish, Set<Integer> visited, List<Integer> path) {
        if(start==finish){
            path.add(0,start);
            return true;
        }
        visited.add(start);
        for (int connectedPoint : sample_maze.get(start)) {
            if (!visited.contains(connectedPoint)) {
                if (R_solve_maze(sample_maze, connectedPoint, finish, visited, path)) {
                    path.add(0, start);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean R_solve_maze2(List<List<Integer>> sample_maze, int start, int finish, Set<Integer> visited, List<Integer> path) {
        if(start==finish){
            path.add(start);
            return true;
        }
        visited.add(start);
        for (int connectedPoint : sample_maze.get(start)) {
            if (!visited.contains(connectedPoint)) {
                path.add(start);
                if(R_solve_maze2(sample_maze,connectedPoint,finish,visited,path)){
                    return true;
                }
                path.remove(path.size()-1);
            }
        }
        return false;
    }

    private List<Integer> R_solve_maze(List<List<Integer>> sample_maze, int start, int finish) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        R_solve_maze(sample_maze,start,finish,visited,path);
        return path;
    }

    public static void main(String[] args){
        SimpleMazeSolverRecursive simpleMazeSolverIterative = new SimpleMazeSolverRecursive();
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

        List<Integer> lst = simpleMazeSolverIterative.R_solve_maze(sample_maze,2,8);
        Utils.printList(lst);
    }
}
