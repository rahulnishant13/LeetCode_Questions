package LeetCode_Questions;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<List<Integer>>();

        generateSubsets(0, nums, new ArrayList<Integer>(), subset);

        return subset;
    }

    private static void generateSubsets(int index, int[] nums, ArrayList<Integer> curr, List<List<Integer>> subset){
        subset.add(new ArrayList<Integer>(curr));

        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            generateSubsets(i+1, nums, curr, subset);
            curr.remove(curr.size() -1);
        }
    }
}
