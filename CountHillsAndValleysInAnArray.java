// 2210. Count Hills and Valleys in an Array
// https://leetcode.com/problems/count-hills-and-valleys-in-an-array/

class CountHillsAndValleysInAnArray {
    public int countHillValley(int[] nums) {
        int result = 0;
        int left = 0;

        for(int i=1; i<nums.length-1; i++){
            if(nums[i] != nums[i+1]) {
                if((nums[i] > nums[left] && nums[i] > nums[i+1]) || (nums[i] < nums[left] && nums[i] < nums[i+1])){
                    result++;
                }
                left = i;
            }
        }

        return result;
    }
}
