package com.nextswe.prep.ctci.chapter1;

public class Chapter1_6 {
    static String compressedString(String str){
        if(str==null || str.length()==0){
            return null;
        }
        char currentChar = str.charAt(0);
        int currentCount = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<str.length();i++){
            char newChar = str.charAt(i);
            if(newChar == currentChar){
                currentCount++;
            }else{
                sb.append(currentChar);
                sb.append(currentCount);
                currentChar = newChar;
                currentCount = 1;
            }
        }
        sb.append(currentChar);
        sb.append(currentCount);
        return sb.toString().length()<str.length()?sb.toString():str;
    }
    public static void main(String[] args){
        System.out.println(compressedString("aabcccccaaa"));
    }
}
