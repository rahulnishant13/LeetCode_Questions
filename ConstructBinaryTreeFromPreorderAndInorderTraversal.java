package LeetCode_Questions;

import apple.laf.JRSUIUtils;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    static int pre =0;

    public static void main(String[] args) {
        int[] preorder = {-1};
        int[] inorder = {-1};
        System.out.println(buildTree(preorder, inorder).val);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = 0;
        TreeNode head = getTree(preorder, inorder, 0, preorder.length-1);
        return head;
    }

    private static TreeNode getTree(int[] preorder, int[] inorder, int l, int h){
        if(l > h)
            return null;

        TreeNode node = new TreeNode(preorder[pre++]);

        if (l == h)
            return node;

        int index = search(inorder, l, h, node.val);
        node.left = getTree(preorder, inorder, l, index-1);
        node.right = getTree(preorder, inorder, index+1, h);

        return node;
    }

    private static int search(int[] inorder, int l, int h, int val){
        int i;
        for(i=l; i<=h; i++){
            if(inorder[i] == val)
                return i;
        }

        return i;
    }
}
