package com.nextswe.prep.ds_goodrich.chapter3;

import java.util.Arrays;
import java.util.Random;

public class PseudoRandomTest {
    public static void main(String[] args){
        int[] data = new int[10];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        // fill the data array with pseudo-random numbers from 0 to 99, inclusive
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(100);
        }
        int[] orig = Arrays.copyOf(data, data.length);
        System.out.println("arrays equal before sort: " + Arrays.equals(data, orig));
        Arrays.sort(data);
        System.out.println("arrays equal after sort: " + Arrays.equals(data, orig));
        System.out.println("orig = " + Arrays.toString(orig));
        System.out.println("data = " + Arrays.toString(data));
    }
}
