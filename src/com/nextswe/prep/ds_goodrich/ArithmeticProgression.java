package com.nextswe.prep.ds_goodrich;

public class ArithmeticProgression extends Progression {
    protected long increment;

    public ArithmeticProgression(){
        this(1,0);
    }

    public ArithmeticProgression(long stepsize){
        this(stepsize,0);
    }

    public ArithmeticProgression(long stepsize, long start){
        super(start);
        this.increment = stepsize;
    }

    protected void advance(){
        current += increment;
    }
}
