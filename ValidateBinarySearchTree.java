// https://leetcode.com/problems/validate-binary-search-tree/description/


class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer left, Integer right){
        if(root == null) return true;

        if( (left!=null && root.val <= left) || (right!=null && root.val >= right)){
            return false;
        }
 
        return (isValid(root.left, left, root.val) && isValid(root.right, root.val, right));
    }
}
