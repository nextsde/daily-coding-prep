package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;

public class P88 {
    //Accepted
    public void merge(int[] A, int m, int[] B, int n) {
        if((m==0 && A.length==0) || n==0){
            return;
        }
        int k = A.length-1;
        int i = m-1,j = n-1;
        while(i>=0 && j>=0){
            if(A[i]>=B[j]){
                A[k--] = A[i--];
            }else{
                A[k--] = B[j--];
            }
        }
        while(i>=0){
            A[k--] = A[i--];
        }
        while(j>=0){
            A[k--] = B[j--];
        }
    }

/*
    public void merge(int[] A, int m, int[] B, int n) {
        if((m==0 && A.length==0) || n==0){
            return;
        }
        int i = 0,j = 0;
        while(i<m){
            if(A[i]<=B[j]){
                i++;
            }else{
                int tmp = A[i];
                A[i++] = B[j];
                B[j++] = tmp;
            }
        }
        j = 0;
        while(j<n){
            A[i+j] = B[j];
            j++;
        }
    }
*/

    public static void main(String[] args){
        P88 pp = new P88();
        int[] mm,nn;
        int m,n;

        mm = new int[]{1,2,3,0,0,0};
        m = 3;
        nn = new int[]{2,5,6};
        n = 3;

        pp.merge(mm,m,nn,n);
        System.out.println(Arrays.toString(mm));


//        mm = new int[]{4,2,0,0,0};
//        m = 2;
//        nn = new int[]{2,5,6};
//        n = 3;
//        pp.merge(mm,m,nn,n);
//        System.out.println(Arrays.toString(mm));

        mm = new int[]{4,7,0,0,0};
        m = 2;
        nn = new int[]{2,5,6};
        n = 3;

        pp.merge(mm,m,nn,n);
        System.out.println(Arrays.toString(mm));

        mm = new int[]{4,0,0,0,0,0};
        m = 1;
        nn = new int[]{1,2,3,5,6};
        n = 5;

        pp.merge(mm,m,nn,n);
        System.out.println(Arrays.toString(mm));

        mm = new int[]{4,5,6,0,0,0};
        m = 3;
        nn = new int[]{1,2,3};
        n = 3;

        pp.merge(mm,m,nn,n);
        System.out.println(Arrays.toString(mm));

        mm = new int[]{0};
        m = 0;
        nn = new int[]{1};
        n = 1;

        pp.merge(mm,m,nn,n);
        System.out.println(Arrays.toString(mm));

        mm = new int[]{1};
        m = 1;
        nn = new int[]{};
        n = 0;

        pp.merge(mm,m,nn,n);
        System.out.println(Arrays.toString(mm));
    }
}
