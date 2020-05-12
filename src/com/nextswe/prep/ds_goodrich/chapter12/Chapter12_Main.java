package com.nextswe.prep.ds_goodrich.chapter12;

import com.nextswe.prep.ds_goodrich.chapter6.LinkedQueue;
import com.nextswe.prep.ds_goodrich.chapter6.Queue;
import com.nextswe.prep.utils.Utils;

import java.util.Arrays;
import java.util.Comparator;

public class Chapter12_Main {
    /*
    Merge contents of arrays S1 and S2 into properly sized array S.
     */
    public static <K> void mergeArray(K[] S1, K[] S2, K[] S, Comparator<K> comp){
        int i=0,j=0;
        while(i+j<S.length){
            if(j == S2.length || (i<S1.length && comp.compare(S1[i],S2[j])<0)){
                S[i+j] = S1[i++]; // copy ith element of S1 and increment i
            }else{
                S[i+j] = S2[j++]; // copy jth element of S2 and increment j
            }
        }
    }


    /*
    Merge-sort contents of array S.
     */
    public static <K> void mergeSortArray(K[] S, Comparator<K> comp){
        int n = S.length;
        if(n<2)return;
        //divide
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S,0,mid);
        K[] S2 = Arrays.copyOfRange(S,mid,n);
        // conquer (with recursion)
        mergeSortArray(S1,comp);
        mergeSortArray(S2,comp);
        // merge results
        mergeArray(S1,S2,S,comp);
    }

    public static <K> void mergeQueue(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp){
        while(!S1.isEmpty() && !S2.isEmpty()){
            if(comp.compare(S1.first(),S2.first())<0){
                S.enqueue(S1.dequeue());
            }else{
                S.enqueue(S2.dequeue());
            }
        }
        while(!S1.isEmpty())
            S.enqueue(S1.dequeue());
        while(!S2.isEmpty())
            S.enqueue(S2.dequeue());
    }

    public static  <K> void mergeSortQueue(Queue<K> S, Comparator<K> comp){
        int n = S.size();
        if(n<2)return;
        // divide
        Queue<K> S1 = new LinkedQueue<>(); // (or any queue implementation)
        Queue<K> S2 = new LinkedQueue<>();
        while(S1.size()<n/2)
            S1.enqueue(S.dequeue()); // move the first n/2 elements to S1
        while(!S.isEmpty())
            S2.enqueue(S.dequeue()); // move remaining elements to S2
        // conquer (with recursion)
        mergeSortQueue(S1,comp); // sort first half
        mergeSortQueue(S2,comp); // sort second half
        // merge results
        // merge sorted halves back into original
        mergeQueue(S1,S2,S,comp);
    }

    public static <K> void mergeArray(K[] S1, K[] S2, K[] S, int start, int end, Comparator<K> comp){
        int i=0,j=0;
        while(start<=end){
            if(j == S2.length || (i<S1.length && comp.compare(S1[i],S2[j])<0)){
                S[start++] = S1[i++]; // copy ith element of S1 and increment i
            }else{
                S[start++] = S2[j++]; // copy jth element of S2 and increment j
            }
        }
    }

    /*
    Merge-sort contents of array S.
     */
    public static <K> void mergeSortSpaceEfficientArray(K[] S, int start, int end, Comparator<K> comp){
        if(end<=start)return;
        //divide
        int mid = (end+start)/2;
        // conquer (with recursion)
        mergeSortSpaceEfficientArray(S,start, mid, comp);
        mergeSortSpaceEfficientArray(S,mid+1, end, comp);
        K[] S1 = Arrays.copyOfRange(S,start,mid+1);
        K[] S2 = Arrays.copyOfRange(S,mid+1,end+1);
        // merge results
        mergeArray(S1,S2,S,start,end,comp);
    }

    public static <K> void mergeBottom(K[] in, K[] out, Comparator<K> comp,
                                       int start, int inc){
        int end1 = Math.min(start+inc, in.length);
        int end2 = Math.min(start+ 2*inc, in.length);
        int x = start;
        int y = start+inc;
        int z = start;
        while(x<end1 && y<end2){
            if(comp.compare(in[x], in[y])<0)
                out[z++] = in[x++];
            else
                out[z++] = in[y++];
        }
        if(x<end1) System.arraycopy(in, x, out, z, end1 -x);
        else if(y<end2) System.arraycopy(in, y, out, z, end2 -y);
    }

    public static <K> void mergeSortBottomUp(K[] orig, Comparator<K> comp){
        int n = orig.length;
        K[] src = orig;
        K[] dest = (K[]) new Object[n];
        K[] temp;
        for(int i=1;i<n;i*=2){
            for(int j=0;j<n;j+=2*i)
                mergeBottom(src,dest,comp,j,i);
            temp = src; src = dest; dest = temp;
        }
        if(orig!=src)
            System.arraycopy(src, 0, orig, 0, n);
    }

    public static <K> void mergeSortBottomUp1(Comparable<K>[] a){
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        int m = 1;
        while(m<N){
            int i=0;
            while(i<N-m){
                merge(a, aux, i, i+m, Math.min(i+2*m, N));
                i+=2*m;
            }
            m*=2;
        }
    }

    private static <K> void merge(Comparable<K>[] a, Comparable<K>[] aux,
                              int L, int M, int R){
        for(int i=L; i<M; i++) aux[i] = a[i];
        for(int j=M; j<R; j++) aux[j] = a[M+R-1-j];
        int i = L, j = R-1, k=L;
        while(k<R){
            if(aux[j].compareTo((K) aux[i]) < 0){
                a[k] = aux[j--];
            }else{
                a[k] = aux[i++];
            }
            k++;
        }
    }



    public static void main(String[] args){
        Integer[] A = new Integer[]{10,7,8,9,1,5};
        mergeSortBottomUp1(A);

//        mergeSortBottomUp(A,new Comparator<Integer>(){
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1,o2);
//            }
//        });
//        mergeSortSpaceEfficientArray(A,0,A.length-1,new Comparator<Integer>(){
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1,o2);
//            }
//        });
        Utils.printArray(A);
    }
}
