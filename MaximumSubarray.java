package LeetCode_Questions;

// https://leetcode.com/problems/maximum-subarray/description/

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-1,-2};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}

// =======================================================

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum =0;

        for(int num : nums){
            sum += num;
            if(sum < num ){
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
