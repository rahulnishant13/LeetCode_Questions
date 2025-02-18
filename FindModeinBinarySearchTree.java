// https://leetcode.com/problems/find-mode-in-binary-search-tree/description/

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
class FindModeinBinarySearchTree {
    int maxCount = 0;
    int count = 0;
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        getAllModes(root, freqMap);

        int[] result = new int[count];
        int i=0;

        for(var entry : freqMap.entrySet()){
            if(entry.getValue() == maxCount){
                result[i++] = entry.getKey();
            }
        }

        // System.out.println(" : " + count);

        return result;
    }

    void getAllModes(TreeNode root, Map<Integer, Integer> map){
        if(root == null){
            return;
        }

        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        int max = map.get(root.val);
        if(maxCount < max){
            maxCount = max;
            count  = 1;
        } else if(maxCount == max){
            count++;
        }
        getAllModes(root.left, map);
        getAllModes(root.right, map);
    }
}
