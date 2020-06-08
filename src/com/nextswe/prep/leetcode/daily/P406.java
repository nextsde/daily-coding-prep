package com.nextswe.prep.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for(int[] p : people) {
            System.out.print(Arrays.toString(p)+" ");
        }
        //people is sorted in the aforementoned order
        List<int[]> list = new ArrayList<>();
        for(int[] p : people) {
            list.add(p[1], p); // Add p to the p[1]th position. All existing elements get shifted to the right. Their own position don't change in terms of k in (h,k) as k decides the TALLER elements in front of it, which dont change for an Incoming shorter element )
        }

        int i = 0;
        for(int[] p: list){
            people[i++] = p;
        }

        return people;
    }
    public static void main(String[] args){
        P406 mP406 = new P406();
        int[][] people = mP406.reconstructQueue(new int[][]{
                {7,0},{4,4},{7,1},{5,0},{6,0},{5,2}
        });
        System.out.println();
        for(int[] p : people) {
            System.out.print(Arrays.toString(p)+" ");
        }
    }
}
