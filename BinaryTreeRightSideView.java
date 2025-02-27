// 199. Binary Tree Right Side View
// https://leetcode.com/problems/binary-tree-right-side-view/
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
class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        getRightSideView(root, result, 0);

        return result;
    }

    void getRightSideView(TreeNode root, List<Integer> result, int depth) {
        if(root == null){
            return;
        }

        if(result.size() == depth){
            result.add(root.val);
        }

        getRightSideView(root.right, result, depth+1);
        getRightSideView(root.left, result, depth+1);

    }
}
