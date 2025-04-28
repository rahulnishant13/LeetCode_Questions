// 2302. Count Subarrays With Score Less Than K
// https://leetcode.com/problems/count-subarrays-with-score-less-than-k

class CountSubarraysWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        // Arrays.sort(nums);
        int l = 0;
        long sum = 0;
        long result = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];

            while((sum * (i-l + 1)) >= k) {
                sum -= nums[l];
                l++;
            }
            result += i-l + 1;
        }

        return result;
    }
}
