package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public boolean revert() {
        boolean rsl = false;
        if (size > 1) {
            Node<T> prev = null;
            Node<T> current = head;
            Node<T> next;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
            rsl = true;
        }
        return rsl;
    }

    public void addFirst(T value) {
            Node<T> node = new Node<T>(value, head);
            head = node;
            size++;
    }

    public T deleteFirst() {
        final T deleted;
            if (head == null) {
                throw new NoSuchElementException();
            }
        deleted = head.value;
        Node<T> tail = head.next;
        head.next = null;
        head = tail;
        size--;

        return deleted;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
      private T value;
      private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
