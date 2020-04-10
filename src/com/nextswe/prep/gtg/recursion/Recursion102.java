package com.nextswe.prep.gtg.recursion;

import com.nextswe.prep.utils.Utils;

import java.io.File;

public class Recursion102 {
    //code fragment 5.1
    public static int factorial(int n) throws IllegalArgumentException{
        if(n<0){
            throw new IllegalArgumentException("n must be non-negative");
        }else if(n==0){
            return 1; //base case .. terminating condition
        }else{
            return n*factorial(n-1);
        }
    }

    //code fragment 5.2
    public static void drawRuler(int nInches, int majorLength){
        drawLine(majorLength,0);
        for(int j=1;j<=nInches;j++){
            drawInterval(majorLength-1);
            drawLine(majorLength,j);
        }
    }

    private static void drawInterval(int centralLength){
        if(centralLength>=1){
            drawInterval(centralLength-1);
            drawLine(centralLength);
            drawInterval(centralLength-1);
        }
    }

    private static void drawLine(int tickLength, int tickLabel){
        for(int i=0;i<tickLength;i++){
            System.out.print("-");
        }
        if(tickLabel>=0){
            System.out.print(tickLabel);
        }
        System.out.print("\n");
    }

    private static void drawLine(int tickLength){
        drawLine(tickLength,-1);
    }

    //code fragment 5.3
    public static boolean binarySearch(int[] data, int target, int low, int high){
        if(low>high){
            return false;
        }else{
            int mid = (low+high)/2;
            if(target==data[mid]){
                return true;
            }else if(target < data[mid]){
                return binarySearch(data, target,low,mid-1);
            }else{
                return binarySearch(data, target, mid+1, high);
            }
        }
    }

    //code fragment 5.5
    public static long diskUsage(File root){
        long total = root.length();
        if(root.isDirectory()){
            for(String childName : root.list()){
                File child = new File(root,childName);
                total += diskUsage(child);
            }
        }
        System.out.println(total+"\t"+root);
        return total;
    }

    //code fragment 5.6
    public static int linearSum(int[] data, int n){
        if(n==0){
            return 0;
        }
        return linearSum(data,n-1)+data[n-1];
    }

    //code fragment 5.7
    public static void reverseArray(int[] data, int low, int high){
        if(low<high){
            int tmp = data[low];
            data[low] = data[high];
            data[high] = tmp;
            reverseArray(data,low+1,high-1);
        }
    }

    public static int linearIterativeSum(int[] data){
        int result = 0;
        for (int item:data){
            result+=item;
        }
        return result;
    }

    //code fragment 5.10
    public static int binarySum(int[] data, int low, int high){
        if(low>high)
            return 0;
        else if(low==high)
            return data[low];
        else{
            int mid = (low+high)/2;
            return binarySum(data,low,mid)+binarySum(data,mid+1,high);
        }
    }


    //code fragment 5.13
    public static long fibonacciBad(int n){
        if(n<=1){
            return n;
        }else{
            return fibonacciBad(n-2) + fibonacciBad(n-1);
        }
    }

    //code fragment 5.14
    public static long[] fibonacciGood(int n){
        if(n<=1){
            long[] answer = {n,0};
            return answer;
        }else{
            long temp[] = fibonacciGood(n-1); //it will return fn-1, fn-2
            long answer[] = {temp[0]+temp[1],temp[0]}; //fn, fn-1
            return answer;
        }
    }

    public static void main(String[] args){
        long c1;
        int[] sorted_data = new int[]{1,2,4,5,7,12,23,34,56,78,98,101};
        int[] unsorted_data = new int[]{12,20,11,9,30,13,23,34,26,28,38,41};
//        Utils.println(factorial(3));

//        drawRuler(12,4);

//        Utils.println(binarySearch(data,34,0,data.length-1));

//        diskUsage(new File("../"));
//        Utils.println(linearSum(unsorted_data, unsorted_data.length-1));

//        reverseArray(sorted_data,0, sorted_data.length-1);
//        Utils.printArray(sorted_data);

//        c1 = System.nanoTime();
//        Utils.println(linearIterativeSum(unsorted_data));
//        Utils.println(System.nanoTime()-c1);
//
//        c1 = System.nanoTime();
//        Utils.println(binarySum(unsorted_data,0,unsorted_data.length-1));
//        Utils.println(System.nanoTime()-c1);

        c1 = System.nanoTime();
        Utils.println(fibonacciBad(20));
        Utils.println(System.nanoTime()-c1);

        c1 = System.nanoTime();
        Utils.println(fibonacciGood(20)[0]);
        Utils.println(System.nanoTime()-c1);
    }
}
