package util;

/* 
 * File name : LinearNode.java
 * Author : shannon donnelly
 * Student number : [c23302301
 * Description of class : Represents a node in the linked list for the Employee class
 */

public class LinearNode<T> {
    private T element;
    private LinearNode<T> next;

    public LinearNode(T element) {
        this.element = element;
        this.next = null;
    }

    public T getElement() { return element; }
    public void setElement(T element) { this.element = element; }

    public LinearNode<T> getNext() { return next; }
    public void setNext(LinearNode<T> next) { this.next = next; }
}