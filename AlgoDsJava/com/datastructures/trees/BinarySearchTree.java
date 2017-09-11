package com.datastructures.trees;

public class BinarySearchTree {
	
	static class BSTNode {
		int data;
		BSTNode left, right;
		
		public BSTNode() {
			data = 0;
			left = right = null;
		}

		public BSTNode(int data) {
			super();
			this.data = data;
			left = right = null;
			}
	}
	
	BSTNode root = null;
	
	/* Insert Data BST */
	public void insert(int d) {
		root = insert(root, d);
	}
	
	private BSTNode insert(BSTNode node, int data){
		if(node == null){
			node = new BSTNode(data);
		} else {
			if (data <= node.data){
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return node;
	}
	
	/*Inorder Traversal*/
	public void inorder(){
		inorder(root);
	}
	private void inorder(BSTNode r){
		if (r != null) {
			inorder(r.left);
			System.out.print(r.data + " ");
			inorder(r.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(2);
		bst.insert(7);
		bst.insert(8);
		bst.insert(4);
		bst.inorder();

	}

}
