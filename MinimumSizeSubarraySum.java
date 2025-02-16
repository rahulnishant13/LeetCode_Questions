package LeetCode_Questions;

// https://leetcode.com/problems/minimum-size-subarray-sum/description/

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int count = Integer.MAX_VALUE, sum = 0, j=0;

        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            while(target <= sum){
                count = Math.min(count, i-j+1);
                sum = sum - nums[j];
                j++;
            }
        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
