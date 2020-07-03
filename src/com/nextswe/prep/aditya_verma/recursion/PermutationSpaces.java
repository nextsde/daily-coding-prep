package com.nextswe.prep.aditya_verma.recursion;
//https://www.youtube.com/watch?v=1cspuQ6qHW0
public class PermutationSpaces {
    private static void solve(String input, int pos, String op){
        if(pos==input.length()){
            System.out.println(op);
            return;
        }
        if(pos==0){
            op = op+input.charAt(pos);
            solve(input,pos+1,op);
        }else{
            //two choices
            //include the pos character with spaces or without spaces
            String op1 = op+' '+input.charAt(pos);
            solve(input,pos+1,op1);
            String op2 = op+input.charAt(pos);
            solve(input,pos+1,op2);
        }
    }
    public static void main(String[] args){
        solve("ABC",0,"");
    }
}
