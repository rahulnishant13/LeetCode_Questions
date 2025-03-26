// 2033. Minimum Operations to Make a Uni-Value Grid
// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid

class MinimumOperationstoMakeaUniValueGrid {
    public int minOperations(int[][] grid, int x) {
        int[] nums = new int[grid.length*grid[0].length];
        int j = 0, total = 0;

        for(int[] data : grid){
            for(int val : data) {
                if(val%x != grid[0][0]%x){
                    return -1;
                }
                nums[j] = val;
                total += val;
                j++;
            }
        }

        Arrays.sort(nums);
        int prefix = 0;
        int result = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            int prev_op = Math.abs(nums[i]*i - prefix) / x;
            int next_op = Math.abs(total - nums[i]*(nums.length - i) - prefix) / x;
            result = Math.min(result, prev_op+next_op);

            prefix += nums[i];
        }

        return result;
    }
}
