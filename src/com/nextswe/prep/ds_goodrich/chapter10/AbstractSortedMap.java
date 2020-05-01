package com.nextswe.prep.ds_goodrich.chapter10;

import com.nextswe.prep.ds_goodrich.chapter9.DefaultComparator;
import com.nextswe.prep.ds_goodrich.chapter9.Entry;

import java.util.Comparator;

public abstract class AbstractSortedMap<K,V>  extends AbstractMap<K,V>  implements SortedMap<K,V>{

    private Comparator<K> comp;
    protected AbstractSortedMap(Comparator<K> c){comp = c;}
    protected AbstractSortedMap(){this(new DefaultComparator<K>());}

    /** Method for comparing two keys */
    protected int compare(K a, K b) {
        return comp.compare(a, b);
    }

    /** Method for comparing two entries according to key */
    protected int compare(Entry<K,V> a, Entry<K,V> b) {
        return compare(a.getKey(), b.getKey());
    }

    /** Method for comparing a key and an entry's key */
    protected int compare(K a, Entry<K,V> b) {
        return compare(a, b.getKey());
    }

    /** Method for comparing a key and an entry's key */
    protected int compare(Entry<K,V> a, K b) {
        return compare(a.getKey(), b);
    }

    /** Determines whether a key is valid. */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key,key)==0);   // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }
}
