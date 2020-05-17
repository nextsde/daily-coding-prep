package com.nextswe.prep.dp;

import java.util.Arrays;

public class LCS {
    //top down recursive solution
    public static int LCSRecursive(char[] A, char[] B, int i, int j){
        if(A.length==i || B.length == j){ return 0; }
        else if(A[i]==B[j]){
            return 1 + LCSRecursive(A, B , i+1, j+1);
        }else{
            return Math.max(LCSRecursive(A,B,i+1,j),LCSRecursive(A,B,i,j+1));
        }
    }

    //top down recursive solution with memoization
    public static int LCSRecursiveMemo(char[] A, char[] B, int i, int j, int[][] memo){
        if(A.length==i || B.length == j){ return 0; }
        else if(A[i]==B[j]){
            if(memo[i+1][j+1]==-1){
                memo[i+1][j+1] =  LCSRecursiveMemo(A, B , i+1, j+1, memo);
            }
            return 1 + memo[i+1][j+1];
        }else{
            if(memo[i+1][j]==-1){
                memo[i+1][j] = LCSRecursiveMemo(A,B,i+1,j, memo);
            }
            if(memo[i][j+1]==-1){
                memo[i][j+1] = LCSRecursiveMemo(A,B,i,j+1, memo);
            }
            return Math.max(memo[i+1][j],memo[i][j+1]);
        }
    }

    public static int[][] LCSDP(char[] X, char[] Y){
        int n = X.length;
        int m = Y.length;
        int[][] L = new int[n+1][m+1];
        for(int j=0;j<n;j++){
            for(int k=0;k<m;k++){
                if(X[j]==Y[k]){
                    L[j+1][k+1] = 1 + L[j][k];
                }else{
                    L[j+1][k+1] = Math.max(L[j][k+1],L[j+1][k]);
                }
            }
        }
        return L;
    }

    public static String reconstructLCS(char[] X, char[] Y, int[][] L){
        StringBuilder solution = new StringBuilder();
        int j = X.length;
        int k = Y.length;
        while(L[j][k]>0){
            if(X[j-1]==Y[k-1]){
                solution.append(X[j-1]);
                j--;
                k--;
            }else if(L[j-1][k]>=L[j][k-1]){
                j--;
            }else{
                k--;
            }
        }
        return solution.reverse().toString();
    }

    public static void main(String[] args){
//        char A[] = "bd".toCharArray();
//        char B[] = "abcd".toCharArray();

//        char A[] = "AGGTAB".toCharArray();
//        char B[] = "GXTXAYB".toCharArray();

        char A[] = "AGGTAB".toCharArray();
        char B[] = "GXTXAYB".toCharArray();

        System.out.println(LCSRecursive(A,B,0,0));

        int[][] memo = new int[A.length+1][B.length+1];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        System.out.println(LCSRecursiveMemo(A,B,0,0,memo));

        System.out.println(reconstructLCS(A,B, LCSDP(A,B)));
    }
}
