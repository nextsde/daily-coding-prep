package com.nextswe.prep.ds_goodrich.chapter8;

import com.nextswe.prep.ds_goodrich.chapter7.Position;

import java.util.ArrayList;

public class Chapter8_Main {
    /** Returns a string containing n spaces. */
    public static String spaces(int n) {
        StringBuilder sb = new StringBuilder();
        for (int j=0; j < n; j++)
            sb.append(' ');
        return sb.toString();
    }

    public static <E> void unindentedPreorder(LinkedBinaryTree<E> T){
        for(Position<E> p: T.preorder()){
            System.out.println(p.getElement());
            // System.out.println(spaces(2*T.depth(p))+p.getElement()); // -> O(n^2)
        }
    }

    public static <E> void printPreorderIndent(Tree<E> T, Position<E> p, int d){
        System.out.println(spaces(2*d) + p.getElement());
        for(Position<E> c: T.children(p)){
            printPreorderIndent(T, c, d+1);
        }
    }

    public static <E> void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path){
        int d = path.size();
        System.out.print(spaces(2*d));
        for(int j=0;j<d;j++) System.out.print(path.get(j)+(j==d-1?" ":"."));
        System.out.println(p.getElement());
        path.add(1);
        for(Position<E> c:T.children(p)){
            printPreorderLabeled(T,c,path);
            path.set(d,1+path.get(d));
        }
        path.remove(d);
    }

    public static int diskSpace(Tree<Integer> T,Position<Integer> p){
        int subtotal = p.getElement();
        for(Position<Integer> c:T.children(p))
            subtotal += diskSpace(T,c);
        return subtotal;
    }

    public static <E> void parenthesize(Tree<E> T, Position<E> p){
        System.out.print(p.getElement());
        if(T.isInternal(p)){
            boolean firstTime = false;
            for(Position<E> c:T.children(p)){
                System.out.print(firstTime?" (":", ");
                firstTime = false;
                parenthesize(T,c);
            }
            System.out.print(")");
        }
    }

    public static <E> int layout(BinaryTree<E> T, Position<E> p, int d, int x){
        /*
        if(T.left(p)!=null){
            x = layout(T,T.left(p),d+1,x);
        }
        p.getElement().setX(x++);
        p.getElement().setY(d);
        if(T.right(p)!=null){
            x = layout(T,T.right(p),d+1,x);
        }
        */
        return x;
    }
}
