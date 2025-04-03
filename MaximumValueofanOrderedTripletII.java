// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii
// 2874. Maximum Value of an Ordered Triplet II

class MaximumValueofanOrderedTripletII {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        int max = nums[0];
        long maxDiff = 0;

        for(int i=1; i<nums.length; i++) {
            res = Math.max(res, maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, max - nums[i]);
            max = Math.max(max, nums[i]);
        }

        return res;
    }
}
