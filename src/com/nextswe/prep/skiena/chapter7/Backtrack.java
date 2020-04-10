package com.nextswe.prep.skiena.chapter7;

public abstract class Backtrack<T> {
    boolean finished = false;
    int MAXCANDIDATES = 100;
    public int NMAX = 100;

    public void backtrack(int[] a, int k, T input){
        int[] c = new int[MAXCANDIDATES]; //

        if(is_a_solution(a,k,input)){
            process_solution(a,k,input);
        }else{
            k=k+1;
            int ncandidates = construct_candidates(a,k,c,input);
            for(int i=0;i<ncandidates;i++){
                a[k]=c[i];
                make_move(a,k,input);
                backtrack(a,k,input);
                if(finished) return;
                unmake_move(a,k,input);
            }

        }
    }

    protected abstract void make_move(int[] a, int k, T input);

    protected abstract void unmake_move(int[] a, int k, T input);

    protected abstract int construct_candidates(int[] a, int k, int[] c, T input);

    protected abstract void process_solution(int[] a, int k, T input);

    protected abstract boolean is_a_solution(int[] a, int k, T input);
}
