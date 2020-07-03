package com.nextswe.prep.aditya_verma.recursion;

public class PermutationWithCaseChange {
    private static void solve(String ip, String op){
        if(ip.length()==0){
            System.out.println(op);
            return;
        }
        if(Character.isLetter(ip.charAt(0))){
            String op1 = op + Character.toLowerCase(ip.charAt(0));
            String op2 = op + Character.toUpperCase(ip.charAt(0));
            ip = ip.substring(1);
            solve(ip,op1);
            solve(ip,op2);
        }else{
            op = op + ip.charAt(0);
            ip = ip.substring(1);
            solve(ip,op);
        }
    }
    public static void main(String[] args){
        solve("a1B2","");
//        String aa = "01b2";
//        String.toUpperCase();
//        if(Character.getNumericValue(aa.charAt(0))>=0 && Character.getNumericValue(aa.charAt(0))<=9){
//            System.out.println(aa.charAt(0));
//        }
//        System.out.println(Character.getNumericValue('1'));

    }
}
