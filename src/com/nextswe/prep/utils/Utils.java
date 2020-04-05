package com.nextswe.prep.utils;

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
    public static void println(String judge) {
        System.out.println(""+judge);
    }
}
