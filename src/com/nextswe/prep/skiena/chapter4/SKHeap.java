package com.nextswe.prep.skiena.chapter4;

public class SKHeap {

    public static int pq_parent(int n){
        if(n==1){return -1;}
        else return (n/2);
    }

    public static int pq_young_child(int n){
        return 2*n;
    }

    public static void pq_insert(SKPriorityQ q, int x){
        if(q.size >= q.capacity){
            System.out.println("Warning overflow x="+x);
        }else{
            q.size = q.size+1;
            q.q[q.size] = x;
            bubble_up(q, q.size);
        }
    }


    private static void bubble_up(SKPriorityQ q, int p){
        if(pq_parent(p)==-1) return; // item is now at top... no need to do anything

        if(q.q[pq_parent(p)]>q.q[p]){
            pq_swap(q,p,pq_parent(p));
            bubble_up(q,pq_parent(p));
        }
    }

    private static void pq_swap(SKPriorityQ q, int child, int parent){
        int tmp = q.q[parent];
        q.q[parent] = q.q[child];
        q.q[child] = tmp;
    }

    public static SKPriorityQ make_min_heap(int[] A){
        int i;
        SKPriorityQ skp = new SKPriorityQ(100);

        for(i=0;i<A.length;i++){
            pq_insert(skp,A[i]);
        }

        return skp;
    }

    public static SKPriorityQ make_min_heap_fast(int[] A){
        int i;
        SKPriorityQ skp = new SKPriorityQ(100);
        skp.size = A.length;

        for(i=0;i<A.length;i++){
            skp.q[i+1] = A[i];
        }

        for(i=skp.size;i>=1;i--){
            bubble_down(skp,1);
        }

        return skp;
    }

    public static int extract_min(SKPriorityQ q){
        int min = - 1;
        if(q.size<=0)System.out.println("Warning: empty");
        else{
            min = q.q[1];
            q.q[1] = q.q[q.size];
            q.size = q.size - 1;
            bubble_down(q,1);
        }

        return min;
    }

    public static void bubble_down(SKPriorityQ q, int p){
        int c; //first child index
        int i; //counter to get appropriate lowest value child index to store in min_index
        int min_index; //index of lowest value child

        c = pq_young_child(p);
        min_index = p;

        for(i=0;i<=1;i++){
            if((c+i)<=q.size){
                if(q.q[min_index]>q.q[c+i]) min_index = c+i;
            }
        }

        if(min_index!=p){
            pq_swap(q,p,min_index);
            bubble_down(q,min_index);
        }
    }

    public static void heap_sort_by_extract_min(int[] A){
        SKPriorityQ skp = make_min_heap_fast(A);
        for(int i=0;i<A.length;i++){
            A[i] = extract_min(skp);
        }
    }
}
