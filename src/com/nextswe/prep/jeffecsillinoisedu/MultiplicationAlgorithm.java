package com.nextswe.prep.jeffecsillinoisedu;

import com.nextswe.prep.utils.Utils;

import java.util.Arrays;

public class MultiplicationAlgorithm {
    public int[] fibLiberAbaco(int[] x, int[] y){
        int size = x.length+y.length-1;
        int hold = 0;
        int[] z = new int[size];
        for(int k=size-1;k>=0;k--){
            for(int i=x.length-1;i>=0;i--){
                for(int j=y.length-1;j>=0;j--){
                    if(i+j==k){
                        hold = hold + (x[i]*y[j]);
                    }
                }
            }
            z[k] = hold%10;
            hold = hold/10;
        }
        return z;
    }

    public int peasant_multiply(int x, int y){
        int prod = 0;
        while(x>0){
            if(x%2==1){
                prod = prod+y;
            }
            x = x/2;
            y = y+y;
        }
        return prod;
    }

    public static void main(String[] args){
        MultiplicationAlgorithm multiplicationAlgorithm = new MultiplicationAlgorithm();
//        int[] x = new int[]{1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4};
//        int[] y = new int[]{2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4};
//        int[] z = multiplicationAlgorithm.fibLiberAbaco(x,y);
//        int[] k = multiplicationAlgorithm.fibLiberAbaco(x,z);
//        Utils.println(Arrays.toString(multiplicationAlgorithm.fibLiberAbaco(k,x)));

        Utils.println(Integer.toString(multiplicationAlgorithm.peasant_multiply(123,456)));
    }
}
