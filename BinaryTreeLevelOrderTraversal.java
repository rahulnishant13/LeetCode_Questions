package LeetCode_Questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    private static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> data = new LinkedList<>();
            for(int i=0; i<size; i++){
                TreeNode tn = queue.poll();
                data.add(tn.val);
                if(tn.left != null){
                    queue.add(tn.left);
                }
                if(tn.right != null){
                    queue.add(tn.right);
                }
            }
            result.add(data);
        }

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}