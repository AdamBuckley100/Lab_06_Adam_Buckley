package lab06;

/**
 * @author antonio081014
 * @time Jul 5, 2013, 9:31:32 PM
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>>
{
	public T data;
	public T data2;
	public Node<T> left;
	public Node<T> right;
	public int level;
	public int depth;
	
	public String getDataStrVer()
	{
		return (String) data;
	}
	
	public String getData2StrVer() {
		return (String) data2;
	}

	public Node(T data, T data2) {
		this(data, data2, null, null);
	}

	public Node(T data, T data2, Node<T> left, Node<T> right) {
		super();
		this.data = data;
		this.data2 = data2;
		this.left = left;
		this.right = right;
		if (left == null && right == null)
			setDepth(1);
		else if (left == null)
			setDepth(right.getDepth() + 1);
		else if (right == null)
			setDepth(left.getDepth() + 1);
		else
			setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
	}

	public T getData() {
		return data;
	}

	public T getData2() {
		return data2;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setData2(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth
	 *            the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public int compareTo(Node<T> o) {
		return this.data.compareTo(o.data);
	}

	@Override
	public String toString() {
		return "Level " + level + ": " + data;
	}
}