package com.nextswe.prep.ds_goodrich.chapter8;

import com.nextswe.prep.ds_goodrich.chapter7.Position;

public interface BinaryTree<E> extends Tree<E> {
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
