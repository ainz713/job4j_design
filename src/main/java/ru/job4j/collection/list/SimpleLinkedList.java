package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private int index = 0;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;

    @Override
    public void add(E value) {
        final Node<E> l = last;
        Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        index++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, this.index);
        Node<E> rsl = first;
        for (int i = 0; i < index; i++) {
            rsl = rsl.next;
        }
        return rsl.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int point = 0;
            private int expectedModCount = modCount;
            private Node<E> lastNode = first;

            @Override
            public boolean hasNext() {
                return point < index;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (point == 0) {
                    point++;
                    return lastNode.item;
                }
                point++;
                lastNode = lastNode.next;
                return lastNode.item;
            }
        };
    }

    public class Node<E> {
        private  E item;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
