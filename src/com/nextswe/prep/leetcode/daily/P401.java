package com.nextswe.prep.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

//Don't try this at home :D
//Accepted backtracking solution,
//took me almost 6 hour by going back and forth with the concept of backtracking
//elegant by tricky to to think
//if you have somehow thought of the solution
//it is more trickier to implement :P
//need more study and practice for recursion and backtracking ....
public class P401 {
    //cleaned version
    //below is the commented version with every possible debugging :(
    public void readBinaryWatch(int hour, int min, int choices, int start_pos, int end_pos, List<String> result){
        if(choices==0){
            if(hour<=11 && min<=59 && (hour>0 || min >0)){
                String res = hour+":"+((min<=9)?("0"+min):min);
                result.add(res);
            }
        }else {
            int val = 0;
            for(int i=start_pos;i<end_pos;i++){
                val = 0;
                if(choices>=1){
                    val = (i<4)?(1 << (3 - i)):(1<<5-(i-4));
                }
                if(choices>=1){
                    if(i<4) {
                        hour += val;
                    }else{
                        min += val;
                    }
                }
                readBinaryWatch(hour, min, choices-1, i + 1, end_pos,result);
                if(choices>=1){
                    if(i<4) {
                        hour -= val;
                    }else{
                        min -= val;
                    }
                }
            }
        }
    }

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        if(num>0) {
            readBinaryWatch(0, 0, num, 0, 10, result);
        }else{
            result.add("0:00");
        }
        return result;
    }

    //DO NOT DELETE (For future reference :) )
    /*
    public void readBinaryWatch(int[] num, int hour, int min, int choices, int start, int end, List<String> result){
        if(choices==0){
//            System.out.print("hour1: "+hour+" ");
//            System.out.println(" min1: "+min);
//            int hr = hour>=12?(hour%12):hour;
//            int mn = min>=64?(min%64):min;
            if(hour<=11 && min<=59 && (hour>0 || min >0)){

                String res = hour+":"+((min<=9)?("0"+min):min);
                result.add(res);

                System.out.println(res);
//            System.out.println(min%63);
                System.out.println(Arrays.toString(num));
            }
//            int hr = hour;
//            int mn = min;
//
////            System.out.println("hour2: "+hour+" min2: "+min);
////            System.out.println(min);
////            int hr = hour>12?(hour%12):hour;
////            int mn = min>63?min%63:min;
//            if(hr==0 && mn == 0){
////                System.out.println("hour2: "+hour+" min2: "+min);
////                System.out.println(Arrays.toString(num));
//            }else{
//                String res = hr+":"+((mn<=9)?("0"+mn):mn);
//                result.add(res);
//            }
//
////            System.out.println(res);
////            System.out.println(min%63);
//            System.out.println(Arrays.toString(num));
        }else {
            int val_hr = 0;
            int val_mn = 0;
            for(int i=start;i<end;i++){
                num[i] = (choices>=1?1:0);
                val_hr = 0;
                val_mn = 0;
                if(choices>=1){
                    if(i<4) {
                        val_hr = (1 << (3 - i));
                    }else{
                        val_mn = (1<<5-(i-4));
                    }
                }

                if(choices>=1){
                    if(i<4) {
                        hour += val_hr;
                    }else{
                        min += val_mn;
                    }
                }

                readBinaryWatch(num, hour, min, choices-1, i + 1, end,result);

                if(choices>=1){
                    if(i<4) {
                        hour -= val_hr;
                    }else{
                        min -= val_mn;
                    }
                }

//                if(choices>=1 && i<4){
//                    hour -= val;
//                }
//                hour = 0;
//                min = 0;
                num[i] = 0;
            }
        }
    }

    public List<String> readBinaryWatch(int num) {
        int[] nmm = new int[]{0,0,0,0,0,0,0,0,0,0};
        List<String> result = new ArrayList<>();
        if(num>0) {
            readBinaryWatch(nmm, 0, 0, num, 0, 10, result);
        }else{
            result.add("0:00");
        }
        return result;
    }
    */
}
