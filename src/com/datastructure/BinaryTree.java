package com.datastructure;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: houzhaowei
 * Date: 6/22/13
 * Time: 9:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTree {

	private Node root;

	/**
	 * inner class
     * node of binary tree
     * contains left sub node / right sub node / node data
	 */
	private static class Node {
		Node left; // left sub node
		Node right; // right sub node
		int data; // node data

        /**
         * for creating one node
         * @param newData
         */
		Node(int newData) {
			left = null;
			right = null;
			data = newData;
		}
	}

    /**
     * get the root of this tree.
     * @return the root
     */
    public Node getRoot(){
        return root;
    }

	public BinaryTree() {
		root = null;
	}

    /**
     * insert a node to a binary tree . if the tree doesn't exist ,then create the tree with the root node.
     * node witch is NOT greater than the parent node is expected to insert as a left node.
     * @param data	new node to insert.
     */
	public void insert(int data) {
		root = insert(root, data);
	}
	
	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return (node);
	}
	
	/**
	 * build the binary tree with an array.
	 * @param data the array
	 */
	public void buildTree(int[] data) {
		for (int i = 0; i < data.length; i++) {
			insert(data[i]);
		}
	}

    /**
     * judge that if one tree contains an other tree
     * @param tree  the source tree
     * @param subTree  the target tree
     * @return  if the source tree contains the target tree
     */
    public static boolean contains(BinaryTree tree,BinaryTree subTree){
        // null is not permitted
        if(null == subTree || null == tree){
            return false;
        }
        Node subRoot = subTree.getRoot();
        // search the subtree's root from tree.
        Node subRootOfTree = tree.search(subRoot);
        // if failed to find , then the tree doesn't contain the subtree.
        if (null == subRootOfTree){
            return false;
        }
        return BinaryTree.isSub(subRootOfTree , subRoot);
    }

    /**
     * use recursion to judge if the tree with the root node - node2 is a subtree of the tree with the root node - node1.
     * @param node1 root of tree1
     * @param node2 root of tree2
     * @return if tree2 is a subtree of tree1
     */
    private static boolean isSub(Node node1,Node node2){
        if(null == node2){
            return true;
        }
        if(null == node1 || node1.data != node2.data){
            return false;
        }
        return isSub(node1.left, node2.left) && isSub(node1.right, node2.right);
    }


    /**
     * search pre-orderly
     * @param node
     * @return the result node if the target node is found , or null if it is not found.
     */
    public Node search(Node node){
        Stack<Node> stack = new Stack<Node>();
        Node tmp;
        if (null != root){ // start from root
            stack.push(root);
            while (!stack.isEmpty()){
                tmp = stack.pop();
                if(node.data == tmp.data){
                    return tmp;
                }
                if(null != tmp.right){ // because it is stack , so put right node first.
                    stack.push(tmp.right);
                }
                if(null != tmp.left){
                    stack.push(tmp.left);
                }
            }
        }

        return null;
    }

    /**
     * in-order traversal of this tree , simply print the result.
     */
    public void inOrderTraversal(){
        this.inOrder(root);
    }

    /**
     * pre-order traversal of this tree , simply print the result.
     */
    public void preOrderTraversal(){
        this.preOrder(root);
    }

    /**
     * pos-torder traversal of this tree , simply print the result.
     */
    public void postOrderTraversal(){
        this.postOrder(root);
    }

	private void inOrder(Node node) {
		if (node == null)
			return;

        inOrder(node.left);
		System.out.print(node.data);
        inOrder(node.right);
	}

    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }

    public static void main(String dd[]){
        BinaryTree tree = new BinaryTree();
        BinaryTree treeSub1 = new BinaryTree();
        BinaryTree treeSub2 = new BinaryTree();

        int[] data = {2,8,7,4,9,3,1,6,0,5};
        int[] subData1 = {8,7,4,9};
        int[] subData2 = {8,7,4,9,1};

        tree.buildTree(data);
        treeSub1.buildTree(subData1);
        treeSub2.buildTree(subData2);

        // test inorder traversal （the numbers in {data} is expected to be ordered , because the tree is created inorderly , see the method {insert} ）
        System.out.print("The inorder traversal of {tree} created by {data}: ");
        tree.inOrderTraversal();
        System.out.println();
        System.out.println("------------------");

        System.out.println("If biTree contains biTreeSub  : " + BinaryTree.contains(tree,treeSub1));
        System.out.println("If biTree contains biTreeSub2 : " + BinaryTree.contains(tree,treeSub2));
    }
}
