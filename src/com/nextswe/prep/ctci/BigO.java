package com.nextswe.prep.ctci;

public class BigO {
    int numChars = 26;
    void printSortedStrings(int remaining){
        printSortedStrings(remaining, "");
    }
    void printSortedStrings(int remaining, String prefix){
        if(remaining==0){
            if(isInOrder(prefix)){
                System.out.println(prefix);
            }
        }else{
            for(int i=0; i< numChars; i++){
                char c = ithLetter(i);
                printSortedStrings(remaining-1, prefix+c);
            }
        }
    }
    boolean isInOrder(String s){
        for(int i=1;i<s.length();i++){
            int prev = s.charAt(i-1);
            int cur = s.charAt(i);
            if(prev>cur){
                return false;
            }
        }
        return true;
    }
    char ithLetter(int i){
        return (char)(((int)'a')+i);
    }

    public static void main(String[] args){
        BigO mB = new BigO();
        mB.printSortedStrings(2);
    }
}
