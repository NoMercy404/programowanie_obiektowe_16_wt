package com.company;

import java.nio.file.Path;
import java.util.NoSuchElementException;

public class CustomList <T> {
    Node first = null, last = null;
    public class Node{
        T value;
        Node next;
    }
    public void addLast(T value){
        Node node = new Node();
        node.value = value;
        node.next = null;
        if(first == null){
            first = node;
            last = node;
        }
        else{
            last.next = node;
            last = node;
        }

    }
    public T getLast(){
        if (last == null){
            throw new NoSuchElementException();
        }
        return last.value;
    }

    public void addFirst(T value){
        Node node = new Node();
        node.value = value;
        node.next=null;
        if(first == null){
            first=node;
            last=node;
        }
        else{
            node.next =first;
            first = node;
        }
    }

    public T getFirst(){
        if(first == null){
            throw new NoSuchElementException();
        }
        else{
            return first.value;
        }
    }
    public T removeFirst(){
        if(first == null ){
            throw new NoSuchElementException();
        }
        else if(first == last){
            T temp = first.value;
            first = null;
            last = null;
            return temp;
        }
        else{
            T temp = first.value;
            first = first.next;
            return temp;
        }
    }
    public T removeLast(){
        if(first == null ){
            throw new NoSuchElementException();
        }
        else if(first == last){
            T temp = first.value;
            first = null;
            last = null;
            return temp;
        }
        else{
            T temp = last.value;
            Node currentNode = first;
            while(currentNode.next != last){
                currentNode = currentNode.next;
            }
            last = currentNode;
            currentNode.next = null;
            return temp;
        }
    }
}
