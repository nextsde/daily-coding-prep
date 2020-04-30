package com.nextswe.prep.ds_goodrich.chapter10;

import com.nextswe.prep.ds_goodrich.chapter9.Entry;

import java.util.Scanner;

public class Chapter10_Main {
    static int hashCode(String s){
        int h = 0;
        for(int i=0;i<s.length();i++){
            h = (h<<5) | (h>>>27);
            h+= (int)s.charAt(i);
        }
        return h;
    }

    public static void WordCount(){
        Map<String,Integer> freq = null;//new ChainHashMap<>();
        Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]]+");
        while(doc.hasNext()){
            String word = doc.next().toLowerCase();
            Integer count = freq.get(word);
            if(count==null){
                count = 0;
            }
            freq.put(word,count);
        }
        int maxCount = 0;
        String maxWord = "no word";
        for(Entry<String,Integer> ent: freq.entrySet()){
            if(ent.getValue()>maxCount){
                maxWord = ent.getKey();
                maxCount = ent.getValue();
            }
        }
        System.out.print("The most frequent word is '"+maxWord);
        System.out.println("' with "+maxCount+" occurrences");
    }

    public static void main(String[] args){
        int x = -9;
        System.out.println(x>>>3);
        int y = 4;
        System.out.println(y>>1);
    }
}
