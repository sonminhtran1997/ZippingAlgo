package datastructures.worklists;

import java.util.NoSuchElementException;
import cse332.interfaces.worklists.FIFOWorkList;

/**
 * See cse332/interfaces/worklists/FIFOWorkList.java
 * for method specifications.
 */
public class ListFIFOQueue<E> extends FIFOWorkList<E> {
	public Node head, tail;
    public int size;
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
    public ListFIFOQueue() {
        this.head = null;
        this.tail = null;
        size = 0;
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
        this.size++;
    }
    /**
     * Returns a view to the next element of the worklist.
     *
     * @precondition hasWork() is true
     * @postcondition return(peek()) is return(next())
     * @postcondition the structure of this worklist remains unchanged.
     * @throws NoSuchElementException
     *             if hasWork() is false
     * @return the next element in this worklist
     */
    @Override
    public E peek() {
    	if (this.size() == 0) {
			throw new NoSuchElementException();
		}
    	return (E) head.getData();
    }
    /**
     * Returns and removes the next element of the worklist
     *
     * @precondition hasWork() is true
     * @postcondition return(next()) ++ after(next()) == before(next())
     * @postcondition after(size()) + 1 == before(size())
     * @throws NoSuchElementException
     *             if hasWork() is false
     * @return the next element in this worklist
     */
    @Override
    public E next() {
    	if (this.size() == 0) {
			throw new NoSuchElementException();
		}
    	E data = (E) head.getData();
    	if (this.size() == 1) {
			head = null;
			tail = null;
		} else {
			head = head.next;
		}
    	this.size--;
    	return data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
    	this.head = null;
        this.tail = null;
        size = 0;
    }
}
