package LeetCode_Questions;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = new int[]{1};
        int target = 0;
        int res = search(nums, target);
        System.out.println("result: " + res);
    }

    public static int search(int[] nums, int target) {
        int result = findPivot(nums, 0, nums.length-1);
        if (result > -1) {
            if (target >= nums[0] && target <= nums[result - 1])
                return getIndex(nums, 0, result - 1, target);
            else if (target >= nums[result] && target <= nums[nums.length - 1])
                return getIndex(nums, result, nums.length-1, target);
        } else {
            return getIndex(nums, 0, nums.length-1, target);
        }

        return -1;
    }

    private static int findPivot(int[] nums, int l, int h) {
        if (l > h)
            return -1;
        int mid = (l+h)/2;
        if (mid < h && nums[mid] > nums[mid+1])
            return mid+1;
        if (mid > 0 && nums[mid] < nums[mid-1])
            return mid;

        if (nums[mid] < nums[h])
            return findPivot(nums, l, mid-1);
        return findPivot(nums, mid+1, h);
    }

    private static int getIndex(int[] nums, int l, int h, int target) {
        if (l > h)
            return -1;
        int mid = (l+h)/2;
        if (nums[mid] == target)
            return mid;

        if (target < nums[mid])
            return getIndex(nums, l, mid-1, target);
        return getIndex(nums, mid+1, h, target);
    }
}
