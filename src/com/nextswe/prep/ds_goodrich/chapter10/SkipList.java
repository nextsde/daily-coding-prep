package com.nextswe.prep.ds_goodrich.chapter10;

import java.util.*;

// https://gist.github.com/hrishikesh-mishra/4180890be4f7fb7302f41aecb36b5c7a

/**
 *
 * A SkipList S for a map M consists of a series of list {S0, S1, ......, Sh}. Each list Si
 * stores a subset of the entries of M sorted by increasing keys, plus entries with two sentinels
 * keys denoted -infinities to +infinities, where-infinities is smaller than every possible keys that
 * can be inserted in M and +infinities is larger than every possible keys that can be inserted in M.
 *
 *
 * SkipLists ( aka JumpList) are an alternative representation of balanced trees (not binary) that
 * provides approximate O(log n) access times with the advantage that the implementation is
 * straightforward and the storage requirement is less than a standard balanced tree structure.
 *
 * Advantages:
 *  - implementation is straightforward and easier than a typical balanced tree algorithm
 *  - storage requirements are less than for typical balanced trees
 *  - insertions and deletions do not require rebalancing
 *  - supports insert,remove,find and join operations (especially useful for symbol table applications)
 *
 * Disadvantages
 *  - search time for insert and find is longer than for trees.
 *  - depends on a random number generator which can mean difficult debug.
 *
 *
 * Insertion:
 * The entries in Si+1 are chosen at random from the entries in Si, by picking each entry from Si, to also
 * be in Si+1 with probability 1/2. That is, in essene, we "flip a coin" fro each entry in Si and place that entry
 * in Si+1 if the coin comes up "heads". Thus, we expect S1 to have about n/2 entries, S2 to have about n/4 entries
 * and in general, Si to have about n/2i entries. As a consequence, we expect the height h of S to about log n.
 *
 * @author hrishikesh.mishra
 * @link http://hrishikeshmishra.com/skiplist/
 */
public class SkipList<K extends Comparable<K>,V> {
    private int size;
    private int height;
    private SkipListNode<K,V> head;
    private K minusInfinity;
    private K plusInfinity;
    private List<K> blockedValues;

    public SkipList(K minus, K plus){
        minusInfinity = minus;
        plusInfinity = plus;

        SkipListNode<K,V> leftSentinel = new SkipListNode<>(minusInfinity,null);
        SkipListNode<K,V> rightSentinel = new SkipListNode<>(plusInfinity,null);
        leftSentinel.setNext(rightSentinel);
        rightSentinel.setPrev(leftSentinel);

        height = 0;
        head = leftSentinel;
        blockedValues = new ArrayList<>(2);
        blockedValues.add(minusInfinity);
        blockedValues.add(plusInfinity);
    }

    public V search(K key){
        SkipListNode<K,V> node = getPosition(key);
        return node.getKey().compareTo(key)==0?node.getValue():null;
    }

    public SkipListNode<K,V> insert(K key, V value){
        if(blockedValues.contains(key))
            throw new IllegalArgumentException("Infinity values not allowed");
        SkipListNode<K,V> pos = getPosition(key);

        if(pos.getKey().compareTo(key)==0)
            throw new IllegalArgumentException("Duplicate item");

        SkipListNode<K,V> belowNode = null;
        SkipListNode<K,V> prev = pos;

        int level = -1;

        do{
            level++;
            if(level>=height){
                height++;
                SkipListNode<K,V> rightSentinel = head.getNext();
                head  = insertAfterAbove(null, head, minusInfinity, null);
                insertAfterAbove(head,rightSentinel, plusInfinity, null);
            }

            belowNode = insertAfterAbove(prev, belowNode, key, value);

            while(Objects.isNull(prev.getTop()))
                prev = prev.getPrev();

            prev = prev.getTop();
        }while(Coin.flip()==Coin.HEAD);

        size++;

        return belowNode;
    }

    public V remove(K key){
        if(blockedValues.contains(key))
            throw new IllegalArgumentException("Infinity values not allowed");

        SkipListNode<K,V> pos = getPosition(key);
        if(pos.getKey().compareTo(key)==0)
            return null;

        SkipListNode<K,V> navNode = pos;
        while(!Objects.isNull(navNode)){
            navNode.getPrev().setNext(navNode.getNext());
            navNode.getNext().setPrev(navNode.getPrev());
            navNode.setPrev(null);
            navNode.setNext(null);

            SkipListNode<K,V> aboveNode = navNode.getTop();
            navNode.setBottom(null);
            navNode.setTop(null);
            navNode = aboveNode;
        }
        return pos.getValue();
    }

    private SkipListNode<K,V> getPosition(K key){
        SkipListNode<K,V> navNode = head;
        while(!Objects.isNull(navNode.getBottom())){
            navNode = navNode.getBottom();
            while(key.compareTo(navNode.getNext().getKey())>=0)
                navNode = navNode.getNext();
        }
        return navNode;
    }

    private SkipListNode<K,V> insertAfterAbove(SkipListNode<K,V> prev, SkipListNode<K,V> below,
                                               K k, V v){
        SkipListNode<K,V> newNode = new SkipListNode<>(k,v);
        if(!Objects.isNull(prev)){
            newNode.setPrev(prev);
            if(!Objects.isNull(prev.getNext())){
                newNode.setNext(prev.getNext());
                prev.getNext().setPrev(newNode);
            }
            prev.setNext(newNode);
        }

        if(!Objects.isNull(below)){
            newNode.setBottom(below);
            below.setTop(newNode);
        }
        return newNode;
    }

    private enum Coin{
        HEAD, TAIL;

        public static Coin flip(){
            Random rnd = new Random();
            return rnd.nextBoolean()?HEAD:TAIL;
        }
    }

    private class SkipListNode<K,V>{
        private K key;
        private V value;
        private SkipListNode<K,V> top;
        private SkipListNode<K,V> bottom;
        private SkipListNode<K,V> prev;
        private SkipListNode<K,V> next;

        private SkipListNode(K k, V v, SkipListNode<K,V> tp, SkipListNode<K,V> bt,
                             SkipListNode<K,V> pv, SkipListNode<K,V> nx){
            key = k;
            value = v;
            top = tp;
            bottom = bt;
            prev = pv;
            next = nx;
        }

        private SkipListNode(K k, V v){
            key = k;
            value = v;
        }

        public V getValue(){
            return value;
        }

        public void setValue(V v){
            value = v;
        }

        public K getKey(){
            return key;
        }

        public void setKey(K k){
            key = k;
        }

        public SkipListNode<K,V> getTop(){
            return top;
        }

        public void setTop(SkipListNode<K,V> tp){
            top = tp;
        }

        public SkipListNode<K,V> getBottom(){
            return bottom;
        }

        public void setBottom(SkipListNode<K,V> bt){
            bottom = bt;
        }

        public SkipListNode<K,V> getNext(){
            return next;
        }

        public void setNext(SkipListNode<K,V> nx){
            next = nx;
        }

        public SkipListNode<K,V> getPrev(){
            return prev;
        }

        public void setPrev(SkipListNode<K,V> pv){
            prev = pv;
        }

        public String toString(){
            return "("+key+", "+value+")";
        }
    }


    //=======================//
    /**
     * <p>
     *     Traverse all nodes for all SkipLists from
     *     top to bottom.
     * </p>
     */
    public void printRaw() {
        SkipListNode<K, V> navigatorNode = head;
        while (!Objects.isNull(navigatorNode)){
            SkipListNode<K, V> verticalMoveNode  = navigatorNode, horizontalMoveNode = navigatorNode;
            while (!Objects.isNull(horizontalMoveNode)){
                System.out.print("  " + horizontalMoveNode.getKey());
                horizontalMoveNode = horizontalMoveNode.getNext();
            }
            navigatorNode = verticalMoveNode.getBottom();
            System.out.println();
        }
    }

    /**
     * <p>
     *     Print all SkipNode in proper format.
     * </p>
     */
    public void print() {
        int maxChars = minusInfinity.toString().length() + 3;
        K[][] matrix = getKeysMatrix();
        String placeholder = getPlaceholder(maxChars);
        String formatter = getFormatString(maxChars);

        for(int i=0; i<= height; i++){
            String [] keys = new String[size+2];

            for(int j=0; j< size+2; j++){

                if(Objects.isNull(matrix[i][j]))
                    keys[j] = placeholder;
                else if(matrix[i][j].compareTo(minusInfinity) == 0 )
                    keys[j] = "-∞";
                else if(matrix[i][j].compareTo(plusInfinity) == 0)
                    keys[j] = "+∞";
                else
                    keys[j] = matrix[i][j].toString();
            }
            System.out.println(String.format(formatter, keys));
        }
    }

    /**
     * <p>
     *     Create matrix of SkipLists Node's key
     * </p>
     * @return
     */
    private K[][] getKeysMatrix() {
        K [][] matrix =  (K[][]) new Comparable[ height + 1 ][ size + 2];
        SkipListNode<K, V> navigatorNode = head;
        int i = height, j = 0;

        while (!Objects.isNull(navigatorNode.getBottom()))
            navigatorNode = navigatorNode.getBottom();

        /** Filling bottom listing, it has all values **/
        SkipListNode<K, V> rightMove  = navigatorNode;
        while (!Objects.isNull(rightMove)){
            matrix[i][j++] = rightMove.getKey();
            rightMove = rightMove.getNext();
        }

        /** moving list above from bottom **/
        navigatorNode = navigatorNode.getTop();
        while (!Objects.isNull(navigatorNode)){
            rightMove  = navigatorNode;
            while (!Objects.isNull(rightMove)){
                matrix[i][getIndex(matrix[height], rightMove.getKey())] = rightMove.getKey();
                rightMove = rightMove.getNext();
            }
            navigatorNode = navigatorNode.getTop();
            i--;
        }

        return matrix;
    }

    private int getIndex(K[] matrix, K key){
        for(int i=0; i< matrix.length; i++){
            if(key.compareTo(matrix[i]) == 0)
                return i;
        }
        throw new NoSuchElementException("key : " + key);
    }

    private String getPlaceholder(int length){
        String str = "";
        for(int i=0; i<length; i++)
            str += " ";

        return str;
    }

    private String getFormatString(int maxChars){
        String str = "";
        for(int i=0; i<size+2; i++){
            str +=  "%-" + maxChars + "s";
        }
        return str;
    }
}

class SkipListTest {

    public static void main(String[] args) {
        SkipList<Integer, String> skipList = new SkipList<Integer, String>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        skipList.insert(12, "A");
        skipList.insert(11, "C");
        skipList.insert(35, "D");
        skipList.insert(13, "G");
        skipList.insert(14, "H");
        skipList.insert(111, "K");
        skipList.insert(123, "P");
        skipList.insert(-123, "Y");
        skipList.insert(23, "U");

        System.out.println("Raw Print ");
        skipList.printRaw();

        System.out.println("\n\n\n\nClear Print");
        skipList.print();

        System.out.println();

        System.out.println("Search 123: " + skipList.search(123));

        System.out.println("Remove 123 : " + skipList.remove(123));

        System.out.println("Raw Print ");
        skipList.printRaw();

        System.out.println("\n\n\n\nClear Print");
        skipList.print();

        System.out.println("Remove -123 : " + skipList.remove(-123));

        System.out.println("Raw Print ");
        skipList.printRaw();

        System.out.println("\n\n\n\nClear Print");
        skipList.print();


        System.out.println("Remove 12: " + skipList.remove(12));

        System.out.println("Raw Print ");
        skipList.printRaw();

        System.out.println("\n\n\n\nClear Print");
        skipList.print();



        System.out.println("Remove 14: " + skipList.remove(14));

        System.out.println("Raw Print ");
        skipList.printRaw();

        System.out.println("\n\n\n\nClear Print");
        skipList.print();


        System.out.println("Remove 140: " + skipList.remove(140));

        System.out.println("Raw Print ");
        skipList.printRaw();

        System.out.println("\n\n\n\nClear Print");
        skipList.print();
    }


}
