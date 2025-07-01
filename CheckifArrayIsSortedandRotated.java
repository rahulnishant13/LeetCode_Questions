// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
// 1752. Check if Array Is Sorted and Rotated

class CheckifArrayIsSortedandRotated {
    public boolean check(int[] nums) {
        int dip = 0;
        if(nums[0] < nums[nums.length-1]) dip++;

        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] > nums[i+1]){
                dip++;
            }
        }

        return dip > 1 ? false : true;
    }
}
