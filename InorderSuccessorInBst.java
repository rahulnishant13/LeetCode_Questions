package LeetCode_Questions;

public class InorderSuccessorInBst {
    private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right != null){
            p = p.right;
            while(p.left != null){
                p = p.left;
            }
            return p;
        }
        TreeNode result = null;
        while(root.val != p.val){
            if(root.val > p.val){
                result = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return result;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */