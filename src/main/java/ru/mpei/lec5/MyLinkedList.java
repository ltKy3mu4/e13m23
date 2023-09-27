package ru.mpei.lec5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList <T> implements List<T> {
    private ValueWrap<T> last = null;
    private ValueWrap<T> first = null;
    @Override
    public boolean add(T t) {
        ValueWrap<T> val = new ValueWrap<>(t, null, null);
        if (this.first == null){
            this.first = val;
        }
        val.prev = this.last;

        if (this.last != null){
            this.last.next = val;
        }
        this.last = val;
        return true;
    }

    @Override
    public T set(int index, T element) {

        throw new IndexOutOfBoundsException();

    }


    @Override
    public boolean remove(Object o) {

        return true;
    }

    @Override
    public T get(int index) {
        if (first == null){
            throw new IndexOutOfBoundsException();
        }

        ValueWrap<T> checked = this.first;
        int count = 0;
        while (checked != null){
            if (count == index) {
                return checked.value;
            }
            count++;
            checked = checked.next;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        if (first == null){
            return 0;
        }
        int size = 1;
        ValueWrap<T> firstRef = first.next;
        while (firstRef != null){
            size = size + 1;
            firstRef = firstRef.next;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }





    @Override
    public void clear() {

    }




    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }


    class ValueWrap<T> {

        public ValueWrap(T value, ValueWrap<T> next, ValueWrap<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        T value;

        ValueWrap<T> next;
        ValueWrap<T> prev;

        @Override
        public String toString() {
            return "ValueWrap{" +
                    "value=" + value +
                    '}';
        }
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }


}
