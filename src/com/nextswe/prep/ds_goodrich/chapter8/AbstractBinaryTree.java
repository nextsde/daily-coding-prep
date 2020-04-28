package com.nextswe.prep.ds_goodrich.chapter8;

import com.nextswe.prep.ds_goodrich.chapter7.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    public Position<E> sibling(Position<E> p){
        Position<E> parent = parent(p);
        //it might be tree's root since it does not have any parent
        //asking for root's sibling not going to give any result since he is the root
        if(parent==null)return null;
        if(p==left(parent)){
            return right(parent); //might be null
        }else{
            return left(parent);  //might be null
        }
    }

    public int numChildren(Position<E> p){
        int count = 0;
        if(left(p)!=null){
            count++;
        }
        if(right(p)!=null){
            count++;
        }
        return count;
    }

    public Iterable<Position<E>> children(Position<E> p){
        List<Position<E>> snapshot = new ArrayList<>(2);
        if(left(p)!=null){
            snapshot.add(left(p));
        }
        if(right(p)!=null){
            snapshot.add(right(p));
        }
        return snapshot;
    }

    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot){
        if(left(p)!=null)
            inorderSubtree(left(p),snapshot);
        snapshot.add(p);
        if(right(p)!=null)
            inorderSubtree(right(p),snapshot);
    }

    public Iterable<Position<E>> inorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            inorderSubtree(root(),snapshot);
        return snapshot;
    }

    public Iterable<Position<E>> positions(){
        return inorder();
    }
}
