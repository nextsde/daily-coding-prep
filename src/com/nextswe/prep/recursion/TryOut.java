package com.nextswe.prep.recursion;

import java.io.File;

public class TryOut {
/*
    private static boolean isPalindrome(String val, int p1, int p2){
        if(p1 > p2){
            return true;
        }else if(val.charAt(p1) == val.charAt(p2)){
            return isPalindrome(val,p1+1,p2-1);
        }else{
            return false;
        }
    }
    public static boolean isPalindrome(String val){
        return isPalindrome(val, 0, val.length()-1);
    }
*/
    public static boolean isPalindrome(String val){
        if(val.length()<=1){
            return true;
        }else{
            char first = val.charAt(0);
            char last = val.charAt(val.length()-1);
            if(first == last){
                return isPalindrome(val.substring(1,val.length()-1));
            }else{
                return false;
            }
        }
    }

    public static void printBinary(int n){
        if(n<=1){
            System.out.print(n);
        }else{
            int lastDigit = n%2;
            int otherInt = n/2;
            printBinary(otherInt);
            System.out.print(lastDigit);
        }
    }

    public static void printBinary(int n, String prefix){
        if(n==0){
            System.out.println(prefix);
        }else{
            printBinary(n-1,prefix+"0");
            printBinary(n-1,prefix+"1");
        }
    }

    public static void crawl(String filename,String indent){
        System.out.println(indent+""+new File(filename).getName());
        if(!new File(filename).isFile()){
            String[] ff = new File(filename).list();
            for(String f: ff){
                crawl(filename+"/"+f," "+indent);
            }
        }
    }

    public static void main(String[] args){
        printBinary(3,"");
//        crawl(".","");
//        printBinary(42);
//        System.out.println(isPalindrome("madam"));
//        System.out.println(isPalindrome("racecar"));
//        System.out.println(isPalindrome("step on no pets"));
//        System.out.println(isPalindrome("Java"));
//        System.out.println(isPalindrome("rotator"));
//        System.out.println(isPalindrome("notion"));
//        System.out.println(isPalindrome("Q"));
    }
}
