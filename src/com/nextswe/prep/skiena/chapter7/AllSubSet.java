package com.nextswe.prep.skiena.chapter7;

public class AllSubSet extends Backtrack<Integer> {
    @Override
    protected void make_move(int[] a, int k, Integer input) {

    }

    @Override
    protected void unmake_move(int[] a, int k, Integer input) {

    }

    @Override
    protected int construct_candidates(int[] a, int k, int[] c, Integer input) {
        c[0] = 1;
        c[1] = 0;
        return 2;
    }

    @Override
    protected void process_solution(int[] a, int k, Integer input) {
        System.out.print("{");
        for(int i=1;i<=k;i++){
            if(a[i]==1){
                System.out.print(" "+i);
            }
        }
        System.out.print(" }\n");
    }

    @Override
    protected boolean is_a_solution(int[] a, int k, Integer input) {
        return k == input;
    }

    public void generate_susbsets(int n){
        int[] a = new int[NMAX];
        backtrack(a,0,n);;
    }

    public static void main(String[] args){
        AllSubSet allSubSet = new AllSubSet();
        allSubSet.generate_susbsets(4);
    }
}
