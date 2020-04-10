package com.nextswe.prep.utils;

import java.util.List;

public class Utils {
    /* A utility function to print array of size n */
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
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
