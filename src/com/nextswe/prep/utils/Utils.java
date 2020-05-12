package com.nextswe.prep.utils;

import java.util.List;
import java.util.Random;

public class Utils {
    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
    }

    /* A utility function to print array of size n */
    public static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    /* A utility function to print array of size n */
    public static void printArray(Integer[] arr)
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    /* A utility function to print array of size n */
    public static <K> void printArray(K[] arr)
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static <Integer> void printPlainList(List<Integer> arr)
    {
        int n = arr.size();
        for (int i=0; i<n; ++i)
            System.out.print(arr.get(i)+" ");
        System.out.println();
    }

    public static int arraySum(Object[] arr)
    {
        int n = arr.length;
        int total = 0;
        for (int i=0; i<n; ++i)
            total+=(int)arr[i];
        return total;
    }

    public static int min(int... numbers) {
        int result = Integer.MAX_VALUE;
        for (int each : numbers) {
            result = Math.min(result, each);
        }
        return result;
    }

    public static int max(int... numbers) {
        int result = Integer.MIN_VALUE;
        for (int each : numbers) {
            result = Math.max(result, each);
        }
        return result;
    }

    public static void println(int judge) {
        System.out.println(""+judge);
    }
    public static void println(double judge) {
        System.out.println(""+judge);
    }
    public static void println(boolean judge) {
        System.out.println(""+judge);
    }
    public static void println(String judge) {
        System.out.println(""+judge);
    }

    public static void printListList(List<List<Integer>> groupAnagrams) {
        for (int i=0; i<groupAnagrams.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < groupAnagrams.get(i).size(); j++) {
                System.out.print(groupAnagrams.get(i).get(j) + " ");
            }
            System.out.print("]");System.out.println();

        }
        System.out.println();
    }

    public static void printList(List<Integer> colList) {
        for (int i=0; i<colList.size(); i++) {
            System.out.print("[");
            System.out.print(colList.get(i) + " ");
            System.out.print("]");
        }
        System.out.println();
    }

    public static void printListString(List<String> colList) {
        System.out.print("[");
        for (int i=0; i<colList.size(); i++) {
            System.out.print("\"");
            System.out.print(colList.get(i) + "");
            System.out.print("\",");
        }
        System.out.println("]");
    }

    public static int[] getRandomIntArray(int nItems, int start, int end){
        Random rand = new Random();
        rand.setSeed(System.nanoTime());
        int[] data = new int[nItems];
        for (int i = 0; i < data.length; i++) {
            data[i] = start + rand.nextInt(end-start);
        }
        return data;
    }

    public static int[] getRandomIntArray(int nItems, int bound){
        return getRandomIntArray(nItems,0,bound);
    }

    public static int[] getRandomIntArray(int nItems){
        return getRandomIntArray(nItems,100);
    }

    public static Integer[] getRandomIntegerArray(int nItems){
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        Integer[] data = new Integer[nItems];
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(100);
        }
        return data;
    }

//    public static void printListList(List<List<Integer>> groupLists) {
//        for (int i=0; i<groupLists.size(); i++) {
//            System.out.print("[");
//            for (int j = 0; j < groupLists.get(i).size(); j++) {
//                System.out.print(groupLists.get(i).get(j) + " ");
//            }
//            System.out.print("]");
//        }
//        System.out.println();
//    }
}
