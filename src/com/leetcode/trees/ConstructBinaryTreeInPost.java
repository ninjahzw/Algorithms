package com.leetcode.trees;

/**
 * Created by Hou Zhaowei on 9/16/2014.
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * Idea:
 * This problem can be illustrated by using a simple example.
 * in-order:   4 2 5  (1)  6 7 3 8
 * post-order: 4 5 2  6 7 8 3  (1)
 * From the post-order array, we know that last element is the root.
 * We can find the root in in-order array.
 * Then we can identify the left and right sub-trees of the root from in-order array.
 * Using the length of left sub-tree, we can identify left and right sub-trees in post-order array.
 * Recursively, we can build up the tree.
 */
public class ConstructBinaryTreeInPost {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeRec(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode buildTreeRec(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd){

        if(inStart > inEnd || postStart > postEnd) {
            return null;
        }
        // root of current subtree.
        TreeNode root = new TreeNode(postorder[postEnd]);
        // find the index of the root in in-order array
        int pivot = -1;
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == root.val){
                pivot = i;
                break;
            }
        }
        if (pivot == -1){
            return null;
        }

        // split the two arrays by the index of of root in in-order array
        // and for each part recursively go down.
        // --left subtree recursive
        // ---- can not directly use pivot
        // ---- Because pivot is not the length, it it need to -(inStart+1) to get the length
        root.left = buildTreeRec(inorder, inStart, pivot - 1, postorder, postStart, postStart + pivot - (inStart + 1));
        // right subtree recursive
        root.right = buildTreeRec(inorder, pivot + 1, inEnd, postorder, postStart+pivot-inStart, postEnd -1);

        return root;
    }

    public static void main(String[] args){
        TreeNode result = new ConstructBinaryTreeInPost().buildTree(new int[]{4,2,6,5,7,1,3}, new int[]{1,6,7,5,2,3,1});
        System.out.print(result.left + " " + result.val + " " + result.right.val + " " + result.right.left + " " + result.right.right );
    }
}
