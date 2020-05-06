package com.nextswe.prep.ds_goodrich.chapter11;

import com.nextswe.prep.ds_goodrich.chapter10.AbstractSortedMap;
import com.nextswe.prep.ds_goodrich.chapter7.Position;
import com.nextswe.prep.ds_goodrich.chapter8.LinkedBinaryTree;
import com.nextswe.prep.ds_goodrich.chapter9.Entry;

import java.util.ArrayList;
import java.util.Comparator;

public class TreeMap<K,V> extends AbstractSortedMap<K,V> {
    protected BalanceableBinaryTree<K,V> tree = new BalanceableBinaryTree<>();
    public TreeMap(){
        super();
        tree.addRoot(null);
    }
    public TreeMap(Comparator<K> c){
        super(c);
        tree.addRoot(null);
    }
    public int size(){
        return (tree.size()-1)/2;
    }
    private void expandExternal(Position<Entry<K,V>> p, Entry<K,V> entry){
        tree.set(p, entry);
        tree.addLeft(p, null);
        tree.addRight(p, null);
    }
    protected Position<Entry<K,V>> root(){
        return tree.root();
    }

    protected boolean isExternal(Position<Entry<K,V>> p){
        return tree.isExternal(p);
    }

    protected boolean isInternal(Position<Entry<K,V>> p) {
        return tree.isInternal(p);
    }

    protected boolean isRoot(Position<Entry<K,V>> p){
        return tree.isRoot(p);
    }

    protected Position<Entry<K,V>> left(Position<Entry<K,V>> p){
        return tree.left(p);
    }

    protected Position<Entry<K,V>> right(Position<Entry<K,V>> p){
        return tree.right(p);
    }

    protected Position<Entry<K,V>> sibling(Position<Entry<K,V>> p){
        return tree.sibling(p);
    }

    protected Position<Entry<K,V>> parent(Position<Entry<K,V>> p){
        return tree.parent(p);
    }

    protected Entry<K,V> remove(Position<Entry<K,V>> p){
        return tree.remove(p);
    }

    protected Entry<K,V> set(Position<Entry<K,V>> p, Entry<K,V> e){
        return tree.set(p, e);
    }

    /**
     * Hook to customized later
     * @param p
     */
    protected void rebalanceAccess(Position<Entry<K,V>> p){
        //
    }

    /**
     * Hook to customized later
     * @param p
     */
    protected void rebalanceInsert(Position<Entry<K,V>> p){
        //
    }

    /**
     * Hook to customized later
     * @param p
     */
    protected void rebalanceDelete(Position<Entry<K,V>> p){

    }

    private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key){
        if(isExternal(p))
            return p;
        int comp = compare(key, p.getElement());
        if(comp == 0) return p;
        else if(comp < 0)
            return treeSearch(left(p),key);
        else
            return treeSearch(right(p),key);
    }

    public V get(K key) throws IllegalArgumentException{
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        rebalanceAccess(p);
        if(isExternal(p)) return null;
        return p.getElement().getValue();
    }

    public V put(K key, V value) throws IllegalArgumentException{
        checkKey(key);
        Entry<K,V> newEntry = new MapEntry<>(key, value);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if(isExternal(p)){
            expandExternal(p, newEntry);
            rebalanceInsert(p);
            return null;
        }else{
            V old = p.getElement().getValue();
            set(p, newEntry);
            rebalanceAccess(p);
            return old;
        }
    }

    public V remove(K key) throws IllegalArgumentException{
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if(isExternal(p)){
            rebalanceAccess(p);
            return null;
        }else{
            V old = p.getElement().getValue();
            if(isInternal(left(p)) && isInternal(right(p))){
                Position<Entry<K,V>> replacement = treeMax(left(p));
                set(p,replacement.getElement());
                p = replacement;
            }
            Position<Entry<K,V>> leaf = isExternal(left(p))?left(p):right(p);
            Position<Entry<K,V>> sib = sibling(leaf);
            remove(leaf);
            remove(p);
            rebalanceDelete(sib);
            return old;
        }
    }

    protected Position<Entry<K,V>> treeMax(Position<Entry<K,V>> p){
        Position<Entry<K,V>> walk = p;
        while(isInternal(walk))
            walk = right(walk);
        return parent(walk);
    }

    public Entry<K,V> lastEntry(){
        if(isEmpty()) return null;
        return treeMax(root()).getElement();
    }

    public Entry<K,V> floorEntry(K key) throws IllegalArgumentException{
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if(isInternal(p)) return p.getElement();
        while(!isRoot(p))
            if(p ==  right(parent(p)))
                return parent(p).getElement();
            else
                p = parent(p);
        return null;
    }

    public Entry<K,V> lowerEntry(K key) throws IllegalArgumentException{
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if(isInternal(p) && isInternal(left(p)))
            return treeMax(left(p)).getElement();
        while(!isRoot(p)){
            if(p==right(parent(p)))
                return parent(p).getElement();
            else
                p = parent(p);
        }
        return null;
    }

    public Iterable<Entry<K,V>> entrySet(){
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
        for(Position<Entry<K,V>> p: tree.inorder())
            if(isInternal(p))buffer.add(p.getElement());
        return buffer;
    }

    public Iterable<Entry<K,V>> subMap(K fromKey, K toKey){
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
        if(compare(fromKey,toKey)<0){
            subMapRecurse(fromKey, toKey, root(), buffer);
        }
        return buffer;
    }

    private void subMapRecurse(K fromKey, K toKey, Position<Entry<K,V>> p,
                               ArrayList<Entry<K,V>> buffer){
        if(isInternal(p))
            if(compare(p.getElement(),fromKey)<0)
                subMapRecurse(fromKey, toKey, right(p), buffer);
            else{
                subMapRecurse(fromKey, toKey, left(p), buffer);
                if(compare(p.getElement(), toKey)<0){
                    buffer.add(p.getElement());
                    subMapRecurse(fromKey, toKey, right(p), buffer);
                }
            }
    }

    /** @todo implementation **/
    @Override
    public Entry<K, V> firstEntry() {
        return null;
    }

    /** @todo implementation **/
    @Override
    public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
        return null;
    }

    /** @todo implementation **/
    @Override
    public Entry<K, V> higherEntry(K key) throws IllegalArgumentException {
        return null;
    }

    protected static class BalanceableBinaryTree<K,V> extends LinkedBinaryTree<Entry<K,V>> {

        protected static class BSTNode<E> extends Node<E>{
            int aux = 0;
            BSTNode(E e, Node<E> parent, Node<E> left, Node<E> right){
                super(e,parent,left,right);
            }
            public int getAux(){ return aux; }
            public void setAux(int value) { aux = value; }
        }

        public int getAux(Position<Entry<K,V>> p){
            return ((BSTNode<Entry<K,V>>)p).getAux();
        }

        public void setAux(Position<Entry<K,V>> p, int value){
            ((BSTNode<Entry<K,V>>)p).setAux(value);
        }

        protected BSTNode<Entry<K,V>> createNode(Entry<K,V> e, Node<Entry<K,V>> parent,
                                                 Node<Entry<K,V>> left, Node<Entry<K,V>> right){
            return new BSTNode<>(e, parent, left,right);
        }

        private void relink(Node<Entry<K,V>> parent, Node<Entry<K,V>> child,
                            boolean makeLeftChild){
            child.setParent(parent);
            if(makeLeftChild){
                parent.setLeft(child);
            }else{
                parent.setRight(child);
            }
        }

        /* Rotates Position p above its parent. */
        public void rotate(Position<Entry<K,V>> p){
            Node<Entry<K,V>> x = validate(p);
            Node<Entry<K,V>> y = x.getParent();
            Node<Entry<K,V>> z = y.getParent();
            if(z==null){
                root = x;
                x.setParent(null);
            }else{
                relink(z,x, y == z.getLeft());
            }
            if(x==y.getLeft()){
                relink(y,x.getRight(),true); // x’s right child becomes y’s left
                relink(x,y,false); // y becomes x’s right child
            }else{
                relink(y, x.getLeft(),false); // x’s left child becomes y’s right
                relink(x, y, true); // y becomes left child of x
            }
        }

        /* Performs a trinode restructuring of Position x with its parent/grandparent. */
        public Position<Entry<K,V>> restructure(Position<Entry<K,V>> x){
            Position<Entry<K,V>> y = parent(x);
            Position<Entry<K,V>> z = parent(y);
            if((x==right(y))==(y==right(z))){ // matching alignments
                rotate(y); // single rotation (of y)
                return y; // y is new subtree root
            }else{ // opposite alignments
                rotate(x); // double rotation (of x)
                rotate(x);
                return x; // x is new subtree root
            }
        }
    }
}
