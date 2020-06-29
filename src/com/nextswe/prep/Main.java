package com.nextswe.prep;

import com.nextswe.prep.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    private static void decisionTaker(String input, String output, int start, int end){
        if(start==end){
            System.out.println(output);
        }else{
            //we need take decision as to whether to choose the character from the input or not
            decisionTaker(input, output, start+1,end);
            decisionTaker(input, output+input.substring(start,start+1), start+1,end);
        }
    }


    public static void main(String[] args) {
        decisionTaker("abc", "",0,3);
//        swapArrays();
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
//        System.out.println(Character.getNumericValue('e'));
//        System.out.println("TAG -> processNotification "+String.valueOf("processNotification".hashCode()));
//        String download_link = "https://play.google.com";
//        if((download_link.startsWith("market://") || download_link.startsWith("https://play.google.com"))
//           || !(download_link.startsWith("http://")||download_link.startsWith("https://"))){
//            System.out.println("aaa");
//            int idOf = download_link.indexOf("?id=");
//
//            String pname = download_link;
//
//            if(idOf!=-1){
//                pname = download_link.substring(idOf + 4);
//            }
//            if(pname.contains("&")){
//                String part = download_link.substring(download_link.indexOf("&"));
//                pname = pname.replace(part, "");
//            }
//            System.out.println(pname);
//        };
    }
}
