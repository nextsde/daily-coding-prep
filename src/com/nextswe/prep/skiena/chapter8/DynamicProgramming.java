package com.nextswe.prep.skiena.chapter8;

public class DynamicProgramming {
    long fib_r(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        return fib_r(n-1)+fib_r(n-2);
    }
    long fib_cc(int n){
        if(cache[n]==-1){
            cache[n] = fib_cc(n-1)+fib_cc(n-2);
        }
        return cache[n];
    }

    long cache[];
    long fib_c(int n){
        cache = new long[n+1];
        cache[0] = 0;
        cache[1] = 1;
        for(int i=2;i<=n;i++){
            cache[i] = -1;
        }
        return fib_cc(n);
    }

    long fib_db(int n){
        long f[] = new long[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i=2;i<=n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    //seems like bottom up approach
    long fib_ultimate(int n){
        long fib_zero = 0, fib_one = 1;
        long next;

        for(int i=2;i<n;i++){
            next = fib_one + fib_zero;
            fib_zero = fib_one;
            fib_one = next;
        }
        return (fib_zero+fib_one);
    }

    //seems like top down approach
    long binomial_coefficient(int n, int k){
        long[][] bc = new long[n+1][n+1];
        //based on pascal's triangle
        //base cases we know (n choose 0) = 1
        for(int i=0;i<=n;i++)bc[i][0] = 1;
        //base cases we know (n choose n) = 1
        for(int j=0;j<=n;j++)bc[j][j] = 1;

        for(int i=1;i<=n;i++)
            for(int j=1;j<i;j++)
                bc[i][j] = bc[i-1][j-1] + bc[i-1][j];
        return bc[n][k];
    }


    public void partition(int[] s, int k){
        int[][] m = new int[s.length][k+1];
        int[][] d = new int[s.length][k+1];
        int[] p = new int[s.length];
        int cost;

        p[0] = 0;
        for(int i=1;i<=s.length;i++)
            p[i] = p[i-1] + s[i];

        for(int i=1;i<=s.length;i++) m[i][1] = p[i];
        for(int j=1;j<=k;j++) m[1][j] = s[1];

        for(int i=2;i<=s.length;i++) {
            for (int j = 2; j <= k; j++) {
                m[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= (i - 1); x++) {
                    cost = Math.max(m[x][j - 1], p[i] - p[x]);
                    if (m[i][j] > cost) {
                        m[i][j] = cost;
                        d[i][j] = x;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
//        System.out.println(fibOfN.fib_r(50));
//        System.out.println(fibOfN.fib_c(50));
//        System.out.println(fibOfN.fib_db(50));
//        System.out.println(dynamicProgramming.fib_ultimate(50));
        System.out.println(dynamicProgramming.binomial_coefficient(100,4));
    }
}
