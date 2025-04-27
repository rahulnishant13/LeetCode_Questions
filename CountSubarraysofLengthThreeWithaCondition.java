// 3392. Count Subarrays of Length Three With a Condition
// https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition

class CountSubarraysofLengthThreeWithaCondition {
    public int countSubarrays(int[] nums) {
        int count = 0;

        for(int i=0; i<nums.length-2; i++) {
            if(nums[i+1] == (nums[i] + nums[i+2])*2) {
                count++;
            }
        }

        return count;
    }
}
