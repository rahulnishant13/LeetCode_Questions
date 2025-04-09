// https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k
// 3375. Minimum Operations to Make Array Values Equal to K


class MinimumOperationstoMakeArrayValuesEqualtoK {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);

        if(nums[0] < k) return -1;
        int num = nums[0];
        int result = num == k ? 0 : 1;

        for(int i=1; i<nums.length; i++){
            if(num != nums[i]) {
                num = nums[i];
                result++;
            }
        }

        return result;
    }

    public int minOperationsUsingSet(int[] nums, int k) {
        Set<Integer> set = new HashSet();

        for(int num : nums){
            if(num < k) {
               return -1;
            }
            else if(num > k){
                set.add(num);
            }
        }

        return set.size();
    }
}
