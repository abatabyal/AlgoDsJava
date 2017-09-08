package com.datastructures.linkedlist;

public class SinglyLinkedList {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node (int d) {
			data = d;
			next = null;
		}
	}
	
	public void printList() {
		Node n = head;
		while(n != null) {
			System.out.print(n.data+" ");
			n = n.next;
		}
	}
	
	public void insertFront(int new_data) {
		
		Node new_node = new Node(new_data);
		//next of new_node is head
		new_node.next = head;
		//head points to new_node
		head = new_node;
	}
	
	public void insertAfterPos(int new_data, Node node_pos) {
		
		Node new_node = new Node(new_data);
		
		new_node.next = node_pos.next;
		node_pos.next = new_node;
		
	}
	
	public void append(int new_data) {
		Node new_node= new Node(new_data);
		
		if(head == null) {
			head = new Node(new_data);
			return;
		}
		
		new_node.next = null;
		
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		
		last.next = new_node;
		return;
	}
	
	public void delete(int pos) {
		
		if (head == null) {
			return;
		}
		
		Node tempNode = head;
		if (pos == 0){
			head = head.next;
			return;
		}
		
		for (int i = 1; tempNode != null && i < pos; i++) {
			tempNode = tempNode.next;
		}
		
		if (tempNode.next == null){
			System.out.println("\nNode does not exist");
			return;
		}
		
		Node nextNode = tempNode.next.next;
		
		tempNode.next = nextNode;
		System.out.println("\nAfter Deleting Node");
	}

	public static void main(String[] args) {
		SinglyLinkedList slist = new SinglyLinkedList();
		
		slist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node (3);
		Node fourth = new Node(4);
		
		slist.head.next = second;
		second.next = third;
		third.next = fourth;
		
		//slist.insertAfterPos(7, slist.head.next);
		//slist.append(9);
		slist.printList();
		slist.delete(4);
				
	}

}
