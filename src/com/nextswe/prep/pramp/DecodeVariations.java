package com.nextswe.prep.pramp;

import java.util.ArrayList;
import java.util.List;

public class DecodeVariations {
    static void solve(String ip, String op, List<String> lst){
        if(ip.length()==0){
            lst.add(op);
            return;
        }
        String op1 = op + ip.substring(0,1);
        String ip1 = ip.substring(1);
        solve(ip1,op1,lst);
        if(ip.length()>1){
            String op2 = op;
            String v = ip.substring(0,2);
            int vv = Character.getNumericValue(v.charAt(0))*10+Character.getNumericValue(v.charAt(1));
            if(vv<=26){
                op2 = op2 + v;
                String ip2 = ip.substring(2);
                solve(ip2,op2,lst);
            }
        }
    }

    static int decodeVariations(String S) {
        List<String> lst = new ArrayList<>();
        if(S.contains("0")){
            return lst.size();
        }
        solve(S,"",lst);
        return lst.size();
    }

    public static void main(String[] args) {
        System.out.println(decodeVariations("1270"));
    }

}
