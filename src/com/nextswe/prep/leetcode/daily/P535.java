package com.nextswe.prep.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

public class P535 {

    //accepted
    //takes good amount of time to generate the hashCode based on my hash function
    //run time depends of the string length which is O(n)
    Map<Long,String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        long hashValue = hashCode(longUrl);
        if(!map.containsKey(hashValue)){
            map.put(hashValue,longUrl);
        }

        return "http://tinyurl.com/"+hashValue;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] splittedString = shortUrl.split("com/");
        long hashValue = Long.parseLong(splittedString[1]);
        return map.get(hashValue);
    }

    public long hashCode(String url){
        long hashVal = 0;
        for(int i=0;i<url.length();i++){
            hashVal += ((url.charAt(i)-97) * (i+1) * (1<<(url.charAt(i)-97)));
        }
        return hashVal;
    }

    public static void main(String[] args){
        P535 p535 = new P535();
        String url = "https://leetcode.com/problems/design-tinyurl";
        System.out.println(p535.decode(p535.encode(url)));

//        String encoded_url = p535.encode(url);
//        System.out.println(encoded_url);
//        String decoded_url = p535.decode(encoded_url);
//        System.out.println(decoded_url);
    }
}
