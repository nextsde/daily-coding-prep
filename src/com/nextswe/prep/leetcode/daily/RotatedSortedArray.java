package com.nextswe.prep.leetcode.daily;

public class RotatedSortedArray {
    public static void searchRotatedSortedArray(int[] arr, int target){
        //{4,5,6,7,0,1,2}
        //{4,5,6,7,0,1,2,3}
        //{4,5,6,7,8,0,1}

        // 0,6 m=3
        //{4,5,6,7,0,1,2} //6
/*
        int low  = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int mid_val = arr[mid];
            if(mid_val==target){
                System.out.println(mid);
                break;
            }
            boolean am_big = mid_val>=arr[low];
            boolean target_big = target>=arr[low];
            if(am_big && target_big){
                if(mid_val<target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }else{
                if(am_big){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
*/
//        int first = arr[0];
//        int low = 0;
//        int high = arr.length-1;
//        while(low<high){
//            int mid = low + (high-low)/2;
//            int value = arr[mid];
//            if(value>=first){
//                low = mid+1;
//            }else{
//                high = mid;
//            }
//        }


//        int low = 0;
//        int high = arr.length-1;
//        int last = arr[high];
//        while(low<high){
//            int mid = low + (high-low)/2;
//            int value = arr[mid];
//            if(value>last){
//                low = mid+1;
//            }else{
//                high = mid;
//            }
//        }

        int low = 0;
        int high = arr.length-1;
        int last = arr[high];
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int value = arr[mid];
            if(value>last){
                low = mid+1;
            }else{
                ans = mid;
                high = mid-1;
            }
        }

        int start = ans;
        low = 0;
        high = arr.length-1;

        if(arr[start]<=target && target<=arr[high]){
            low = start;
        }else{
            high = start-1;
        }

        while(low<=high){
            int mid = low+(high-low)/2;;
            if(arr[mid]==target){
                System.out.println(" mid: "+mid);
                break;
            }else if(arr[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
//        System.out.println("low: "+low+" high: "+high);
    }

    public static void main(String[] args){
        searchRotatedSortedArray(new int[]{0,1,2},1);
        searchRotatedSortedArray(new int[]{4,5,6,7,0,1,2},1);
        searchRotatedSortedArray(new int[]{4,5,6,7,0,1,2,3},4);
        searchRotatedSortedArray(new int[]{4,5,6,7,8,0,1},0);
        searchRotatedSortedArray(new int[]{4,5,6,7,0,1,2},6);
    }
}
