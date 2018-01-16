package datastructures.worklists;

import java.util.NoSuchElementException;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.FixedSizeFIFOWorkList;

/**
 * See cse332/interfaces/worklists/FixedSizeFIFOWorkList.java for method
 * specifications.
 */
public class CircularArrayFIFOQueue<E> extends FixedSizeFIFOWorkList<E> {
	int capacity;
	int size;
	int head;
	int tail;
	E[] queue;

	public CircularArrayFIFOQueue(int capacity) {
		super(capacity);
		this.capacity = capacity;
		head = 0;
		tail = 0;
		size = 0;
		queue = (E[]) new Object[capacity];
	}

	/**
	 * Adds work to the worklist. This method should conform to any additional
	 * contracts that the particular type of worklist has.
	 *
	 * @precondition isFull() is false
	 *
	 * @param work
	 *            the work to add to the worklist
	 * @throws IllegalStateException
	 *             iff isFull()
	 */
	@Override
	public void add(E work) {
		if (isFull()) {
			throw new IllegalStateException();
		}
		if (tail == capacity) {
			tail = 0;
		}
		queue[tail] = work;
		tail++;
		size++;
	}

	@Override
	public E peek() {
		if (!hasWork()) {
			throw new NoSuchElementException();
		}
		return queue[head];
	}

	/**
	 * Returns a view of the ith element of the worklist. Since this worklist is a
	 * FIFO worklist, it has a well-defined order.
	 *
	 * @precondition 0 <= i < size()
	 * @postcondition the structure of this worklist remains unchanged
	 * @throws NoSuchElementException
	 *             if hasWork() is false (this exception takes precedence over all
	 *             others)
	 * @throws IndexOutOfBoundsException
	 *             if i < 0 or i >= size()
	 *
	 * @param i
	 *            the index of the element to peek at
	 * @return the ith element in this worklist
	 */
	@Override
	public E peek(int i) {
		if (!hasWork()) {
			throw new NoSuchElementException();
		}
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		}
		int index = head + i;
		if(index>=capacity) {
			return queue[index-capacity];
		}else {
			return queue[index];
		}
	}

	@Override
	public E next() {
		if(!hasWork()) {
			throw new NoSuchElementException();
		}
		E temp = queue[head];
		if(head+1==capacity) {
			head =0;
		}else {
		head++;
		}
		size--;
		return temp;
	}
	 /**
     * Replaces the ith element of this worklist with value. Since this worklist
     * is a FIFO worklist it has a well-defined order.
     *
     * @precondition 0 <= i < size()
     * @postcondition only the ith element of the structure is changed
     * @throws NoSuchElementException
     *             if hasWork() is false (this exception takes precedence over
     *             all others)
     * @throws IndexOutOfBoundsException
     *             if i < 0 or i >= size()
     *
     * @param i
     *            the index of the element to update
     * @param value
     *            the value to update index i with
     */
	@Override
	public void update(int i, E value) {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		}
		int index = head + i;
		if(index>=capacity) {
			 queue[index-capacity]= value;
		}else {
			 queue[index]=value;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = 0;
		tail = 0;
		size = 0;
		queue = (E[]) new Object[capacity];
	}

	@Override
	public int compareTo(FixedSizeFIFOWorkList<E> other) {
		// You will implement this method in p2. Leave this method unchanged for p1.
		throw new NotYetImplementedException();
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		// You will finish implementing this method in p2. Leave this method unchanged
		// for p1.
		if (this == obj) {
			return true;
		} else if (!(obj instanceof FixedSizeFIFOWorkList<?>)) {
			return false;
		} else {
			FixedSizeFIFOWorkList<E> other = (FixedSizeFIFOWorkList<E>) obj;

			// Your code goes here

			throw new NotYetImplementedException();
		}
	}

	@Override
	public int hashCode() {
		// You will implement this method in p2. Leave this method unchanged for p1.
		throw new NotYetImplementedException();
	}
}
