package LeetCode_Questions;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int [] nums = new int []{2,7,11,15};

        int [] sol = new TwoSum().twoSum(nums, 18);

        System.out.println(sol[0]+" " +sol[1]);
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (hm.containsKey(diff)){
                return new int[]{hm.get(diff), i};
            } else {
                hm.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
