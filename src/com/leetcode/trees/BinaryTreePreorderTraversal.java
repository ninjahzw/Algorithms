package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houzhaowei on 9/3/14.
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        this.traverse(result, root);
        return result;
    }

    private void traverse(List<Integer> result, TreeNode node){
        result.add(node.val);
        if (node.left != null) {
            traverse(result, node.left);
        }
        if (node.right != null){
            traverse(result, node.right);
        }
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

        List<Integer> result = new BinaryTreePreorderTraversal().preorderTraversal(node1);
        for (int one :result){
            System.out.println(one);
        }
    }

}
