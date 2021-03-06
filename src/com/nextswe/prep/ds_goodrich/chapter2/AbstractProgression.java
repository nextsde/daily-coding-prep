package com.nextswe.prep.ds_goodrich.chapter2;

public abstract class AbstractProgression {
    protected long current;

    public AbstractProgression(){
        this(0);
    }

    public AbstractProgression(long start){
        this.current = start;
    }

    public long nextValue(){
        long answer = current;
        advance();
        return answer;
    }

    protected abstract void advance();

    public void printProgression(int n){
        System.out.print(nextValue());
        for(int j=1;j<n;j++){
            System.out.print(" "+nextValue());
        }
        System.out.println();
    }
}
