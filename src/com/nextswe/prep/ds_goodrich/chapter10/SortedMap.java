package com.nextswe.prep.ds_goodrich.chapter10;

import com.nextswe.prep.ds_goodrich.chapter9.Entry;

public interface SortedMap<K,V> extends Map<K,V> {
    Entry<K,V> firstEntry();
    Entry<K,V> lastEntry();
    Entry<K,V> ceilingEntry(K key);
    Entry<K,V> floorEntry(K key);
    Entry<K,V> lowerEntry(K key);
    Entry<K,V> higherEntry(K key);
    Iterable<Entry<K,V>> subMap(K k1, K k2);
}
