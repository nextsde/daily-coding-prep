package com.nextswe.prep.skiena.chapter7;

public class AllPermutation extends Backtrack<Integer> {
    @Override
    protected void make_move(int[] a, int k, Integer input) {

    }

    @Override
    protected void unmake_move(int[] a, int k, Integer input) {

    }

    @Override
    protected int construct_candidates(int[] a, int k, int[] c, Integer input) {
        boolean[] in_perm = new boolean[NMAX];

        for(int i=0;i<NMAX;i++)in_perm[i] = false;
        for(int i=0;i<k;i++)in_perm[a[i]] = true;

        int ncandidates = 0;
        for(int i=1;i<=input;i++){
            if(!in_perm[i]){
                c[ncandidates]=i;
                ncandidates = ncandidates+1;
            }
        }

        return ncandidates;
    }

    @Override
    protected void process_solution(int[] a, int k, Integer input) {
        for(int i=1;i<=k;i++)System.out.print(" "+a[i]);
        System.out.print("\n");
    }

    @Override
    protected boolean is_a_solution(int[] a, int k, Integer input) {
        return k==input;
    }

    public void generate_permutation(int n){
        int a[] = new int[n+1];
        backtrack(a,0,n);
    }

    public static void main(String[] args){
        AllPermutation allPermutation = new AllPermutation();
        allPermutation.generate_permutation(3);
    }
}
