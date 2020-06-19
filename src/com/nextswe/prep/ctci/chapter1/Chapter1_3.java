package com.nextswe.prep.ctci.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Chapter1_3 {
    /*
    Question: Write a method to replace all spaces in a string with '%20'. You may assume that the string has
    sufficient space at the end to hold the additional characters, and you are given the 'true' length of the string.

    DON'T START WRITING CODE:

    Understand the question well.
    Input:  "Mr John Smith    ",13
    Output: "Mr%20John%20Smith"

    Ask or Clarify:
    As we can see from the input though the string length is "Mr John Smith" = 13 but
    we are give "Mr John Smith    "  = 17 length string.
    Why?
    "Mr John Smith", in here within 13 character we have 2 space character. Each space character should replaced
    with 3 character "%20". So we need 2*2 = 4 more length with our existing 13 character length to accommodate those extra characters.

    Come up with clarifying and insightful questions. Although you are interviewing for the job.
    But you will solve real world problem with your knowledge which will have real impact.

     */
    public static int getSpaceCount(char[] str, int true_length){
        int count = 0;
        for(int i=0;i<true_length;i++){
            if(str[i]==' '){
                count++;
            }
        }
        return count;
    }
    public static String replaceSpaces(char[] str,int true_length){
        int spaceCount,i, index;
        spaceCount = getSpaceCount(str,true_length);
        index = true_length + spaceCount*2;
        if(true_length<str.length) str[true_length] = '\0';
        for(i = true_length-1;i>=0;i--){
            if(str[i]==' '){
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index = index - 3;
            }else{
                str[index-1] = str[i];
                index--;
            }
        }
        return new String(str);
    }
    public static void main(String[] args){
        System.out.println(replaceSpaces("Mr John Smith    ".toCharArray(),13));
    }
}
