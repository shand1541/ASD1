package util;

/* 
 * File name : LinkedListADT.java
 * Author : shannon donnelly
 * Student number : c23302301
 * Description of class : Interface for the LinkedList class
 */

public interface LinkedListADT<T> {
	
    void add(T element);
    
    void add(T element, int position);
    
    void delete(T element);
    
    void displayList();
    
    boolean isEmpty();
    
    boolean contains(T element);
    
    T getFirst();
    
    T getLast();
    
    T getNext(T element);
    
    // Additional custom method
    void customMethod(); 
}
