package com.nextswe.prep.misc;

//https://www.youtube.com/watch?v=ZusiKXcz_ac
public class BitHacks {

    public static void main(String[] args){
        int bb = 0b10010110;
        System.out.println(bb);

        //Round up to a power of 2
        int x = 0b0010000001010000;
        System.out.println(x);
        x--;  //0b0010000001001111
        x |= x >> 1; //0b0010000001001111 | 0b0001000000100111 -> 0b0011000001101111
        x |= x >> 2; //0b0011000001101111 | 0b0000110000011011 -> 0b0011110001111111
        x |= x >> 4; //0b0011110001111111 | 0b0000001111000111 -> 0b0011111111111111
        x |= x >> 8;
        x |= x >> 16;
        x |= x >> 32;
        x++; //0b0100000000000000
        System.out.println(x);


        //Round up to a power of 2
        x = 128;
        System.out.println(x);
        x--;
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        x |= x >> 32;
        x++;
        System.out.println(x);
    }
}
