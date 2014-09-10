package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houzhaowei on 9/3/14.
 */
public class BinaryTreePostorderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        this.traverse(result, root);
        return result;
    }

    private void traverse(List<Integer> result, TreeNode node){
        if (node.left != null) {
            traverse(result, node.left);
        }
        if (node.right != null){
            traverse(result, node.right);
        }
        result.add(node.val);
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node3.right = node5;

        List<Integer> result = new BinaryTreePostorderTraversal().postorderTraversal(node1);
        for (int one :result){
            System.out.println(one);
        }
    }

}
