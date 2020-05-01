package com.nextswe.prep.leetcode.daily;

//https://leetcode.com/problems/remove-outermost-parentheses/
public class P1021 {
    //my solution accepted
    public String removeOuterParentheses(String S) {
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int start_null_p = 0;
        int rSum = 0;
        for(int j=0;j<S.length();j++){
            rSum += arr[j]=='('?1:-1;
            if(rSum==0){
                start_null_p = j+1;
            }else if(start_null_p!=j){
                sb.append(arr[j]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        P1021 mP1021 = new P1021();
        System.out.println(mP1021.removeOuterParentheses("(()())(())"));
        System.out.println(mP1021.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(mP1021.removeOuterParentheses("()()"));
        System.out.println(mP1021.removeOuterParentheses("((()())(()()))"));
    }

    //others solution
    /*
    When a valid pa
     */
    /*
    public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }
     */
}
