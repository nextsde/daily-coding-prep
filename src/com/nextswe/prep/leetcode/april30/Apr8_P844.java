package com.nextswe.prep.leetcode.april30;

import com.nextswe.prep.utils.Utils;

import java.util.Stack;

public class Apr8_P844 {
    //old solution
    //accepted
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();

        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#'){
                if(!s1.empty())
                    s1.pop();
            }else{
                s1.push(S.charAt(i));
            }
        }

        for(int i=0;i<T.length();i++){
            if(T.charAt(i)=='#'){
                if(!t1.empty())
                    t1.pop();
            }else{
                t1.push(T.charAt(i));
            }
        }
        boolean matched = true;
        if(s1.empty() && t1.empty()){
            return true;
        }else{
            char c1, c2;
            while(true){
                c1 = 0;
                c2 = 0;
                if(!s1.empty()){
                    c1 = s1.pop();
                }

                if(!t1.empty()){
                    c2 = t1.pop();
                }

                if(c1!=c2){
                    matched = false;
                    break;
                }
                if(s1.empty() && t1.empty()){
                    break;
                }
            }
        }
        return matched;
    }

    //clever solution of https://leetcode.com/lee215/
//    public boolean backspaceCompare(String S, String T) {
//        for (int i = S.length() - 1, j = T.length() - 1;; i--, j--) {
//            System.out.println("S:"+S+" T:"+T+" i1 = "+i);
//            System.out.println("S:"+S+" T:"+T+" j1 = "+j);
//            for (int b = 0; i >= 0 && (b > 0 || S.charAt(i) == '#'); --i) {
//                b += S.charAt(i) == '#' ? 1 : -1;
//                System.out.println("S:"+S+" bb = "+b);
//            }
//            System.out.println("S:"+S+" i2 = "+i);
//            for (int b = 0; j >= 0 && (b > 0 || T.charAt(j) == '#'); --j) {
//                b += T.charAt(j) == '#' ? 1 : -1;
//                System.out.println("T:"+T+" bb = "+b);
//            }
//            System.out.println("T:"+T+" j2 = "+j);
//            if (i < 0 || j < 0 || S.charAt(i) != T.charAt(j)) {
//                System.out.println("i10 = "+i);
//                System.out.println("j10 = "+j);
//                return i == -1 && j == -1;
//            }
//
//            System.out.println("i3 = "+i);
//            System.out.println("j3 = "+j);
//        }
//    }

    public static void main(String[] args){
        Apr8_P844 p844 = new Apr8_P844();
        Utils.println(p844.backspaceCompare("ab#c","ad#c"));
        Utils.println(p844.backspaceCompare("ab##","c#d#"));
        Utils.println(p844.backspaceCompare("a##c","#a#c"));
        Utils.println(p844.backspaceCompare("a#c","b"));
        Utils.println(p844.backspaceCompare("xywrrmp","xywrrmu#p"));
        Utils.println(p844.backspaceCompare("x#wfrmpr","x#wrrmu#p"));
        Utils.println(p844.backspaceCompare("x#wfrmp","x#wrrmu#p"));
    }
}
