// https://leetcode.com/problems/binary-tree-inorder-traversal/description/

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
class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        getInorderTraversal(root, result);

        return result;
    }

    void getInorderTraversal(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        getInorderTraversal(root.left, result);
        result.add(root.val);
        getInorderTraversal(root.right, result);
    }
}
