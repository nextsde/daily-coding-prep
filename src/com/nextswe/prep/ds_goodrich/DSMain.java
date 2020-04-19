package com.nextswe.prep.ds_goodrich;

import com.nextswe.prep.ds_goodrich.chapter2.FibonacciProgression;
import com.nextswe.prep.ds_goodrich.chapter2.Progression;
import com.nextswe.prep.ds_goodrich.chapter3.SinglyLinkedList;

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
        SinglyLinkedList<Integer> ssl = new SinglyLinkedList<>();
        ssl.add(10);
        ssl.add(20);
        ssl.add(30);
        ssl.add(40);
        System.out.println(ssl.toString());
        ssl.addAt(45,2);
        System.out.println(ssl.toString());
        ssl.removeAt(0);
        System.out.println(ssl.toString());
/*
        Progression progress = new FibonacciProgression(4,10);
        progress.printProgression(20);
*/

/*
        Pair<String,Double>[] holdings = new Pair[25];
        holdings[0] = new Pair<>("ORCL", 32.07);
*/

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
