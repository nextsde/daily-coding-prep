package com.nextswe.prep.ds_goodrich.chapter11;

import com.nextswe.prep.ds_goodrich.chapter7.Position;
import com.nextswe.prep.ds_goodrich.chapter9.Entry;

import java.util.Comparator;
//this one is good
//https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/datastructures/balancedtree/AVLTreeRecursive.java

public class AVLTreeMap<K,V> extends TreeMap<K,V>{
    public AVLTreeMap(){ super(); }
    public AVLTreeMap(Comparator<K> comp){ super(comp); }
    /* Returns the height of the given tree position. */
    protected int height(Position<Entry<K,V>> p){ return tree.getAux(p); }
    /* Recomputes the height of the given position based on its children's heights. */
    protected void recomputeHeight(Position<Entry<K,V>> p){
        tree.setAux(p,1+Math.max(height(left(p)),height(right(p))));
    }
    /* Returns whether a position has balance factor between −1 and 1 inclusive. */
    protected boolean isBalanced(Position<Entry<K,V>> p){
        return Math.abs(height(left(p))-height(right(p))) <= 1;
    }
    /* Returns a child of p with height no smaller than that of the other child. */
    protected Position<Entry<K,V>> tallerChild(Position<Entry<K,V>> p){
        if(height(left(p))>height(right(p))) return left(p);
        if(height(left(p))<height(right(p))) return right(p);
        // equal height children; break tie while matching parent's orientation
        if(isRoot(p)) return left(p);
        if(p==left(parent(p))) return left(p);
        else return right(p);
    }

    protected void rebalance(Position<Entry<K,V>> p){
        int oldHeight, newHeight;
        do{
            oldHeight = height(p);
            if(!isBalanced(p)){
                p = tree.restructure(tallerChild(tallerChild(p)));
                recomputeHeight(left(p));
                recomputeHeight(right(p));
            }
            recomputeHeight(p);
            newHeight = height(p);
            p = parent(p);
        }while(oldHeight!=newHeight && p!=null);
    }

    protected void rebalanceInsert(Position<Entry<K,V>> p){
        rebalance(p);
    }

    protected void rebalanceDelete(Position<Entry<K,V>> p){
        if(!isRoot(p)){
            rebalance(parent(p));
        }
    }
}
