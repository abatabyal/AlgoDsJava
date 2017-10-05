package com.datastructures.trees;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {
	
	//number of children per node
	private static final int d = 2;
	private int heapSize;
	private int[] heap;
	
	public BinaryHeap(int capacity){
		heapSize = 0;
		heap = new int[capacity+1];
		Arrays.fill(heap,  -1);
		
	}
	
	public boolean isEmpty() {
		return heapSize == 0;
	}
	
	public boolean isFull() {
		return heapSize == heap.length;
	}
	
	public void makeEmpty() {
		heapSize = 0;
	}
	
	//get index of parent
	private int parent (int i) {
		return (i-1)/d;
	}
	
	//get index of kth child
	private int kChild(int i, int k) {
		return d * i + k;
		
	}
	
	//get smallest child
	private int minChild(int ind) {
		int bestChild = kChild(ind, 1);
		int k = 2;
		int pos = kChild(ind, k);
		while ((k <= 2) && (pos < heapSize)) {
			if (heap[pos] < heap[bestChild]) {
				bestChild = pos;
			}
			pos = kChild(ind, k++);
		}
		return bestChild;
	}
	
	private void heapifyUp (int childInd) {
		//new element to be percolated up
		int tmp = heap[childInd];
		
		//new item index less than zero
		//new item less than parent
		while (childInd > 0 && tmp < heap[parent(childInd)]) {
			heap[childInd] = heap[parent(childInd)];
			childInd = parent(childInd);
		}
		heap[childInd] = tmp;
	}
	
	private void heapifyDown(int ind) {
		
	}
	
	
	public void insert(int x) {
		if(isFull()) {
			throw new NoSuchElementException("Overflow");
		}
		
		//adding new element to the end of list
		heap[heapSize++] = x;
		//Percolate up passing the last element zero based index
		heapifyUp(heapSize-1);
	}
	
	public void delMin() {
		heap[0] = heap[heapSize];
		heapSize--;
		heapifyDown(0);
	}
	
	public void display() {
		System.out.print("Binary Heap = ");
		for (int i = 0; i < heapSize; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BinaryHeap bh = new BinaryHeap(11);
		bh.insert(5);
		bh.display();
		bh.insert(9);
		bh.display();
		bh.insert(11);
		bh.display();
		bh.insert(14);
		bh.display();
		bh.insert(18);
		bh.display();
		bh.insert(19);
		bh.display();
		bh.insert(21);
		bh.display();
		bh.insert(33);
		bh.display();
		bh.insert(17);
		bh.display();
		bh.insert(27);
		bh.display();
		bh.insert(7);
		bh.display();
		
		

	}

}
