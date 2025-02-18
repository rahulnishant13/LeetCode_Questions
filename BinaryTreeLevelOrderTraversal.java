// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

package LeetCode_Questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode tn = queue.poll();
                if(tn != null){
                    list.add(tn.val);
                    queue.add(tn.left);
                    queue.add(tn.right);
                }
                size--;
            }
            if(!list.isEmpty()) result.add(list);
        }
        return result;
    }
}

// ======================================== SOL 2==================================================================

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

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int depth =0;

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> data = new LinkedList<>();
            for(int i=0; i<size; i++){
                TreeNode tn = queue.poll();
                if(depth%2 == 0) {
                    data.add(tn.val);
                } else {
                    data.add(0, tn.val);
                }
                if(tn.left != null){
                    queue.add(tn.left);
                }
                if(tn.right != null){
                    queue.add(tn.right);
                }
            }
            result.add(data);
            depth++;
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
