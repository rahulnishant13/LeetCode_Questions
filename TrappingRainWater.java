package LeetCode_Questions;

import java.util.Arrays;

// 42. Trapping Rain Water
// https://leetcode.com/problems/trapping-rain-water/

class TrappingRainWater {
    public int trap(int[] height) {
        int lh = 0, rh = 0;
        int l = 0, r = height.length-1;
        int result = 0;

        while(l<r) {
            lh = Math.max(lh, height[l]);
            rh = Math.max(rh, height[r]);

            if(lh < rh) {
                result += lh - height[l];
                l++;
            } else {
                result += rh - height[r];
                r--;
            }
        }

        return result;

    }
}

public class TrappingRainWater {
    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("trap water: "+ trap(height));
    }

    private static int trap(int[] height) {
        int result =0;
        int [] lr_min_height = new int[height.length];
        int min_h = 0;
        for (int i = 0; i < height.length; i++) {
            lr_min_height[i] = min_h = Math.max(min_h, height[i]);
        }

        System.out.println(Arrays.toString(lr_min_height));

        min_h = 0;

        for (int i = height.length-1; i >=0; i--) {
            min_h = Math.max(height[i], min_h);
            lr_min_height[i] = min_h = Math.min(min_h, lr_min_height[i]);
        }

        System.out.println(Arrays.toString(lr_min_height));

        for (int i = 0; i < height.length; i++) {
            result += lr_min_height[i] - height[i];
        }
        return result;
    }
}
