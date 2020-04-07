package com.nextswe.prep.leetcode.april30;

import com.nextswe.prep.utils.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Apr7 {
    //solution 2 //accepted
    //from hint
    //time complexity: O(n) space complexity: O(n)
    public int countElements(int[] arr) {
        if(arr.length==0 || arr.length==1){
            return 0;
        }
        Set<Integer> integerSet = new HashSet<>();
        for (int item : arr) {
            integerSet.add(item);
        }

        int count = 0;
        for (int value : arr) {
            if (integerSet.contains(value + 1)) {
                count++;
            }
        }
        return count;
    }

    //solution 1
    //accepted
    //time complexity:O(nlogn) space complexity:O(1) if sort uses in place sorting
/*    public boolean binSearch(int[] arr, int size, int item){
        int l = 0;
        int r = size-1;
        int m = 0;
        while(l<=r){
            m = (l+r)/2;
            if(arr[m]<item){
                l = m+1;
            }else if(arr[m]>item){
                r = m-1;
            }else{
                return true;
            }
        }
        return false;
    }
    public int countElements(int[] arr) {
        if(arr.length==0 || arr.length==1){
            return 0;
        }
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++){
            if(binSearch(arr,n, arr[i]+1)){
                count++;
            }
        }
        return count;
    }
*/

    public static void main(String[] args){
        Apr7 apr7 = new Apr7();
        Utils.println(apr7.countElements(new int[]{1,1,2,2}));
        Utils.println(apr7.countElements(new int[]{1,1,3,3,5,5,7,7}));
        Utils.println(apr7.countElements(new int[]{1,2,3}));
        Utils.println(apr7.countElements(new int[]{1,3,2,3,5,0}));

    }
}
