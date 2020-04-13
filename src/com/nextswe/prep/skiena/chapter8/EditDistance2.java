package com.nextswe.prep.skiena.chapter8;

//from
//https://jlordiales.wordpress.com/2014/03/01/dynamic-programming-edit-distance/
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.HashMap;
import java.util.Map;

public class EditDistance2 {
    public static int replaceCost(String w1, String w2, int w1Index, int w2Index) {
        return (w1.charAt(w1Index) == w2.charAt(w2Index)) ? 0 : 1;
    }

    public int bruteForceEditDistance(String word1, String word2){
        if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();
        int replace = bruteForceEditDistance(word1.substring(1),word2.substring(1))+replaceCost(word1,word2,0,0);
        int delete = bruteForceEditDistance(word1.substring(1),word2)+1;
        int insert = bruteForceEditDistance(word1,word2.substring(1))+1;
        return Math.min(replace,Math.min(delete,insert));
    }

    public int topDownDPMemoizedEditDistance(String word1, String word2){
        return topDownDPMemoizedEditDistance(word1,word2, new HashMap<StringTuple,Integer>());
    }

    private int topDownDPMemoizedEditDistance(String word1, String word2, Map<StringTuple,Integer> dpTable){
        if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();
        StringTuple replaceTuple = new StringTuple(word1.substring(1),word2.substring(1));
        StringTuple deleteTuple = new StringTuple(word1.substring(1),word2);
        StringTuple insertTuple = new StringTuple(word1,word2.substring(1));

        int replace = replaceCost(word1,word2,0,0) + transformationCost(replaceTuple, dpTable);
        int delete = 1 + transformationCost(deleteTuple,dpTable);
        int insert = 1 + transformationCost(insertTuple,dpTable);

        int minEditDistance = Math.min(replace,Math.min(delete,insert));
        dpTable.put(new StringTuple(word1,word2),minEditDistance);
        return minEditDistance;
    }

    private int transformationCost(StringTuple tuple,Map<StringTuple, Integer> dpTable){
        if(dpTable.containsKey(tuple)) return dpTable.get(tuple);
        int result = topDownDPMemoizedEditDistance(tuple.s1,tuple.s2,dpTable);
        dpTable.put(tuple,result);
        return result;
    }

    private class StringTuple{
        private final String s1;
        private final String s2;
        public StringTuple(String s1, String s2){
            this.s1 = s1;
            this.s2 = s2;
        }
        public int hashCode(){
            return HashCodeBuilder.reflectionHashCode(this);
        }
        public boolean equals(Object obj){
            return EqualsBuilder.reflectionEquals(this,obj);
        }
    }

    public int topDownIterativeEditDistance(String word1, String word2){
        if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();

        int word1Length = word1.length();
        int word2Length = word2.length();

        int[][] minCosts = new int[word1Length][word2Length];
        minCosts[0][0] = replaceCost(word1,word2,0,0);

        for(int j=1;j<word2Length;j++){
            minCosts[0][j] = 1 + minCosts[0][j-1];
        }

        for(int i=1;i<word1Length;i++){
            minCosts[i][0] = 1 + minCosts[i-1][0];
        }
        for(int i=1;i<word1Length;i++){
            for(int j=1;j<word2Length;j++){
                int replace = replaceCost(word1,word2,i,j) + minCosts[i-1][j-1];
                int delete = 1 + minCosts[i-1][j];
                int insert = 1 + minCosts[i][j-1];
                minCosts[i][j] = Math.min(replace, Math.min(delete,insert));
            }
        }
        return minCosts[word1Length-1][word2Length-1];
    }

    public int bottomUpIterativeEditDistance(String word1, String word2){
        if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();

        int word1Length = word1.length();
        int word2Length = word2.length();

        int[][] minCosts = new int[word1Length][word2Length];
        minCosts[word1Length-1][word2Length-1] = replaceCost(word1,word2,word1Length-1,word2Length-1);

        for(int j=word2Length-2;j>=0;j--){
            minCosts[word1Length-1][j] = 1 + minCosts[word1Length-1][j+1];
        }

        for(int i=word1Length-2;i>=0;i--){
            minCosts[i][word2Length-1] = 1 + minCosts[i+1][word2Length-1];
        }
        for(int i=word1Length-2;i>=0;i--){
            for(int j=word2Length-2;j>=0;j--){
                int replace = replaceCost(word1,word2,i,j) + minCosts[i+1][j+1];
                int delete = 1 + minCosts[i+1][j];
                int insert = 1 + minCosts[i][j+1];
                minCosts[i][j] = Math.min(replace, Math.min(delete,insert));
            }
        }
        return minCosts[0][0];
    }

    public static void main(String[] args){
        EditDistance2 editDistance = new EditDistance2();
//        System.out.println(editDistance.bruteForceEditDistance("horse","ros"));
//        System.out.println(editDistance.bruteForceEditDistance("benyamdfqcasdqwe","ephremadaqeqasds"));
//        System.out.println(editDistance.topDownDPMemoizedEditDistance("benyamdfqcasdqwe","ephremadaqeqasds"));
        System.out.println(editDistance.bottomUpIterativeEditDistance("benyamdfqcasdqwe","ephremadaqeqasds"));
    }
}
