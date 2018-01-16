package datastructures.worklists;

import java.util.NoSuchElementException;
import cse332.interfaces.worklists.LIFOWorkList;

/**
 * See cse332/interfaces/worklists/LIFOWorkList.java
 * for method specifications.
 */
public class ArrayStack<E> extends LIFOWorkList<E> {
	public E[] stack;
	public int occupied;
	public int capacity;
	
    public ArrayStack() {
    	this.occupied = 0;
    	this.capacity = 10;
        this.stack = (E[])new Object[this.capacity];
        
    }
    /**
     * Adds work to the worklist. This method should conform to any additional
     * contracts that the particular type of worklist has.
     *
     * @param work
     *            the work to add to the worklist
     */
    @Override
    public void add(E work) {
    	if (this.occupied == this.capacity - 1) {
    		this.capacity *= 2;
			E[] temp = (E[]) new Object[this.capacity];
			for (int i = 0; i < this.occupied; i++) {
				temp[i] = stack[i];
			}
			stack = temp;
		}
        stack[occupied] = work;
        this.occupied++;
    }

    @Override
    public E peek() {
    	if (this.occupied == 0) {
			throw new NoSuchElementException();
		}
    	return stack[occupied-1];
    }

    @Override
    public E next() {
    	if (this.occupied == 0) {
			throw new NoSuchElementException();
		}
        E temp = this.stack[occupied-1];
        this.stack[this.occupied-1] = null;
        this.occupied--;
        return temp;
    }

    @Override
    public int size() {
        return this.occupied;
    }

    @Override
    public void clear() {
    	this.occupied = 0;
    	this.capacity = 10;
        this.stack = (E[])new Object[this.capacity];
    }
}
