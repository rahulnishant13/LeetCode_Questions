// 713. Subarray Product Less Than K
// https://leetcode.com/problems/subarray-product-less-than-k/

class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;

        int left=0,right=0,prod=1,count=0;

        while(right < nums.length) {
            prod = prod*nums[right];

            while(prod >= k) {
                prod = prod/nums[left];
                left++;
            }

            count += right-left + 1;
            right++;
        }

        return count;
    }
}
