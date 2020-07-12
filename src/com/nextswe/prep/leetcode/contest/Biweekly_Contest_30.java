package com.nextswe.prep.leetcode.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Biweekly_Contest_30 {
    private Map<String, String> monthMap = new HashMap<String, String>() {{
        put("Jan","01");put( "Feb","02");put( "Mar","03");put( "Apr","04");put( "May","05");put( "Jun","06");put( "Jul","07");put( "Aug","08");put( "Sep","09");put( "Oct", "10");put("Nov","11");put( "Dec","12");
    }};


    public String reformatDate(String date) {
        String[] splitted = date.split(" ");

        StringBuilder sb = new StringBuilder();

        String day = splitted[0].replaceAll("[^0-9]","");
        String month = monthMap.get(splitted[1]);
        String year = splitted[2];

        sb.append(year);
        sb.append("-");
        sb.append(month);
        sb.append("-");
        if(day.length()>1){
            sb.append(day);
        }else{
            sb.append("0");
            sb.append(day);
        }

        return sb.toString();
    }


    //https://www.geeksforgeeks.org/modulo-1097-1000000007/
    static int M = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        if(nums.length!=n || left>right){
            return -1;
        }
        int nn = (n*(n+1))/2;
        int[] narr = new int[nn];
        int k=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                narr[k] = sum;
                k++;
            }
        }
        Arrays.sort(narr);
        int finalSum = 0;
        for(int i=left-1;i<right;i++){
            finalSum = (finalSum + narr[i])%M;
        }
        return finalSum;
    }


    public static void main(String[] args){
        Biweekly_Contest_30 mBiweekly_Contest_30 = new Biweekly_Contest_30();
        System.out.println(mBiweekly_Contest_30.rangeSum(new int[]{1,2,3,4},4,1, 5));
        System.out.println(mBiweekly_Contest_30.rangeSum(new int[]{1,2,3,4},4,3, 4));
        System.out.println(mBiweekly_Contest_30.rangeSum(new int[]{1,2,3,4},4,1, 10));
        System.out.println(mBiweekly_Contest_30.rangeSum(new int[]{1,2,3,4},4,10, 10));


    }
}
