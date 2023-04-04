package com.company;

import java.nio.file.Path;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class CustomList<T> extends AbstractList<T> {
    Node first = null, last = null;

    public class Node {
        T value;
        Node next;
    }

    public void addLast(T value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

    }

    public T getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.value;
    }

    public void addFirst(T value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            return first.value;
        }
    }

    public T removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        } else if (first == last) {
            T temp = first.value;
            first = null;
            last = null;
            return temp;
        } else {
            T temp = first.value;
            first = first.next;
            return temp;
        }
    }

    public T removeLast() {
        if (first == null) {
            throw new NoSuchElementException();
        } else if (first == last) {
            T temp = first.value;
            first = null;
            last = null;
            return temp;
        } else {
            T temp = last.value;
            Node currentNode = first;
            while (currentNode.next != last) {
                currentNode = currentNode.next;
            }
            last = currentNode;
            currentNode.next = null;
            return temp;
        }
    }

    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public T get(int index) {
        if (index < size()) {
            Node currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.value;
        } else {
            throw new NoSuchElementException();
        }

    }

    @Override
    public int size() {
        int countNode = 1;
        if (first == null) {
            return 0;
        } else {
            Node currentNode = first;
            while (currentNode.next != last) {
                currentNode = currentNode.next;
                countNode++;
            }
            return countNode;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T result = currentNode.value;
                currentNode = currentNode.next;
                return result;
            }
        };
    }

    @Override
    public Stream<T> stream() {
        Stream.Builder<T> streamBuilder = Stream.builder();

        for(T entry : this) {
            streamBuilder.accept(entry);
        }

        return streamBuilder.build();
    }
}
