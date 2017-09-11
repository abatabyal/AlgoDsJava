package com.datastructures.linkedlist;

public class CircularLinkedList {
	Node head;
	Node tail;
	static class Node {
		int data;
		Node next;
		
		Node (int d) {
			this.data = d;
		}
	}
	
	public void printList() {
		Node n = head;
		while(n != tail) {
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.print(n.data+" ");
	}
	
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		cll.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		cll.tail = new Node(4);
		
		cll.head.next = second;
		second.next = third;
		third.next = cll.tail;
		cll.tail.next = cll.head;
		cll.printList();
		
	}

}
