// 2401. Longest Nice Subarray
// https://leetcode.com/problems/longest-nice-subarray

class LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, result = 0, currBit = 0;
        for(int right=0; right<nums.length; right++){
            while((currBit & nums[right]) != 0) {
                currBit ^= nums[left];
                left++;
            }

            currBit |= nums[right];
            result = Math.max(result, right-left +1);
        }

        return result;
    }
}
