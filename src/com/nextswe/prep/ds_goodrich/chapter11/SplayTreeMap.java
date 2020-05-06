package com.nextswe.prep.ds_goodrich.chapter11;

import com.nextswe.prep.ds_goodrich.chapter7.Position;
import com.nextswe.prep.ds_goodrich.chapter9.Entry;

import java.util.Comparator;

public class SplayTreeMap<K,V> extends TreeMap<K,V>{
    public SplayTreeMap(){ super(); }
    public SplayTreeMap(Comparator<K> comp){ super(comp); }
    private void splay(Position<Entry<K,V>> p){
        while(!isRoot(p)){
            Position<Entry<K,V>> parent = parent(p);
            Position<Entry<K,V>> grand = parent(parent);
            if(grand==null) //zig
                tree.rotate(p);
            else if((parent == left(grand) == (p == left(parent)))){ //zig-zig
                tree.rotate(parent);
                tree.rotate(p);
            }else{ //zig-zag
                tree.rotate(p);
                tree.rotate(p);
            }
        }
    }

    protected void rebalanceAccess(Position<Entry<K,V>> p){
        if(isExternal(p)) p = parent(p);
        if(p!=null) splay(p);
    }

    protected void rebalanceInsert(Position<Entry<K,V>> p){
        splay(p);
    }

    protected void rebalanceDelete(Position<Entry<K,V>> p){
        if(!isRoot(p)) splay(parent(p));
    }
}
