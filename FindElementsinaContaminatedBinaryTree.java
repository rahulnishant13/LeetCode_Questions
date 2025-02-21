// 1261. Find Elements in a Contaminated Binary Tree
// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

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
class FindElementsinaContaminatedBinaryTree {
    // TreeNode head;
    Set<Integer> number = new HashSet<>();

    public FindElements(TreeNode root) {
        recoverTree(root, 0);
    }

    TreeNode recoverTree(TreeNode root, int val){
        if(root == null){
            return null;
        }

        root.val = val;
        number.add(val);
        root.left = recoverTree(root.left, val*2 + 1);
        root.right = recoverTree(root.right, val*2 + 2);

        return root;
    }
    
    public boolean find(int target) {
        return number.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */


// ===================================================================================================================================


class FindElementsinaContaminatedBinaryTree {
    TreeNode head;

    public FindElements(TreeNode root) {
        head = recoverTree(root, 0);
    }

    TreeNode recoverTree(TreeNode root, int val){
        if(root == null){
            return null;
        }

        TreeNode head = new TreeNode(val);
        head.left = recoverTree(root.left, val*2 + 1);
        head.right = recoverTree(root.right, val*2 + 2);

        return head;
    }
    
    public boolean find(int target) {
        return findTarget(head, target);
    }

    boolean findTarget(TreeNode root, int target){
        if(root == null){
            return false;
        }

        if(root.val == target){
            return true;
        }

        return (findTarget(root.left, target) || findTarget(root.right, target));
    }
}
