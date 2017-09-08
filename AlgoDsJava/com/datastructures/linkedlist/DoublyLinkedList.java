/**
 * 
 */
package com.datastructures.linkedlist;


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
	
	public void insertAfter(Node prev_Node,int new_data) {
	         
	   if(prev_Node == null) {
	        System.out.println("Previous node cannot be NULL ");
	        return;
	    }
	         
	    Node new_node = new Node(new_data);
	         
	    new_node.next = prev_Node.next;
	    prev_Node.next = new_node;
	    new_node.prev = prev_Node;
	         
	    if(new_node.next != null) {
	    	new_node.next.prev = new_node;
	    }
	        
	}
	
	public void insertBefore(Node next_node,int new_data) {
        
		   if(next_node == null) {
		        System.out.println("Next node cannot be NULL ");
		        return;
		    }
		         
		    Node new_node = new Node(new_data);
		    
		    
		    new_node.next = next_node;
		    new_node.prev = next_node.prev;
		    next_node.prev.next = new_node;
		    next_node.prev = new_node;
	}
	
	public void append(int new_data) {
		
		Node new_node = new Node(new_data);
		
		new_node.next = null;
		
		if (head == null) {
			new_node.prev = null;
			head = new_node;
			return;
		}
		
		Node last = head;
		
		while(last.next != null) {
			last = last.next;
		}
		
		last.next = new_node;
		
		new_node.prev = last;
		
	}
	
	public void deleteNode(int pos) {
		
		Node tempNode = head;
		
		//delete head
		if(pos == 0){
			head = head.next;
			head.prev = null;
			head.next.prev = head;
			return;
		}
		
		for(int i = 1; i<pos; i++) {
			
			tempNode = tempNode.next;
		}
		
		if(tempNode.next.next == null){
			tempNode.next = null;
			return;
		}
		tempNode.next = tempNode.next.next;
		tempNode.next.prev = tempNode;
	}
	
	public void reverseDll() {
		Node temp = null;
		Node current = head;
		
		while(current != null){
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		
		if (temp != null) {
            head = temp.prev;
        }
		
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
		//dll.insertAfter(second, 05);
		//dll.append(05);
		//dll.insertBefore(third, 05);
		//dll.deleteNode(3);
		dll.reverseDll();
		System.out.println("Created DLL is: ");
        dll.printlist(dll.head);
		
	}

}
