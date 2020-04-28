package com.nextswe.prep.ds_goodrich.chapter8;

import com.nextswe.prep.ds_goodrich.chapter6.LinkedQueue;
import com.nextswe.prep.ds_goodrich.chapter6.Queue;
import com.nextswe.prep.ds_goodrich.chapter7.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p){ return numChildren(p)>0;}
    public boolean isExternal(Position<E> p){ return numChildren(p)==0;}
    public boolean isRoot(Position<E> p){ return p==root(); }
    public boolean isEmpty(){ return size()==0; }
    public int depth(Position<E> p){
        if(p==root()){
            return 0;
        }else{
            return 1 + depth(parent(p));
        }
    }
    /*
        Returns the height of the tree
     */
    private int heightBad(){ //works, but quadratic worst-case time
        int h = 0;
        for(Position<E> p: positions()){
            if(isExternal(p)){
                h = Math.max(h,depth(p));
            }
        }
        return h;
    }

    public int height(Position<E> p){
        // implicit base case, since if p is external(has no children)
        // it will not enter in for loop, which will return 0 to it's caller
        int h=0;
        for(Position<E> c: children(p)){
            h = Math.max(h,1+height(c));
        }
        return h;
    }
    // It has an implicit base case, as the for loop body never executes
    // if a position has no children.
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);
        for(Position<E> c: children(p))
            preorderSubtree(c,snapshot);
    }

    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            preorderSubtree(root(),snapshot);
        return snapshot;
    }

    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        for(Position<E> c: children(p))
            preorderSubtree(c,snapshot);
        snapshot.add(p);
    }

    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            postorderSubtree(root(),snapshot);
        return snapshot;
    }

    public Iterable<Position<E>> breadthfirst(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());
            while(!fringe.isEmpty()){
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for(Position<E> c: children(p)){
                    fringe.enqueue(c);
                }
            }
        }
        return snapshot;
    }

    //Returns an iterable collection of all positions of the tree
    public Iterable<Position<E>> positions() {
        return preorder();
    }
}
