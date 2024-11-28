package util;

/* 
 * File name : LinkedList.java
 * Author :shannon donnelly
 * Student number : c23302301
 * Description of class : Linked list implementation for Employee management
 */

public class LinkedList<T> implements LinkedListADT<T> {
    private int size;

    public LinkedList() {
        size = 0;
    }

    public void add(T element) {
        // Add at end if doesn't exist
    }

    public void add(T element, int position) {
        // Add at specified position
    }

    public void delete(T element) {
        // Delete element logic
    }

    public void displayList() {
        // Display all elements
    }

    public boolean isEmpty() { return size == 0; }
    
    public boolean contains(T element) {
		return false; /* Check for existence */ }
    
    public T getFirst() {
		return null; /* Return first element */ }
    
    public T getLast() {
		return null; /* Return last element */ }
    
    public T getNext(T element) {
		return element; /* Return next element */ }
    
    public void customMethod() { /* Personalized functionality */ }
}

