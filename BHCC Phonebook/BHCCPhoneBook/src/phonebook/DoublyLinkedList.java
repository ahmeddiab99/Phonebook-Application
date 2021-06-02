/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.util.Collection;

/**
 *
 * @author Ahmed Diab, Fengnan Zhang.
 */
public class DoublyLinkedList <E> implements Iterable<E> {   
    private int size = 0;
    private Node <E> head = null;
    private Node <E> tail = null;
    
    private class Node <E> {
        E contact;
        Node <E> previousContact, nextContact;        
                
        public Node(){} // default constructor.
        
        //CONSTRUCTOR
        public Node( E contact, Node <E> previousContact, Node <E> nextContact){        
            this.contact = contact;
            this.previousContact= previousContact;
            this.nextContact = nextContact;  
        }
    }    
    public void add(E elem){
        addLast(elem);
    }
    
    public void addLast(E node)
    {
        if( isEmpty()){ //if the list is empty
        head = tail = new Node <E> (node, null, null); //create a new one and assign them to null
        } else {
            tail.nextContact = new Node<E>(node, tail, null); //add a new contact to the tail
            tail = tail.nextContact; //assign it to the next contact
        }
        size++; //increment the size
    }
    
    
    public void clear(){
        Node <E> trav = head;
        while(trav != null){
            Node <E> next = trav.nextContact;
            trav.previousContact = trav.nextContact = null;
            trav.contact = null;
            trav = trav.nextContact;
        }
        head = tail = trav = null;
        size = 0;
    }
    
    // return size of the list.
    public int size()
    {
        return size;
    } 
    public boolean isEmpty()
    {
        return size() == 0;
    }
   
    
    public E get(int index){

        Node curNode = head;
        for (int i = 0; curNode != null; ++i, curNode = curNode.nextContact) {
            if (index == i) {
                return (E) curNode.contact;
            }
        }
        return null;
    }
      
    public void addAll(Collection<? extends E> c) {
        for (E ele : c) {
            add(ele);
        }
    }
    
    //Check the value of the first contact list
    public E peekFirst()
    {
        if(isEmpty()) throw new RuntimeException("Empty list");
        return head.contact;
    }
    
    //check the value of the last node if it exists
    public E peekLast()
    {
        if(isEmpty()) throw new RuntimeException("Empty List");
        return tail.contact;
    }

  // Add an element to the beginning of this linked list, O(1)
  public void addFirst(E elem) {
    if (isEmpty()) {
      head = tail = new Node<E>(elem, null, null);
    } else {
      head.previousContact = new Node<E>(elem, null, head);
      head = head.previousContact;
    }
    size++;
  }

  // Add an element at a specified index
  public void addAt(int index, E data) throws Exception {
    if (index < 0) {
      throw new Exception("Illegal Index");
    }
    if (index == 0) {
      addFirst(data);
      return;
    }

    if (index == size) {
      addLast(data);
      return;
    }

    Node<E> temp = head;
    for (int i = 0; i < index - 1; i++) {
      temp = temp.nextContact;
    }
    Node<E> newNode = new Node<>(data, temp, temp.nextContact);
    temp.nextContact.previousContact = newNode;
    temp.nextContact = newNode;

    size++;
  }

  // Remove the first value at the head of the linked list, O(1)
  public E removeFirst() {
    // Can't remove data from an empty list
    if (isEmpty()) throw new RuntimeException("Empty list");

    // Extract the data at the head and move
    // the head pointer forwards one node
    E data = head.contact;
    head = head.nextContact;
    --size;

    // If the list is empty set the tail to null
    if (isEmpty()) tail = null;

    // Do a memory cleanup of the previous node
    else head.previousContact = null;

    // Return the data that was at the first node we just removed
    return data;
  }

  // Remove the last value at the tail of the linked list, O(1)
  public E removeLast() {
    // Can't remove data from an empty list
    if (isEmpty()) throw new RuntimeException("Empty list");

    // Extract the data at the tail and move
    // the tail pointer backwards one node
    E data = tail.contact;
    tail = tail.previousContact;
    --size;

    // If the list is now empty set the head to null
    if (isEmpty()) head = null;

    // Do a memory clean of the node that was just removed
    else tail.nextContact = null;

    // Return the data that was in the last node we just removed
    return data;
  }

  // Remove an arbitrary node from the linked list, O(1)
  private E remove(Node<E> node) {
    // If the node to remove is somewhere either at the
    // head or the tail handle those independently
    if (node.previousContact == null) return removeFirst();
    if (node.nextContact == null) return removeLast();

    // Make the pointers of adjacent nodes skip over 'node'
    node.nextContact.previousContact = node.previousContact;
    node.previousContact.nextContact = node.nextContact;

    // Temporarily store the data we want to return
    E data = node.contact;

    // Memory cleanup
    node.contact = null;
    node = node.previousContact = node.nextContact = null;

    --size;

    // Return the data in the node we just removed
    return data;
  }

  // Remove a node at a particular index, O(n)
  public E removeAt(int index) {
    // Make sure the index provided is valid
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException();
    }

    int i;
    Node<E> trav;

    // Search from the front of the list
    if (index < size / 2) {
      for (i = 0, trav = head; i != index; i++) {
        trav = trav.nextContact;
      }
      // Search from the back of the list
    } else
      for (i = size - 1, trav = tail; i != index; i--) {
        trav = trav.previousContact;
      }

    return remove(trav);
  }

  // Remove a particular value in the linked list, O(n)
  public boolean remove(Object obj) {
    Node<E> trav = head;

    // Support searching for null
    if (obj == null) {
      for (trav = head; trav != null; trav = trav.nextContact) {
        if (trav.contact == null) {
          remove(trav);
          return true;
        }
      }
      // Search for non null object
    } else {
      for (trav = head; trav != null; trav = trav.nextContact) {
        if (obj.equals(trav.contact)) {
          remove(trav);
          return true;
        }
      }
    }
    return false;
  }

  // Find the index of a particular value in the linked list, O(n)
  public int indexOf(Object obj) {
    int index = 0;
    Node<E> trav = head;

    // Support searching for null
    if (obj == null) {
      for (; trav != null; trav = trav.nextContact, index++) {
        if (trav.contact == null) {
          return index;
        }
      }
      // Search for non null object
    } else
      for (; trav != null; trav = trav.nextContact, index++) {
        if (obj.equals(trav.contact)) {
          return index;
        }
      }

    return -1;
  }

  

  // Check is a value is contained within the linked list
  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }

  public java.util.Iterator<E> iterator() {
    return new java.util.Iterator<E>() {
      private Node<E> trav = head;

      @Override
      public boolean hasNext() {
        return trav != null;
      }
      
      

      @Override
      public E next() {
        E data = trav.contact;
        trav = trav.nextContact;
        return data;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<E> trav = head;
        while (trav != null) {
            sb.append(trav.contact);
            if (trav.nextContact != null) {
                sb.append(", ");
            }
            trav = trav.nextContact;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
