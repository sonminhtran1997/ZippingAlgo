package datastructures.worklists;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.FIFOWorkList;

/**
 * See cse332/interfaces/worklists/FIFOWorkList.java
 * for method specifications.
 */
public class ListFIFOQueue<E> extends FIFOWorkList<E> {
    private class Node<E>{
    	public E data;
    	public Node next;
    	public Node(E data) {
    		this.data = data;
    		this.next = null;
    	}
    	public E getData() {
    		return this.data;
    	}
    	public void setNext(Node next) {
    		this.next = next;
    	}
    }
    public Node head, tail;
    public ListFIFOQueue() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void add(E work) {
    	Node newNode = new Node(work);
        if (head == null) {
			this.head = newNode;
			this.tail = newNode;
		}
        else {
        	tail.setNext(newNode);
        	tail = newNode;
        }
    }

    @Override
    public E peek() {
    	
    }

    @Override
    public E next() {
        throw new NotYetImplementedException();
    }

    @Override
    public int size() {
        throw new NotYetImplementedException();
    }

    @Override
    public void clear() {
        throw new NotYetImplementedException();
    }
}
