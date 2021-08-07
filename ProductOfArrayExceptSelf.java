package LeetCode_Questions;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] productArray = new int[n];
        int [] prefix = new int[n];
        prefix[0] = 1;
        int prod = 1;
        int [] postfix = new int[n];


        for (int i = 1; i < n; i++) {
            prod *= nums[i-1];
            prefix[i] = prod;
        }

        prod = 1;
        postfix[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            prod *= nums[i+1];
            postfix[i] = prod;
        }

        for (int i = 0; i < n; i++) {
            productArray[i] = postfix[i] * prefix[i];
        }

        return productArray;
    }
}
