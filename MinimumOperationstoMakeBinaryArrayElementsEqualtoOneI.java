// 3191. Minimum Operations to Make Binary Array Elements Equal to One I
// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i

class MinimumOperationstoMakeBinaryArrayElementsEqualtoOneI {
    public int minOperations(int[] nums) {
        int l=0, result=0;

        for(int i=0; i<nums.length; i++) {
            while(l<nums.length && nums[l] == 1) {
                l++;
            }

            if(i-l >= 2) {
                flipNumbers(nums, l, i);
                result++;
            }
        }

        while(l<nums.length && nums[l] == 1) {
            l++;
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(l +" : "+result);

        if(l == nums.length) {
            return result;
        } else {
            return -1;
        }
    }

    void flipNumbers(int[] nums, int l, int i){
        while(l <= i) {
            nums[l] = nums[l] == 0 ? 1 : 0;
            l++;
        }
    }
}
