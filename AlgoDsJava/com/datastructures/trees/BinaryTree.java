package com.datastructures.trees;

public class BinaryTree {

	static class BtNode {
		int data;
		BtNode left, right;

		public BtNode() {
			data = 0;
			left = right = null;
		}

		public BtNode(int data) {
			super();
			this.data = data;
			left = right = null;
		}
	}

	BtNode root = null;

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private BtNode insert(BtNode node, int data) {
		if (node == null) {
			node = new BtNode(data);
		} else {
			if (node.right == null) {
				node.right = insert(node.right, data);
			} else {
				node.left = insert(node.left, data);
			}
		}
		return node;
	}

	public int countNodes() {
		return countNodes(root);
	}

	public int countNodes(BtNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.left);
			l += countNodes(r.right);
			return l;
		}
	}
	
	public boolean search(int value) {
		return search(root, value);
	}

	/* Function to search for an element recursively */
	private boolean search(BtNode r, int val) {
		if (r.data == val)
			return true;
		if (r.left != null)
			if (search(r.left, val))
				return true;
		if (r.right != null)
			if (search(r.right, val))
				return true;
		return false;
	}

	/* Function for preorder traversal */
	public void preorder() {
		preorder(root);
	}

	private void preorder(BtNode r) {
		if (r != null) {
			System.out.print(r.data + " ");
			preorder(r.left);
			preorder(r.right);
		}
	}
	
	/*Inorder Traversal*/
	public void inorder() {
		inorder(root);
	}

	private void inorder(BtNode r) {
		if (r != null) {
			inorder(r.left);
			System.out.print(r.data + " ");
			inorder(r.right);
		}
	}

	/*Postorder Traversal*/
	public void postorder() {
		postorder(root);
	}

	private void postorder(BtNode r) {
		if (r != null) {
			postorder(r.left);
			postorder(r.right);
			System.out.print(r.data + " ");
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(6);
		bt.insert(24);
		bt.insert(19);
		bt.insert(94);
		bt.insert(5);
		bt.insert(1);
		bt.insert(10);
		bt.insert(3);
		bt.insert(8);
		bt.preorder();
		System.out.println();
		bt.inorder();
		System.out.println();
		bt.postorder();
		System.out.println("\n"+bt.countNodes());
		System.out.println(bt.search(19));

	}

}
