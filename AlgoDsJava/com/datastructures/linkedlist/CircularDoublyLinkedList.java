package com.datastructures.linkedlist;

public class CircularDoublyLinkedList {
	
	static class Node {
		int data;
		Node next, prev;
		
		public Node(){
			next = prev = null;
			data = 0;
		}
		
		public Node (int d, Node n, Node p){
			data = d;
			next = n;
			prev = p;
		}
	}
	Node start, end;
	int size;

	//function to check whether the list is empty
	public boolean isEmpty(){
		return start == null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void print() {
		
		System.out.print("Circular Doubly Linked List = ");
		
		Node ptr = start;
		
		//if list is empty
		if(size == 0){
			System.out.println("Empty List");
			return;
		} 
		
		//single element in the list
		if (start.next == start){
			System.out.print(start.data+ " <-> "+ ptr.data+"\n");
			return;
		}
		System.out.print(start.data+" <-> ");
		ptr = start.next;
		while(ptr.next != start) {
			System.out.print(ptr.data+ " <-> ");
			ptr = ptr.next;
		}
		
		System.out.print(ptr.data+" <-> ");
		ptr = ptr.next;
		System.out.print(ptr.data+"\n");
	}
	
	public void push(int val){
		
		Node new_node = new Node(val, null, null);
		
		if (start == null) {
			new_node.next = new_node;
			new_node.prev = new_node;
			start = new_node;
			end = start;
		} else {
			new_node.prev = end;
			end.next = new_node;
			start.prev = new_node;
			new_node.next = start;
			start = new_node;
		}
		size++;
	}
	
	public void pop(){
		
		end = end.prev;
		end.next = start;
		start.prev = end;
		size--;
	}
	
	public void insertAtEnd(int val) {
		Node new_node = new Node(val, null, null);
		
		if(start == null) {
			new_node.next = new_node;
			new_node.prev = new_node;
			start = new_node;
			end = start;
		} else {
			
			new_node.prev = end;
			end.next = new_node;
			start.prev = new_node;
			new_node.next = start;
			end = new_node;
		}
		size++;
	}
	
	public void insertAtPos(int val, int pos) {
		
		Node new_node = new Node(val, null, null);
		
		if(pos == 0) {
			push(val);
			return;
		}
		
		Node temp = start;
		if(pos > size){
			System.out.println("Invalid Position");
			return;
		}
		
		for(int i = 1; i < pos; i++) {
			temp = temp.next;
		}
		
		new_node.prev = temp;
		new_node.next = temp.next;
		temp.next = new_node;
		temp.next.next = new_node.next;
		size++;
	}
	
	public void deleteAtPos(int pos) {
		
		if(pos == 0){
			end.next = start.next;
			start = start.next;
			start.prev = end;
			return;
		}
		
		if(pos == size) {
			pop();
			return;
		}
		Node temp = start;
		for(int i = 1; i < pos; i++){
			temp = temp.next;
		}
		
		Node toDel = temp.next;
		
		temp.next = toDel.next;
		toDel.next.prev= temp;
		
		size--;
	}
	
	public static void main(String[] args) {
		
		CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
		cdll.push(1);
		cdll.push(2);
		cdll.push(3);
		cdll.push(4);
		cdll.print();
		cdll.pop();
		cdll.print();
		cdll.insertAtEnd(5);
		cdll.print();
		cdll.insertAtPos(6, 4);
		cdll.print();
		cdll.deleteAtPos(0);
		cdll.print();
	}

}
