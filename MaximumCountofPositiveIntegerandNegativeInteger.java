// 2529. Maximum Count of Positive Integer and Negative Integer
// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/

class MaximumCountofPositiveIntegerandNegativeInteger {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        if(nums[0] > 0) return n;
        if(nums[n-1] < 0) return n;

        int min = getPivot(nums, 0, n-1);
        int high = min+1;
        while(high<n && nums[high] == 0){
            high++;
        }

        return Math.max(min+1, n-high);
    }

    int getPivot(int[] nums, int l, int h) {
        if(l>h) {
            return -1;
        }
        int mid = (l+h)/2;

        if(nums[mid] < 0 && nums[mid+1] >=0) {
            return mid;
        }

        if(nums[mid] >= 0){
            return getPivot(nums, l, mid-1);
        } else {
            return getPivot(nums, mid+1, h);
        }
    }
}
