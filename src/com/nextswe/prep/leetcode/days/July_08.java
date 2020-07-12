package com.nextswe.prep.leetcode.days;

import java.util.HashSet;
import java.util.Set;

public class July_08 {
    public static boolean isPathCrossing(String path) {
        Set<String> seen = new HashSet<>();
        int x_pos = 0;
        int y_pos = 0;
        seen.add(x_pos+","+y_pos);
        for(char c:path.toCharArray()){
            if(c=='N'){
                y_pos +=1;
            }else if(c=='S'){
                y_pos -=1;
            }else if(c=='E'){
                x_pos += 1;
            }else{
                x_pos -= 1;
            }
            if(seen.contains(x_pos+","+y_pos)){
                return true;
            }
            seen.add(x_pos+","+y_pos);
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(isPathCrossing("WSSESEEE"));
    }
}
