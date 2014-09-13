package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hou Zhaowei on 9/13/14.
 *
 * Problem:
 * Given a binary tree, flatten it to a linked list in-place.
 * For example Given
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 *
 * Idea:
 * Keep track of the current tail of the result LinkedList.
 * for each Node, go though left all the way down to the leaf, and add right node to the tail.
 * This approach result in to a left tree representation of linked list
 * So it will need a transform to the right way that the problem needed.
 * TODO: better solution ?
 *
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return;
        }
        TreeNode flagNode = new TreeNode(0);
        this.traverse(root, flagNode, 0);

        // Transform to the way that Leetcode wanted..
        flagNode = root;
        while (flagNode != null){
            flagNode.right = flagNode.left;
            flagNode.left = null;
            flagNode = flagNode.right;
        }
    }

    /**
     * This is for left flat (although works but not meet the requirement)
     * result is:
     *       1
     *      /
     *     2
     *    /
     *   3
     *  /
     * 4
     * @param node
     * @param flagNode to keep track of current tail of the generated LinkedList.
     * @param position 0 for left, 1 for right
     */
    private void traverse(TreeNode node, TreeNode flagNode, int position){

        if (position == 1){
            flagNode.left.left = node;
            flagNode.left = node;
        }

        if (position == 0){
            flagNode.left = node;
        }

        if (node.left != null) {
            traverse(node.left, flagNode, 0);
        }
        if (node.right != null){
            traverse(node.right, flagNode, 1);
            node.right = null;
        }
    }


    private void traverse_1(TreeNode node, TreeNode flagNode){
//        if (node != null) {
//            traverse_1(node.left, flagNode);
//            traverse_1(node.right, flagNode);
//
//            flagNode.right = node.right;
//            node.right = node.left;
//            node.
//        }

    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        //node1.right = node3;

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        //node2.left = node4;
        //node3.right = node5;

        new FlattenBinaryTreeToLinkedList().flatten(node1);

        List<Integer> result = new BinaryTreePreorderTraversal().preorderTraversal(node1);
        for (int one :result){
            System.out.println(one);
        }
        System.out.println(node1.right.right.right.val);


    }

}
