package com.nextswe.prep.ds_goodrich;

import com.nextswe.prep.ds_goodrich.chapter2.FibonacciProgression;
import com.nextswe.prep.ds_goodrich.chapter2.Progression;

/**
 */
public class DSMain {
    public static void badReset(Counter c){
        c = new Counter();
        c.count = 20;
    }

    /**
     * @param c
     */
    public static void goodReset(Counter c){
        c.count = 15;
    }
    public static void main(String[] args){
        Progression progress = new FibonacciProgression(4,10);
        progress.printProgression(20);


//        Pair<String,Double>[] holdings = new Pair[25];
//        holdings[0] = new Pair<>("ORCL", 32.07);



/*
        Counter c = new Counter();
        System.out.println(c.count);
        c.count = 12;
        System.out.println(c.count);

        badReset(c);
        System.out.println(c.count);
        goodReset(c);
        System.out.println(c.count);
*/
    }
}

class Counter{
    public int count = 10;
}
