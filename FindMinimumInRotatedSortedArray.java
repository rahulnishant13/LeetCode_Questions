// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/?envType=problem-list-v2&envId=5go9wqm5

package LeetCode_Questions;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = {11,13,15,17};
        System.out.println(findMinNum(nums, 0, nums.length-1));
    }

    private static int findMinNum(int[] nums, int start, int end){
        if (start > end) return -1;
        if(nums[start] <= nums[end]) return nums[start];
        
        int mid = (start+end) / 2;

        if(nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1]){
            return nums[mid];
        }

        if(nums[mid] > nums[end]){
            return findMinNum(nums, mid+1, end);
        } else {
            return findMinNum(nums, start, mid);
        }
    }
}
