/**
 * 
 */
package com.datastructures.linkedlist;

import com.datastructures.linkedlist.SinglyLinkedList.Node;

/**
 * @author stark
 *
 */
public class DoublyLinkedList {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		Node prev;
		
		Node (int d) {
			data = d;
		}
	}
	
	 public void printlist(Node node)
	    {
	        Node last = null;
	        System.out.println("Traversal in forward Direction");
	        while(node != null)
	        {
	            System.out.print(node.data + " ");
	            last = node;
	            node = node.next;
	        }
	        System.out.println();
	        System.out.println("Traversal in reverse direction");
	        while (last != null)
	        {
	            System.out.print(last.data + " ");
	            last = last.prev;
	        }
	    }
	
	//Adding in Front - Push Operation
	public void push (int new_data) {
		
		Node new_node = new Node(new_data);
		
		new_node.next = head;
		new_node.prev = null;
		
		if (head != null) {
			head.prev = new_node;
		}
		head = new_node;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		
		dll.head = new Node(01);
		Node second = new Node(02);
		Node third = new Node(03);
		Node fourth = new Node(04);
		
		dll.head.next = second;
		second.prev = dll.head;
		second .next = third;
		third.prev = second;
		third.next = fourth;
		fourth.prev = third;
		
		
		//dll.push(00);
		System.out.println("Created DLL is: ");
        dll.printlist(dll.head);
		
	}

}
