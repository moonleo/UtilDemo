package tree;

public class Tree<T> {
	private Node<T> parent;
	private Node<T> root;
	private Tree<T> childTree;

	public Tree(Node<T> root) {
		this.root = root;
		this.parent = null;
		childTree = null;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public Tree<T> getChildTree() {
		return childTree;
	}

	public void setChildTree(Tree<T> childTree) {
		this.childTree = childTree;
	}
	
	public void toArray() {
		
	}
}
