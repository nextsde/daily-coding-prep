package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P5_trylater {
//    static String subString = "";
//    static int max = Integer.MIN_VALUE;
//    static boolean isPalindrome(String s){
//        for(int i=0,j=s.length()-1;i<j;i++,j--){
//            if(s.charAt(i)!=s.charAt(j)) return false;
//        }
//        return true;
//    }
//
//    static String lpsRecur(String s){
//        if(s.length()==0){
//            return "";
//        }
//        if(isPalindrome(s)){
//            return s;
//        }else{
//            String s1 = s.substring(0,s.length()-1);
//            String str1 = lpsRecur(s1);
//            String s2 = s.substring(1,s.length());
//            String str2 = lpsRecur(s2);
//            return str1.length()>str2.length()?str1:str2;
//        }
//    }

    static boolean isPalindrome(char[] s, int i, int j){
        while(i<j){
            if(s[i]!=s[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    static String lpsRecur(char[] s, int i, int j,Map<Integer,Map<Integer,String>> memoMap){
        if(i>j){
            return "";
        }
        if(memoMap.containsKey(i) && memoMap.get(i).containsKey(j)){
            return memoMap.get(i).get(j);
        }
        if(isPalindrome(s,i,j)){
            StringBuilder sb = new StringBuilder();
            for(;i<=j;i++){
                sb.append(s[i]);
            }
            Map<Integer,String> mm;
            if(memoMap.containsKey(i)){
                mm = memoMap.get(i);
            }else{
                mm = new HashMap<>();
                memoMap.put(i,mm);
            }
            mm.put(j,sb.toString());
            return sb.toString();
        }else{
            String str1 = lpsRecur(s,i,j-1,memoMap);
            Map<Integer,String> mm;
            if(memoMap.containsKey(i)){
                mm = memoMap.get(i);
            }else{
                mm = new HashMap<>();
                memoMap.put(i,mm);
            }
            mm.put(j-1,str1);


            String str2 = lpsRecur(s,i+1,j,memoMap);
            if(memoMap.containsKey(i+1)){
                mm = memoMap.get(i+1);
            }else{
                mm = new HashMap<>();
                memoMap.put(i+1,mm);
            }
            mm.put(j,str2);

            return str1.length()>str2.length()?str1:str2;
        }
    }

    static String lpsRecur(String s){
        Map<Integer,Map<Integer,String>> memoMap = new HashMap<>();
        return lpsRecur(s.toCharArray(),0,s.length()-1,memoMap);
    }

   /* public int lpsRecursive(String s, int i, int j, int[][] memo) {
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(i==j){
            memo[i][j] = 0;
            return memo[i][j];
        }else{
            System.out.println(s+" 1. i:-> "+i+" j:-> "+j);
            String sb = s.substring(i, j);
            System.out.println(s+" 2. i:-> "+i+" j:-> "+j +" -> "+sb);
            if(isPalindrome(sb)){
                memo[i][j] = sb.length();
                if(max<memo[i][j]){
                    max = memo[i][j];
                    subString = sb;
                }
                return sb.length();
            }else{
                memo[i][j] = Math.max(lpsRecursive(sb, i+1,j,memo),
                        lpsRecursive(sb, i,j-1,memo));
                return memo[i][j];
            }
        }
    }

    public String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        int[][] memo = new int[s.length()+1][s.length()+1];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        lpsRecursive(s,0,s.length(),memo);
        return subString;
    }*/

    public static void main(String[] args){
        P5_trylater p5 = new P5_trylater();

//        System.out.println("babad".substring(2,5));
//        subString = "";
//        max = Integer.MIN_VALUE;
        System.out.println(lpsRecur("cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj"));
//        System.out.println(subString);
//        subString = "";
//        max = Integer.MIN_VALUE;
        System.out.println(lpsRecur("a"));
//        System.out.println(subString);

//        System.out.println(p5.longestPalindrome("babad"));
//        System.out.println(p5.longestPalindrome("bb"));

//        System.out.println(p5.isPalindrome("bab"));
//        System.out.println(p5.isPalindrome("madam"));
//        System.out.println(p5.isPalindrome("racecar"));
//        System.out.println(p5.isPalindrome("raecar"));
    }
}
