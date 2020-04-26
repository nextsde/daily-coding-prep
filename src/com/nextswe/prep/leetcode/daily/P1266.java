package com.nextswe.prep.leetcode.daily;

public class P1266 {
    //was about to go in backtracking mode
    //from related topics found it has geometry tag.
    //remembered high school math :)
    //didn't even need high school math
    //took some time to come up with the final solution :(
    public int minTimeToVisitAllPoints(int[][] points) {
        double minDistance = 0;
        for(int i=0;i<points.length-1;i++){
            int cx = points[i][0];
            int cy = points[i][1];

            int nx = points[i+1][0];
            int ny = points[i+1][1];

            minDistance =  minDistance + Math.max(Math.abs(nx-cx),Math.abs(ny-cy));
        }
        return (int)minDistance;
    }

    public static void main(String[] args){
        P1266 mP1266 = new P1266();
        System.out.println(mP1266.minTimeToVisitAllPoints(
                new int[][]{
                        {1,1},{3,4},{-1,0}
                }
        ));

        System.out.println(mP1266.minTimeToVisitAllPoints(
                new int[][]{
                        {3,2},{-2,2}
                }
        ));
    }
}
