package LeetCode_Questions;
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

/*
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int d){
        val = d;
    }
}
*/

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int [] nums = {0,1,2,3,4,5}; //{-10,-3,0,5,9};
        TreeNode head = sortedArrayToBST(nums);

        printBST(head);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }

    private static TreeNode createBST(int [] nums, int l, int h){
        if(l > h){
            return null;
        }
        int mid = (l+h)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = createBST(nums, l, mid-1);
        node.right = createBST(nums, mid+1, h);

        return node;
    }

    private static void printBST(TreeNode node) {
        if(node == null){
            return;
        }
        System.out.print(node.val + " ");
        printBST(node.left);
        printBST(node.right);
    }

}
