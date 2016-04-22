package lab06;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {
	Node<T> root;
	private int noOfTrav;
	private int numberOfNodes;
		
	public Node<T> getRoot()
	{
		return root;
	}
	
	public void delete2(Node<String> node)
	{
		node.setData("");
		node.setData2("");
	}
	
	public int getTrav()
	{
		return noOfTrav;
	}

	public AVLTree() {
		root = null;
	}

	public T Maximum() {
		Node<T> local = root;
		if (local == null)
			return null;
		while (local.getRight() != null)
			local = local.getRight();
		return local.getData();
	}

	public T Minimum() {
		Node<T> local = root;
		if (local == null)
			return null;
		while (local.getLeft() != null) {
			local = local.getLeft();
		}
		return local.getData();
	}

	private int depth(Node<T> node) {
		if (node == null)
			return 0;
		return node.getDepth();
		// 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
	}

	public Node<T> insert(T data, T data2) {
		root = insert(root, data, data2);
		switch (balanceNumber(root)) {
		case 1:
			root = rotateLeft(root);
			break;
		case -1:
			root = rotateRight(root);
			break;
		default:
			break;
		}
		return root;
	}

	public Node<T> insert(Node<T> node, T data, T data2) {
		if (node == null)
			return new Node<T>(data, data2);
		if (node.getData().compareTo(data) > 0) {
			node = new Node<T>(node.getData(), data2,
					insert(node.getLeft(), data, data2),
					node.getRight());
			// node.setLeft(insert(node.getLeft(), data));
		} else if (node.getData().compareTo(data) < 0) {
			// node.setRight(insert(node.getRight(), data));
			node = new Node<T>(node.getData(), data2, node.getLeft(), insert(
					node.getRight(), data, data2));
		}
		// After insert the new node, check and rebalance the current node if
		// necessary.
		switch (balanceNumber(node)) {
		case 1:
			node = rotateLeft(node);
			break;
		case -1:
			node = rotateRight(node);
			break;
		default:
			return node;
		}
		return node;
	}

	private int balanceNumber(Node<T> node) {
		int L = depth(node.getLeft());
		int R = depth(node.getRight());
		if (L - R >= 2)
			return -1;
		else if (L - R <= -2)
			return 1;
		return 0;
	}

	private Node<T> rotateLeft(Node<T> node) {
		Node<T> q = node;
		Node<T> p = q.getRight();
		Node<T> c = q.getLeft();
		Node<T> a = p.getLeft();
		Node<T> b = p.getRight();
		q = new Node<T>(q.getData(), q.getData2(), c, p);
		p = new Node<T>(p.getData(), p.getData2(), a, b);
		return p;
	}

	private Node<T> rotateRight(Node<T> node) {
		Node<T> q = node;
		Node<T> p = q.getLeft();
		Node<T> c = q.getRight();
		Node<T> a = p.getLeft();
		Node<T> b = p.getRight();
		q = new Node<T>(q.getData(), q.getData2(), b, c);
		p = new Node<T>(p.getData(), p.getData2(), a, q);
		return p;
	}

	public boolean search(T data) {
		//noOfTrav = 1;
		
		Node<T> local = root;
		
		while (local != null)
		{
			if (local.getData().compareTo(data) == 0)
			{
				return true;
			}
			else if (local.getData().compareTo(data) > 0)
			{
				//noOfTrav++;
				local = local.getLeft();
			}
			else
			{
				//noOfTrav++;
				local = local.getRight();
			}
			//noOfTrav++;
		}
		return false;
	}
	
	//returns the actual node, NOT a boolean
	public Node<T> search2(T data) {
		noOfTrav = 1;
		Node<T> local = root;
		while (local != null)
		{
			if (local.getData().compareTo(data) == 0)
			{
				return local;
			}
			else if (local.getData().compareTo(data) > 0)
			{
				local = local.getLeft();
			}
			else
			{
				local = local.getRight();
			}
			noOfTrav++;
		}
		return null;
	}

	public String toString() {
		return root.toString();
	}

	public void PrintTree() {
		root.level = 0;
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();
			System.out.println(node);
			int level = node.level;
			Node<T> left = node.getLeft();
			Node<T> right = node.getRight();
			if (left != null) {
				left.level = level + 1;
				queue.add(left);
			}
			if (right != null) {
				right.level = level + 1;
				queue.add(right);
			}
		}
	}
	// Alphabetical needed
	public void inOrderTraversal(Node<T> n)
	{
	    if (n != null)
	    {
	        inOrderTraversal(n.getLeft()); //recursive call to the left subtree
	        System.out.println(n.getData()); //line which makes the actual node to display its data
	        inOrderTraversal(n.getRight()); //recursive call to the right subtree
	    }
	}
}