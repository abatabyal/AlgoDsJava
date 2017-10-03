package com.datastructures.queues;

import java.util.NoSuchElementException;

public class ArrayQueue {
	
	int[] queue;
	int front, rear, size, len;
	
	public ArrayQueue(int n) {
		size = n;
		len = 0;
		queue = new int[size];
		front = -1;
		rear = -1;
	}
	
	//check queue is empty or not
	public boolean isEmpty() {
		return front == -1;
	}
	
	//check queue is full
	public boolean isFull() {
		return front == 0 && rear == size-1;
	}
	
	public int getSize() {
		return len;
	}
	
	//check the front element of queue
	public int peek() {
		if(isEmpty()) {
			throw new NoSuchElementException("Underflow");
		} else {
			return queue[front];
		}
	}
	
	//function to insert
	public void insert(int n) {
		if(rear == -1) {
			front = 0;
			rear = 0;
			queue[rear] = n;
		} else if (rear + 1 >= size) {
			throw new IndexOutOfBoundsException("Overflow");
		} else if (rear + 1 < size) {
			queue[++rear] = n;
		}
		len++;
	}
	
	//remove element
	public int remove() {
		
		if (isEmpty()) {
			throw new NoSuchElementException("Underflow");
		} else {
			len--;
			int ele = queue[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			} else {
				front++;
			}
			return ele;
		
		}
	}
	
	public void display() {
		System.out.print("Queue = ");
		if(len == 0) {
			System.out.print("Empty Queue");
			return;
		}
				
		for(int i = front; i <= rear; i++) {
			System.out.print(queue[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		ArrayQueue aq = new ArrayQueue(5);
		//aq.isEmpty();
		//aq.display();
		//aq.isFull();
		aq.insert(1);
		aq.insert(2);
		aq.insert(3);
		aq.insert(4);
		aq.insert(5);
		aq.display();
		aq.remove();
		aq.display();
	}

}
