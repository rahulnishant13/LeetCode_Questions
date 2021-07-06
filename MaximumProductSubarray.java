package LeetCode_60_questions_to_solve;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        //2,3,-2,4,-1, 0,
        int [] nums = new int[] {0};

        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] nums) {
        int l_max = 1, l_min = 1, f_max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                l_max = l_min =1;
            }
            int a = nums[i] * l_max;
            int b = nums[i] * l_min;
            l_max = Math.max(nums[i], Math.max(a, b));
            l_min = Math.min(nums[i], Math.min(a, b));

            f_max = Math.max(Math.max(l_max, l_min), f_max);
        }
        return f_max;
    }
}
