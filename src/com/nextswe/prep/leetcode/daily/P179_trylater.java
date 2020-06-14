package com.nextswe.prep.leetcode.daily;

public class P179_trylater {
//    public int getBigger(int n1, int n2){
//        if(n1==n2){
//            return n1;
//        }
//        int num1 = n1;
//        int num2 = n2;
//
//        int d1 = (int)Math.floor(Math.log10(num1));
//        int d2 = (int)Math.floor(Math.log10(num2));
//        int ldn1=-1,ldn2=-1;
//        while(d1>-1 || d2>-1){
//            int cdn1 = ldn1>0?ldn1:(int) (num1 / Math.pow(10,d1));
////            System.out.println(cdn1);
//            int cdn2 = ldn2>0?ldn2:(int) (num2 / Math.pow(10,d2));
////            System.out.println(cdn2);
//            num1 -= (cdn1*Math.pow(10,d1));
//            num2 -= (cdn2*Math.pow(10,d2));
//            if(cdn1>cdn2){
//                return n1;
//            }else if(cdn2>cdn1){
//                return n2;
//            }else{
//                d1--;
//                d2--;
//            }
////            System.out.println("d1: "+d1+" d2:"+d2);
//            if(d1<0){
//                ldn1 = cdn1;
//            }
//            if(d2<0){
//                ldn2 = cdn2;
//            }
//        }
//        return 0;
//    }

    public int getBigger(int num1, int num2){
        if(num1==num2){
            return num1;
        }
        int d1 = (int)Math.floor(Math.log10(num1))+1;
        int d2 = (int)Math.floor(Math.log10(num2))+1;
        int td = d1 + d2;
        double val1 = (num1 * Math.pow(10,td-d1)) + num2;
        double val2 = (num2 * Math.pow(10,td-d2)) + num1;
        if(val1>val2){
            return num1;
        }else{
            return num2;
        }
    }
    private int getPivot(int[] nums, int start, int end){
        int pv = nums[end];
        int pi = start;
        for(int i=start;i<end;i++){
            if(getBigger(nums[i],pv)==pv){
                int tmp = nums[pi];
                nums[pi] = nums[i];
                nums[i] = tmp;
                pi++;
            }
        }

        int tmp = nums[end];
        nums[end] = nums[pi];
        nums[pi] = tmp;

        return pi;
    }
    private void quick_sort(int[] nums, int start, int end){
        if(start<end){
            int pIndex = getPivot(nums,start,end);
            quick_sort(nums,start,pIndex-1);
            quick_sort(nums,pIndex+1,end);
        }
    }

    private void quick_sort(int[] nums){
        quick_sort(nums,0,nums.length-1);
    }

    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if(nums.length>0){
            boolean allZero = true;
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]!=0){
                    allZero = false;
                    break;
                }
            }
            if(allZero){
                sb.append('0');
            }else{
                quick_sort(nums);
                for(int i=nums.length-1;i>=0;i--){
                    sb.append(nums[i]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        P179_trylater mP179 = new P179_trylater();
//        System.out.println(mP179.largestNumber(new int[]{999999998,999999997,999999999}));
        System.out.println(mP179.largestNumber(new int[]{0,1,2,3,4,5,6,7,8}));
//        System.out.println(mP179.largestNumber(new int[]{43,432}));
//        System.out.println(mP179.largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}));
//        System.out.println(mP179.largestNumber(new int[]{1,2,3,3,10,20,30,11,22,33,112,221,332,43,43,1212,121212,232,3232,2321,213,123,432,6,111,5}));

//        System.out.println(mP179.largestNumber(new int[]{3,30,34,5,9}));
    }
}
