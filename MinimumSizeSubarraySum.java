package LeetCode_Questions;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 11;
        int [] nums = new int[]{1,2,3,4,5};
        System.out.println(minSubArrayLen(target, nums));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int sum = 0, count = 0;
        boolean baba = true;
        int min = Integer.MAX_VALUE;
        for (int i = 0, k = 0; i < nums.length || k < nums.length;) {
            if (target > sum && i < nums.length){
                sum += nums[i];
                i++;
                count++;
            }
            else if (target == sum && baba){
                baba = false;
                min = Math.min(min, count);
            }
            else if (k < nums.length) {
                baba = true;
                sum -= nums[k];
                k++;
                count--;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
