package com.nextswe.prep;

import com.nextswe.prep.utils.Utils;

import java.util.Arrays;
import java.util.List;

public class Main {

    static void swapArrays(){
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[] a1 = {1,2,3};
        int[] a2 = {4,5,6};
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        for(int i=0;i<a1.length;i++){
            int tmp = a2[i];
            a2[i] = a1[i];
            a1[i] = tmp;
        }
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));

    }

    public static List<Integer> kSubArraySum(int A[], int k){
        int[] window = new int[k];
        Arrays.fill(window,0);
        int runningSum = 0;
        int sliding_next_index = 0;
        int sliding_prev_index = 0;
        for(int i=0;i<A.length;i++){
            sliding_prev_index = (i-1+k)%k;
            runningSum -= window[sliding_prev_index];
            sliding_next_index = (i+k)%k;
            window[sliding_next_index] = A[i];

            runningSum += window[sliding_next_index];

            if(i+1>=k){
                System.out.println(Arrays.toString(window));
                runningSum = 0;
            }
        }
        return null;
    }

    static double phi = 0.5*(Math.sqrt(5)+1);

    public static void main(String[] args) {
        swapArrays();
//        int[] arr = Utils.getRandomIntArray(20);
//        System.out.println(Arrays.toString(arr));
//        kSubArraySum(arr,4);
//        System.out.println(323/100);


/*
//        Apr3_P53 apr3P53 = new Apr3_P53();
//        System.out.println(apr3P53.maxSubArray(new int[]{-1}));
        SKGraphBuilder skGraphBuilder = new SKGraphBuilder();
//        SKGraph skg = skGraphBuilder.read_graph();
        SKGraph skg = skGraphBuilder.loadGraph("data/dfs_graph1.txt");
        skGraphBuilder.print_graph(skg);
        skGraphBuilder.initialize_search(skg);
        skGraphBuilder.dfs(skg,1);
//        skGraphBuilder.find_path(1,4);
//        System.out.println("Connected Components: "+skGraphBuilder.connected_components(skg));
//        System.out.println("Two Color Bipartite: "+skGraphBuilder.two_color(skg));

//        int A[] = new int[]{10,7,8,9,1,5};
//        BasicSort.qsort(A);
//        SKHeap.heap_sort_by_extract_min(A);
//        Utils.printArray(A);
//        Apr2_P202 p202 = new Apr2_P202();
//        System.out.println(p202.isHappy(1234));
*/
        System.out.println(Character.getNumericValue('e'));
    }
}
