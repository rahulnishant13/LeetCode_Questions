package LeetCode_60_questions_to_solve;

public class SearchInsertPosition {
    public static void main(String[] args) {

        int [] nums = new int[]{1,2,3,4,5,10};
        int target = 2;

        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length-1])
            return nums.length;
        if(target < nums[0])
            return 0;

        return getTargetIndex(nums, 0, nums.length -1, target);
    }

    private static int getTargetIndex(int[] nums, int l, int h, int target) {
        if (l > h){
            return -1;
        }
        int mid = (l+h)/2;
        if(target == nums[mid] || ((mid > l+1) && target < nums[mid] && target > nums[mid-1]))
            return mid;

        if(target > nums[mid] && target <= nums[mid+1])
            return mid+1;

        if(target > nums[mid])
            return getTargetIndex(nums, mid+1, h, target);
        return getTargetIndex(nums, l, mid-1, target);
    }
}
