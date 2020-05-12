package com.nextswe.prep.ds_goodrich.chapter11;

import com.nextswe.prep.ds_goodrich.chapter7.Position;
import com.nextswe.prep.ds_goodrich.chapter9.Entry;

import java.util.Comparator;

public class RBTreeMap<K,V> extends TreeMap<K,V> {
    public RBTreeMap(){ super(); }
    public RBTreeMap(Comparator comp){ super(comp); }
    private boolean isBlack(Position<Entry<K,V>> p){ return tree.getAux(p)==0;}
    private boolean isRed(Position<Entry<K,V>> p){ return tree.getAux(p)==1;}
    private void makeBlack(Position<Entry<K,V>> p){ tree.setAux(p,0);}
    private void makeRed(Position<Entry<K,V>> p){ tree.setAux(p,1);}
    private void setColor(Position<Entry<K,V>> p, boolean toRed){
        tree.setAux(p,toRed?1:0);
    }
    protected void rebalanceInsert(Position<Entry<K,V>> p){
        if(!isRoot(p)){
            makeRed(p);
            resolveRed(p);
        }
    }
    /* Remedies potential double-red violation above red position p. */
    protected void resolveRed(Position<Entry<K,V>> p){
        Position<Entry<K,V>> parent, uncle, middle, grand;
        parent = parent(p);
        if(isRed(parent)){ // double-red problem exists
            uncle = sibling(parent);
            if(isBlack(uncle)){
                middle = tree.restructure(p);
                makeBlack(middle);
                makeRed(left(middle));
                makeRed(right(middle));
            }else{
                makeBlack(parent);
                makeBlack(uncle);
                grand = parent(parent);
                if(!isRoot(grand)){
                    makeRed(grand);
                    resolveRed(grand);
                }
            }
        }
    }

    protected void rebalanceDelete(Position<Entry<K,V>> p){
        if(isRed(p))
            makeBlack(p);
        else if(!isRoot(p)){
            Position<Entry<K,V>> sib = sibling(p);
            if(isInternal(sib) && (isBlack(sib) || isInternal(left(sib))))
                remedyDoubleBlack(p);
        }
    }

    private void remedyDoubleBlack(Position<Entry<K,V>> p){
        Position<Entry<K,V>> z = parent(p);
        Position<Entry<K,V>> y = sibling(p);
        if(isBlack(y)){
            if(isRed(left(y)) || isRed(right(y))){
                Position<Entry<K,V>> x = (isRed(left(y))?left(y):right(y));
                Position<Entry<K,V>> middle = tree.restructure(x);
                setColor(middle, isRed(z));
                makeBlack(left(middle));
                makeBlack(right(middle));
            }else{
                makeRed(y);
                if(isRed(z))
                    makeBlack(z);
                else if(!isRoot(z))
                    remedyDoubleBlack(z);
            }
        }else{
            tree.rotate(y);
            makeBlack(y);
            makeRed(z);
            remedyDoubleBlack(p);
        }
    }
}
