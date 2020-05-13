package com.nextswe.prep.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=AXjmTQ8LEoI


class TrieNode{
    public Map<Character, TrieNode> map = new HashMap<>();
    public boolean end = false;
}

class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tempNode = root;
        for(int i=0;i<word.length();i++){
            char cc = word.charAt(i);
            if(!tempNode.map.containsKey(cc)){
                TrieNode temp = new TrieNode();
                tempNode.map.put(cc,temp);
            }
            tempNode = tempNode.map.get(cc);
            if(i==word.length()-1){
                tempNode.end = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tempNode = root;
        for(int i=0; tempNode!=null && i<word.length();i++){
            tempNode = tempNode.map.getOrDefault(word.charAt(i), null);
        }
        return tempNode!=null && tempNode.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tempNode = root;
        for(int i=0; tempNode!=null && i<prefix.length();i++){
            tempNode = tempNode.map.getOrDefault(prefix.charAt(i), null);
        }
        return tempNode!=null;
    }
}

public class P208 {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.search("ab");
//["search","insert","search","search","startsWith","startsWith"]
//[["ab"],["ab"],["ab"],["ab"],["ab"],["ab"]]
//["insert","search","search","search","startsWith","startsWith","startsWith"]
//[["hello"],["hell"],["helloa"],["hello"],["hell"],["helloa"],["hello"]]

//        trie.insert("hello");
//        System.out.println(trie.search("hell"));   // returns true
//        System.out.println(trie.search("helloa"));   // returns true
//        System.out.println(trie.search("hello"));   // returns true

//        trie.insert("apple");
//        System.out.println(trie.search("apple"));   // returns true
//        System.out.println(trie.search("app"));     // returns false
//        System.out.println(trie.startsWith("app")); // returns true
//        System.out.println(trie.startsWith("appc")); // returns true
//        trie.insert("app");
//        System.out.println(trie.search("app"));     // returns true
    }
}
