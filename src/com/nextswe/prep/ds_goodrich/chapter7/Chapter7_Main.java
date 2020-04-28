package com.nextswe.prep.ds_goodrich.chapter7;

import com.nextswe.prep.ds_goodrich.chapter6.*;

import java.util.Arrays;
import java.util.Collections;

public class Chapter7_Main {

    public static void insertionSort(PositionalList<Integer> list){
        Position<Integer> marker = list.first();
        while(marker!=list.last()){
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement();
            if(value>marker.getElement()){
                marker = pivot;
            }else{
                Position<Integer> walk = marker;
                while(walk!=list.first() && list.before(walk).getElement()>value){
                    walk = list.before(walk);
                }
                list.remove(pivot);
                list.addBefore(walk,value);
            }
        }
    }

    public static void main(String[] args){

        Integer[ ] arr = {1, 2, 3, 4, 5, 6, 7, 8}; // allowed by autoboxing
        System.out.println(Arrays.toString(arr));
        java.util.List<Integer> listArr = Arrays.asList(arr);
        Collections.shuffle(listArr);
        System.out.println(Arrays.toString(arr));

        LinkedPositionalList<Integer> pList = new LinkedPositionalList<>();
        for(Integer item: listArr){
            pList.addFirst(item);
        }

        insertionSort(pList);

        for(Position<Integer> item: pList.positions()){
            System.out.print(item.getElement()+" ");
        }
    }
}
