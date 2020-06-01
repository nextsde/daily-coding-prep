package com.nextswe.prep.leetcode.daily;

import java.util.*;

public class P950 {
/*
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        if(deck.length>2){
            int i = deck.length-3;
            //2,3,5,7,11,13,17
            while(!(i<0)){
                int[] arr = new int[deck.length-i-1];
                int m = deck.length-1;
                for(int k = arr.length-1; k>=0; k--){
                    arr[k] = deck[m--];
                }
                int tmp = arr[0];
                for (int j = 0; j < arr.length; j++) {
                    int i1 = (j + 1) % arr.length;
                    int tmp2 = arr[i1];
                    arr[i1] = tmp;
                    tmp = tmp2;
                }

                m = deck.length-1;
                for(int k = arr.length-1; k>=0; k--){
                    deck[m--] = arr[k];
                }
                i--;
            }
        }
        return deck;
    }
*/
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        if(deck.length>2){
            Deque<Integer> deq = new LinkedList();
            for (int i = 0; i < deck.length; ++i)
                deq.add(i);
            int[] ans = new int[deck.length];
            for(int card: deck){
                ans[deq.pollFirst()] = card;
                if(!deq.isEmpty()){
                    deq.add(deq.pollFirst());
                }
            }
            return ans;
        }
        return deck;
    }

    public static void main(String[] args){
        P950 mP950 = new P950();
        System.out.println(Arrays.toString(mP950.deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7})));
//        System.out.println(Arrays.toString(mP950.deckRevealedIncreasing(new int[]{17,13,11,7})));
    }
}
