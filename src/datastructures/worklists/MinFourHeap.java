package datastructures.worklists;

import cse332.interfaces.worklists.PriorityWorkList;

import java.util.NoSuchElementException;

import cse332.exceptions.NotYetImplementedException;

/**
 * See cse332/interfaces/worklists/PriorityWorkList.java
 * for method specifications.
 */
public class MinFourHeap<E extends Comparable<E>> extends PriorityWorkList<E> {
    /* Do not change the name of this field; the tests rely on it to work correctly. */
    private E[] data;
    private int capacity;
    private int occupied;
    public MinFourHeap() {
    	this.occupied = 0;
    	this.capacity = 10;
        data = (E[]) new Comparable[this.capacity];
    }

    @Override
    public boolean hasWork() {
        return this.occupied > 0;
    }

    @Override
    public void add(E work) {
    	if (this.occupied == this.capacity) {
    		this.capacity *= 2;
			E[] temp = (E[]) new Comparable[this.capacity];
			for (int i = 0; i < this.occupied; i++) {
				temp[i] = data[i];
			}
			data = temp;
		}
    	this.occupied++;
    	int i = percolateUp(occupied - 1, work);
		data[i] = work;
		
    }
    private int percolateUp(int hole, E work) {
    	while (hole > 0 && work.compareTo(data[(hole-1)/4]) < 0) {
			data[hole] = data[(hole-1)/4];
			hole = (hole-1) / 4;
		}
    	return hole;
    }
    @Override
    public E peek() {
    	if (!hasWork()) {
			throw new NoSuchElementException();
		}
        return data[0];
    }

    @Override
    public E next() {
        if (!hasWork()) {
			throw new NoSuchElementException();
		}
        E ans = data[0];
        int hole = percolateDown(0, data[occupied-1]);
        data[hole] = data[occupied-1];
        occupied--;
        return ans;
    }
    private int percolateDown(int hole, E work) {
    	int first, second, third, fourth;
    	int target = 0;
    	E min = data[0];
    	while (4*hole + 2 <= occupied) {
			first = 4*hole + 1;
			second = 4*hole + 2;
			third = 4*hole + 3;
			fourth = 4*hole + 4;
			if (fourth <= occupied - 1) {
				target = findMinIndex(data, first, fourth);
			}
			else if(third <= occupied - 1) {
				target = findMinIndex(data, first, third);
			}
			else if(second <= occupied - 1) {
				target = findMinIndex(data, first, second);
			}
			else{
				target = first;
			}
			if (data[target].compareTo(work) < 0) {
				data[hole] = data[target];
				hole = target;
			}
			else {
				break;
			}
		}
    	return hole;
    }
    public int findMinIndex(E[] sample, int starting, int ending) {
    	int min = starting;
    	for (int i = starting + 1; i <= ending; i++) {
			if (sample[i].compareTo(sample[min]) < 0) {
				min = i;
			}
		}
    	return min;
    }

    @Override
    public int size() {
        return this.occupied;
    }

    @Override
    public void clear() {
    	this.occupied = 0;
    	this.capacity = 10;
        data = (E[])new Comparable[capacity];
    }
    public String toString() {
    	String result = "";
    	for (int i = 0; i < data.length; i++) {
			result += data[i] + " ";
		}
    	return result;
    }
}
