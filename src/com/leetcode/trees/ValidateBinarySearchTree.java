package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

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
        if (root == null){
            return false;
        }
        boolean result = true;
        this.traverse(result, root);
        return result;
    }

    private int traverse(boolean result, TreeNode node){
        if (node.left != null) {
            int left = traverse(result, node.left);
            if (left > node.val){
                result = false;
            }
        }
        if (node.right != null){
            int right = traverse(result, node.right);
            if (right < node.val){
                result = false;
            }
        }
        return node.val;
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

        System.out.println(new ValidateBinarySearchTree().isValidBST(node1));

    }

}
