package com.nextswe.prep.ds_goodrich.chapter4;

import java.util.Arrays;

public class Chapter4 {
    //Prefix Averages
    //O(n^2)
    public static double[] prefixAverage1(double[] x){
        int n = x.length;
        double[] a = new double[n]; //filled with zero takes O(n)
        for(int j=0;j<n;j++){
            double total = 0; // begin computing x[0] + ... + x[j]
            for(int i=0;i<=j;i++){
                total += x[i];
            }
            a[j] = total/(j+1); // record the average
        }
        return a;
    }

    //O(n)
    public static double[] prefixAverage2(double[] x){
        int n = x.length;
        double[] a = new double[n]; // filled with zeros by default
        double total = 0; // compute prefix sum as x[0] + x[1] + ...
        for(int j=0;j<n;j++){
            total += x[j]; // update prefix sum to include x[j]
            a[j] = total/(j+1); // compute average based on current sum
        }
        return a;
    }

    //Using Sorting as a Problem-Solving Tool
    //O(nlogn)
    public static boolean unique2(int[] data){
        int[] temp = Arrays.copyOf(data,data.length);
        Arrays.sort(temp);
        for(int i=0;i<temp.length-1;i++){
            if(temp[i] == temp[i+1]){
                return false;
            }
        }
        return true;
    }

    //Element Uniqueness
    //O(n^2)
    public static boolean unique1(int[] data){
        for(int i=0;i<data.length;i++){
            for(int k = i+1;k<data.length;k++){
                if(data[i] == data[k]){
                    return false;
                }
            }
        }
        return true;
    }

    //Three-Way Set Disjointness
    //O(n^3)
    public static boolean disjoint1(int[] groupA, int[] groupB, int[] groupC){
        for(int a: groupA){
            for(int b: groupB){
                for(int c: groupC){
                    if(a==b && b==c){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //O(n^2)
    public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC){
        for(int a: groupA){
            for(int b:groupB){
                if(a==b){
                    for(int c: groupC){
                        if(b==c){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){

    }
}
