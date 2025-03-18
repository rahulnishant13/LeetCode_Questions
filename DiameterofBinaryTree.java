// 543. Diameter of Binary Tree
// https://leetcode.com/problems/diameter-of-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class DiameterofBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    int helper(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        max = Math.max(left+right, max);
        return Math.max(left, right) + 1;
    }
}
