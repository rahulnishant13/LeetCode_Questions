// 889. Construct Binary Tree from Preorder and Postorder Traversal
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

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
class ConstructBinaryTreefromPreorderandPostorderTraversal {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructTree(preorder, postorder, 0, postorder.length-1);
    }

    int index = 0;
    TreeNode constructTree(int [] preorder, int[] postorder, int low, int high){
        if(low > high){
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);
        if(low == high) {
            return root;
        }

        int pivot = low;
        while(postorder[pivot] != preorder[index]){
            pivot++;
        }

        root.left = constructTree(preorder, postorder, low, pivot);
        root.right = constructTree(preorder, postorder, pivot+1, high-1);

        return root;
    }
}
