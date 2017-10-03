package com.datastructures.queues;

public class LinkedListQueue {
	
	static class Node {
		int data;
		Node next, prev;
		
		public Node(int d){
			data = d;
		}
	}
	
	Node front, rear;
	int size;
	
	public LinkedListQueue() {
		front = null;
		rear = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insert(int n) {
		
		Node new_node = new Node(n);
		
		if(rear == null) {
			front = new_node;
			rear = new_node;
		} else {
			rear.next = new_node;
			new_node.prev = rear; 
			rear = new_node.prev;
		}
		size++;
	}
	
	public void display() {
		
		System.out.print("Linked List Queue : ");
		if(size == 0) {
			System.out.print("Empty Queue");
			return;
		}
		
		Node ptr = front;
		while(ptr != rear.next) {
			System.out.print(ptr.data+" ");
			ptr = ptr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedListQueue llq = new LinkedListQueue();
		llq.insert(1);
		llq.insert(2);
		llq.insert(3);
		llq.insert(4);
		llq.insert(5);
		llq.display();
		
	}

}
