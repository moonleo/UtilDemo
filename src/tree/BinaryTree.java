package tree;

import java.util.Stack;

/**
 * binary tree
 * 
 * @param <T>
 */
public class BinaryTree<T> {

	Node<T> root;//根节点
	BinaryTree<T> lchild;//左子树
	BinaryTree<T> rchild;//右子树

	public BinaryTree() { }
	
	public BinaryTree(Node<T> root) {
		if (null == root) {
			this.root = null;
		}
		this.root = root;
		lchild = null;
		rchild = null;
	}

	public BinaryTree(BinaryTree<T> lchild, BinaryTree<T> rchild) {
		this.lchild = lchild;
		this.rchild = rchild;
	}

	/*private void displayBinaryTree(tree.BinaryTree<T> bt) {
		if(bt != null) {
			System.out.print(bt.root);
			if(bt.lchild != null || bt.rchild != null) {
				System.out.print("(");
				displayBinaryTree(bt.lchild);
				System.out.print(",");
				displayBinaryTree(bt.rchild);
				System.out.print(")");
			}
		}
	}*/
	
	public boolean findNode(BinaryTree<T> btree, T value) {
		if(null == this.root) 
			return false;
		if(this.root.value.equals(value))
			return true;
		else if(this.lchild != null)
			findNode(btree.lchild, value);
		else if(this.rchild != null)
			findNode(btree.rchild, value);
		return false;
	}

	public BinaryTree<Character> string2Tree(String string) {
		BinaryTree<Character> btree = null;
		Stack<BinaryTree<Character>> stack = new Stack<BinaryTree<Character>>();
		int i = 0;
		boolean left = true;
		BinaryTree<Character> temp = null;
		char c;
		while(i < string.length()) {
			c = string.charAt(i);
			if(c == '(') {
				stack.push(temp);
				left = true;
			} else if(c == ')') {
				stack.pop();
			} else if(c == ',') {
				left = false;
			} else {
				temp = new BinaryTree<Character>(new Node<Character>(c));
				if(null == btree)
					btree = temp;
				else {
					if(left) {
						stack.peek().lchild = temp;
					} else {
						stack.peek().rchild = temp;
					}
				}
			}
			i ++;
		}
		return btree;
	}

	private String display(BinaryTree<T> bt) {
		StringBuilder sb = null;
		if(bt != null) {
			sb = new StringBuilder();
			sb.append(bt.root);
			if(bt.lchild != null || bt.rchild != null) {
				sb.append("(");
				sb.append(display(bt.lchild));
				sb.append(",");
				sb.append(display(bt.rchild));
				sb.append(")");
			}
			return sb.toString();
		}
		return "";
	}
	
	@Override
	public String toString() {
		return display(this);
	}
	
	public static void main(String[] args) {
		BinaryTree<Character> bt = new BinaryTree<Character>();
		bt = bt.string2Tree("a(b(d,),c(f,g))");
		//bt.displayBinaryTree(bt);
		System.out.println(bt);
	}

}
