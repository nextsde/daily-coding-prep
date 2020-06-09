package com.nextswe.prep.ctci;

import com.nextswe.prep.ds_goodrich.chapter2.Pair;

import java.util.*;

public class ChapterVII {
    private int pow(int a, int power){
        return (int)Math.pow(a,power);
    }
    public void computeABCD3(int n){
        //n^4
//        for(int a=0;a<n;a++){
//            for(int b=0;b<n;b++){
//                for(int c=0;c<n;c++){
//                    for(int d=0;d<n;d++){
//                        if(pow(a,3)+pow(b,3) == pow(c,3)+pow(d,3)){
//                            System.out.println(" a "+a+" b "+b+" c "+c+" d "+d);
//                        }
//                    }
//                }
//            }
//        }
        //n^3
//        for(int a=0;a<n;a++){
//            for(int b=0;b<n;b++){
//                for(int c=0;c<n;c++){
//                    int d = (int)Math.pow(a+b+c,1.0/3.0);
//                    if(pow(a,3)+pow(b,3) == pow(c,3)+pow(d,3)){
//                        System.out.println(" a "+a+" b "+b+" c "+c+" d "+d);
//                    }
//                }
//            }
//        }
        //n^2
        Map<Integer, List<Pair<Integer,Integer>>> map = new HashMap<>();
        for(int c=0;c<n;c++){
            for(int d=0;d<n;d++){
                int r = pow(c,3)+pow(d,3);
                List<Pair<Integer,Integer>> list = null;
                if(map.containsKey(r)){
                    list = map.get(r);
                }else{
                    list = new ArrayList<>();
                    map.put(r,list);
                }
                list.add(new Pair<>(c,d));
            }
        }

//        for(int a=0;a<n;a++){
//            for(int b=0;b<n;b++){
//                int r = pow(a,3) + pow(b,3);
//                List<Pair<Integer,Integer>> list = map.get(r);
//                for(Pair<Integer,Integer> p:list){
//                    System.out.println(" a "+a+" b "+b+" c "+p.getFirst()+" d "+p.getSecond());
//                }
//            }
//        }

        for(Map.Entry<Integer, List<Pair<Integer,Integer>>> entry: map.entrySet()){
            for(Pair<Integer,Integer> pair1:entry.getValue()){
                for(Pair<Integer,Integer> pair2:entry.getValue()){
                    System.out.println(" a "+pair1.getFirst()+" b "+pair1.getSecond()+" c "+pair2.getFirst()+" d "+pair2.getSecond());
                }
            }
        }
    }

    public void bcrExp1(){
        //
        int[] A = {13, 27, 35, 40, 49, 55, 70};
        int[] B = {17, 35, 39, 40, 55, 58, 60};
        //BCR (Best Conceivable Runtime) is: O(n)
        //O(n^2)
//        for(int i=0;i<A.length;i++){
//            for(int j=0;j<B.length;j++){
//                if(A[i]==B[j]){
//                    System.out.print(A[i]+" ");
//                }
//            }
//        }
        //since second for loop is there for searching, we can reduce that but we can not reduce more than O(n)
        //and we know in a sorted list we can do binary search to find an element in logn time
        //so our improved algorithm
        //O(nlogn)
//        for(int i=0;i<A.length;i++){
//            int id = Arrays.binarySearch(B,A[i]);
//            if(id>0){
//                System.out.print(A[i]+" ");
//            }
//        }
        //since from bcr we can tell
        //we will never have a runtime better than O(n)
        //therefore any work we do in O(n) outside the loop is freebie, since it won't impact our runtime
        //we can do some upfront work within O(n)
        //this will improve our runtime to O(n)
        //but with added space complexity O(n)
        //precomputation
//        Set<Integer> set = new HashSet<>();
//        for(int i=0;i<B.length;i++){
//            set.add(B[i]);
//        }
//        for(int i=0;i<A.length;i++){
//            if(set.contains(A[i])){
//                System.out.print(A[i]+" ");
//            }
//        }
        //can we do better?
        //When we used hashtable, this solution work even if arrays are not sorted.
        //then why do we have a sorted element?
        //there must be a reason we got a problem like this
        //maybe we we can take advantage of the sorting property of our array
        //yes we can

        //when we did binary search in B if the element found/not found in B is greater or equal to A[i]
        //we can discard those element from B in our next binary search.
        //after careful observation we can see we don't even need binary search
        //check if A[i] == B[j] then increment j+1
        //also if A[i] is bigger then B[j] we will not find anything until B[j] is bigger than A[i]
        //keep incrementing j until B[j] is bigger
        int j=0;
        for(int i=0;i<A.length;i++){
            while(j<B.length && B[j]<A[i]){
                j++;
            }
            if(j<B.length && B[j]==A[i]) {
                System.out.print(A[i] + " ");
                j++;
            }
        }
    }

    public static void findAllPermutation(String s, String b){
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int s_len = s.length();
        for(int i=0;i<b.length()-s_len+1;i++){
            if(map.containsKey(b.charAt(i))){
                String sub = b.substring(i,i+s_len);
                if(isPermutation(sub,map)){
                    System.out.println(sub);
                }
            }
        }
    }

    public static boolean isPermutation(String s, Map<Character,Integer> map){
        Map<Character,Integer> nmap = new HashMap<>();
        for(Character c: map.keySet()){
            nmap.put(c,map.get(c));
        }
        for(int i=0;i<s.length();i++){
            char cc = s.charAt(i);
            nmap.put(cc,nmap.getOrDefault(cc,0)-1);
        }
        for(Character cc: nmap.keySet()){
            if(nmap.get(cc)>0){
                return false;
            }
        }
        return true;
    }

    public static void countPairs(){
        int[] A = {3,1,4,1,5};
//        int[] A = {1,7,5,9,2,12,3};
        int n = A.length;
        int k = 2;
        //brute force
        //in here the bottleneck is repeated searching for the other side
        //when we have found A[i] we are looking for through each element except A[i]
        //to check if A[j] is the other side or not
        //we can optimize that
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(Math.abs(A[i]-A[j])==k){
                    System.out.print("["+A[i]+","+A[j]+"],");
                }
            }
        }
        //we know |A[i]-A[j]| = k so, |A[i]-k| = A[j]
        //first optimization: if we sort the array we can optimize the second step to be
        //by using binary search in the sorted array
//        Arrays.sort(A);
//        for(int i=0;i<n;i++){
//            int otherside = A[i]-k;
//            if(Arrays.binarySearch(A,otherside)>=0){
//                System.out.print("["+A[i]+","+otherside+"],");
//            }
//        }
    }

    public static void main(String[] args){
        ChapterVII mChapterVII = new ChapterVII();
//        findAllPermutation("abbc","cbabadcbbabbcbabaabccbabc");
        countPairs();
    }
}
