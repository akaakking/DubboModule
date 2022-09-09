package org.apache.dubbo.Interface;

import java.util.AbstractList;
import java.util.List;
import org.apache.dubbo.Interface.BitListInterface;
import org.apache.dubbo.rpc.cluster.router.state.BitList;
import E;
import java.lang.Object;
import java.util.Iterator;
import java.util.Collection;
import java.util.ListIterator;
import java.util.ArrayList;

public interface BitListInterface<E> extends AbstractList<E> {

    List<E> getOriginList();

    void addIndex(int index);

    int totalSetSize();

    boolean indexExist(int index);

    E getByIndex(int index);

    BitListInterface<E> and(BitListInterface<E> target);

    BitListInterface<E> or(BitListInterface<E> target);

    boolean hasMoreElementInTailList();

    List<E> getTailList();

    void addToTailList(E e);

    E randomSelectOne();

    int size();

    boolean contains(Object o);

    Iterator<E> iterator();

    boolean add(E e);

    boolean remove(Object o);

    void clear();

    E get(int index);

    E remove(int index);

    int indexOf(Object o);

    boolean addAll(Collection<? extends E> c);

    int lastIndexOf(Object o);

    boolean isEmpty();

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int index);

    BitListInterface<E> subList(int fromIndex, int toIndex);

    ArrayList<E> cloneToArrayList();

    BitListInterface<E> clone();
}
