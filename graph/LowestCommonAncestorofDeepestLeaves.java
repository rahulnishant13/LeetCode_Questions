// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/
// 1123. Lowest Common Ancestor of Deepest Leaves

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

class Pair{
    TreeNode data;
    int depth;
    public Pair(TreeNode node, int dep){
        data = node;
        depth = dep;
    }
}

class LowestCommonAncestorofDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair pair = helper(root, 0);

        // System.out.println(pair.data);
        return pair.data;
    }

    Pair helper(TreeNode root, int depth) {
        if(root == null){
            return new Pair(null, depth);
        }

        Pair left = helper(root.left, depth+1);
        Pair right = helper(root.right, depth+1);

        if(left.depth > right.depth) {
            return new Pair(left.data, left.depth+1);
        } else if(left.depth < right.depth) {
            return new Pair(right.data, right.depth+1);
        } else {
            return new Pair(root, left.depth+1);
        }
    }
}
