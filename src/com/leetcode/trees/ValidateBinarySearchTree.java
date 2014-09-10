package com.leetcode.trees;

/**
 * Created by houzhaowei on 9/3/14.
 */
public class ValidateBinarySearchTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root){
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validate(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        // not in range
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // left subtree must be < root.val && right subtree must be > root.val
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(13);
        node2.left = node4;
        node3.right = node5;

        System.out.println(new ValidateBinarySearchTree().isValidBST(node1));

    }

}
