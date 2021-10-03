package LeetCode_Questions;

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

public class MinimumDepthOfBinaryTree {
    private static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return getMin(root, 0);
    }

    private static int getMin(TreeNode root, int currDepth) {
        if(root.left == null && root.right == null)
            return currDepth;

        if(root.left == null)
            return getMin(root.right, currDepth+1);
        else if(root.right == null)
            return getMin(root.left, currDepth+1);
        else
            return Math.min(getMin(root.left, currDepth+1), getMin(root.right, currDepth+1));
    }
}
