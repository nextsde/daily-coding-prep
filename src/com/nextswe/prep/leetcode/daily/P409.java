package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;

public class P409 {
    public int longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        System.out.println(s.length());
        int a[] = new int[56];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int index = 0;
            if(c>='A' && c<='Z'){
                index = s.charAt(i)-'A';
            }else{
                index = 26+(s.charAt(i)-'a');
            }
            a[index]++;
        }
        int res = 0;
        int odd = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]%2==1){
                if(a[i]>1){
                    res+=(a[i]-1);
                }
                odd = 1;
            }else{
                res+=a[i];
            }
        }
//        System.out.println(Arrays.toString(a));
        return res+odd;
    }

    public static void main(String[] args){
        P409 mP409 = new P409();
//        System.out.println(mP409.longestPalindrome("a"));
//        System.out.println(mP409.longestPalindrome("abccccdd"));
//        System.out.println(mP409.longestPalindrome("ABCCCCDDZZabccccdd"));
        System.out.println(mP409.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
