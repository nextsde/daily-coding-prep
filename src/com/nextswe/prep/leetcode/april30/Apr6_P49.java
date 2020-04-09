package com.nextswe.prep.leetcode.april30;

import java.util.*;

public class Apr6_P49 {
    //solution 2 //accepted
    //based on hint :( need to be better
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,Integer> map = new HashMap<>();
        int n = strs.length;
        List<List<String>> list = new ArrayList<>();
        int index = -1;
        for(int i=0;i<n;i++){
            char[] item = strs[i].toCharArray();
            Arrays.sort(item);
            String key = new String(item);
            List<String> subList;
            if(!map.containsKey(key)){
                index++;
                subList = new ArrayList<>();
                list.add(subList);
                subList.add(strs[i]);
                map.put(key,index);
            }else{
                list.get(map.get(key)).add(strs[i]);
            }
        }
        return list;
    }

    //broken solution
    //will check later if time permits
/*
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int n = strs.length;
        List<List<String>> list = new ArrayList<>();
        int index = -1;
        for(int i=0;i<n;i++){
            String item = strs[i];
            int itemLen = item.length();
            int key1 = 1;
            int key2 = 1;
            for(int j=0;j<itemLen;j++){
                key1 *= ((item.charAt(j)-96)%26);
                int charPos = ((item.charAt(j)-96)%26);
                key2 += charPos;
            }
            int key = key1 + (key2*10000);
            List<String> subList;
            if(!map.containsKey(key)){
                index++;
                subList = new ArrayList<>();
                list.add(subList);
                subList.add(item);
                map.put(key,index);
            }else{
                list.get(map.get(key)).add(item);
            }
        }
        return list;
    }
    */

    public static void main(String[] args){
        //test cases
        Apr6_P49 apr649 = new Apr6_P49();

//        Utils.printListList(apr6.groupAnagrams(new String[]{"ray","cod","abe","ned","arc","jar","owl","pop","paw","sky","yup","fed","jul","woo","ado","why","ben","mys","den","dem","fat","you","eon","sui","oct","asp","ago","lea","sow","hus","fee","yup","eve","red","flo","ids","tic","pup","hag","ito","zoo"}));
//        Utils.printListList(apr6.groupAnagrams(new String[]{"apt","man","qom","apt","lei","hus","pet","gay","six","mai"}));
//        Utils.printListList(apr6.groupAnagrams(new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"}));
//        Utils.printListList(apr6.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//        Utils.printListList(apr6.groupAnagrams(new String[]{"mod","mop","pip","tug","hop","dog","met","zoe","axe","mug","fdr","for","fro","fdr","pap","ray","lop","nth","old","eva","ell","mci","wee","ind","but","all","her","lew","ken","awl","law","rim","zit","did","yam","not","ref","lao","gab","sax","cup","new","job","new","del","gap","win","pot","lam","mgm","yup","hon","khz","sop","has","era","ark"}));
//        Utils.printListList(apr6.groupAnagrams(new String[]{"tho","tin","erg","end","pug","ton","alb","mes","job","ads","soy","toe","tap","sen","ape","led","rig","rig","con","wac","gog","zen","hay","lie","pay","kid","oaf","arc","hay","vet","sat","gap","hop","ben","gem","dem","pie","eco","cub","coy","pep","wot","wee"}));
    }
}
