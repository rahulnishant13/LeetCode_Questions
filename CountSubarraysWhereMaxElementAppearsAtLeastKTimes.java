// 2962. Count Subarrays Where Max Element Appears at Least K Times
// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/

class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int maxEle = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > maxEle) {
                maxEle = nums[i];
            }
        }

        int count = 0;
        long result = 0;
        int l = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == maxEle){
                count++;
            }

            while(count >= k) {
                result += nums.length - i;

                if(nums[l] == maxEle){
                    count--;
                }
                l++;
            }
        }

        return result;
    }
}
