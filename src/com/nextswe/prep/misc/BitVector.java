package com.nextswe.prep.misc;

import java.util.Arrays;

//https://www.youtube.com/watch?v=SYoJ6gUXZvc
//https://www.youtube.com/watch?v=FXHRMDiUH-c
//https://www.youtube.com/watch?v=X4SL262Y364
public class BitVector {
    static int WORDSIZE = 32;
    static int BITS_WS = 5;
    static int MASK = 0x1F;
    void set(int[] bv , int i){
        bv[ i >> BITS_WS ] |= 1 << ( i & MASK );
    }
    int member(int[] bv, int i){
        return bv[ i >> BITS_WS ] & ( 1 << ( i & MASK ) );
    }
    public static void main(String[] args){
        BitVector mBitVector = new BitVector();
        int[] s1 = {32,5};
        int[] s2 = {32,4,5};
        int[] bv = new int[32];
        for(int i=0;i<s1.length;i++){
            mBitVector.set(bv, s1[i]);
        }
        System.out.println(Arrays.toString(bv));
        for(int i=0;i<s2.length;i++){
            if(mBitVector.member(bv, s2[i])>0) {
                System.out.println(s2[i]);
            }
        }
    }
}
