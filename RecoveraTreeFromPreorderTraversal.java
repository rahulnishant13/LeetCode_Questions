// 1028. Recover a Tree From Preorder Traversal
// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/

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
class RecoveraTreeFromPreorderTraversal {
    int index = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return formTree(traversal, 0);
    }

    TreeNode formTree(String traversal, int depth){
        int count = 0;
        while (index < traversal.length() && traversal.charAt(index) == '-') {
            count++;
            index++;
        }

        if(count != depth){
            index -= count;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(getNode(traversal)));
        // System.out.println("root.val : "+ root.val);
        root.left = formTree(traversal, depth+1);
        root.right = formTree(traversal, depth+1);
        return root;
    }

    String getNode(String st){
        int startIndex = index;
        while(index < st.length() && st.charAt(index) != '-'){
            index++;
        }

        return st.substring(startIndex, index);
    }
}
