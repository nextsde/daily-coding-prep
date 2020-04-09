package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

public class P1342 {
    public int numberOfSteps (int num) {
        if(num==0){
            return 0;
        }
        int steps = 1;
        if(num%2==1){
            num = num-1;
        }else{
            num = num/2;
        }
        return steps + numberOfSteps(num);
    }

    public static void main(String[] args){
        P1342 p1342 = new P1342();
        Utils.println(p1342.numberOfSteps(14));
        Utils.println(p1342.numberOfSteps(8));
        Utils.println(p1342.numberOfSteps(123));
    }
}
