package com.nextswe.prep.abdulbari;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Complexity analysis:
T(n) = {
    1           -> n=1
    T(n/2)+1    -> n>1
}
From Master Theorem:
T(n) = aT(n/b) + f(n)
f(n) = BigTheta(n^k*(logn)^p) a>=1, b>1
case 2: log(base b)a == k
        if p > -1, Time Complexity: BigTheta(n^k*(log(base 2)n)^(p+1))
for binary search: a = 1, b = 2 > log(base 2)1 = 0, k = 0 since (n^0) = 1,
so, BigTheta(n^0*(log(base 2)n)^(0+1)) = BigTheta(log(base2 )n) or O(logn)
 */
public class BinarySearchRecursive {
    public static int RBinarySearch(Integer[] A, int l, int h, int key){
        if(l==h){
            if(A[l]==key){
                return l;
            }else{
                return 0;
            }
        }else{
            int mid = (l+h)/2;
            if(key == A[mid]){
                return mid;
            }else if(key < A[mid]){
                return RBinarySearch(A, l, mid-1,key);
            }else{
                return RBinarySearch(A, mid+1, h,key);
            }
        }
    }

    public static void main(String[] args){
        Integer[] arr = {1,2,3,4,5,6,7,8,9};
        List<Integer> list = Arrays.asList(arr);
        Collections.shuffle(list);
        System.out.println(RBinarySearch(arr,0,arr.length-1,9));
    }
}
