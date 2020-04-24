package com.nextswe.prep.ds_goodrich.chapter2;

public class GenericDemo {
    // This generic method cannot be applied to primitive arrays,
    // because autoboxing does not apply to entire arrays.
    public static <T> void reverse(T[] data){
        int low = 0, high = data.length-1;
        while(low<high){
            T temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
    }
}
