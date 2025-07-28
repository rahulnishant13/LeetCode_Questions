// 2044. Count Number of Maximum Bitwise-OR Subsets
// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/


class CountNumberofMaximumBitwiseORSubsets {
    public int countMaxOrSubsets(int[] nums) {
        int maxXor = 0;
        for(int num : nums){
            maxXor = maxXor | num;
        }

        List<List<Integer>> result = new ArrayList<>();
        subset(result, nums, new ArrayList<>(), maxXor, 0);

        return result.size();
    }

    private static void subset(List<List<Integer>> result, int[] nums, List<Integer> data, int mXor, int index) {
        if(data.size() != 0){
            int xor = 0;
            for(int num : data) {
                xor = xor|num;
            }

            if(xor == mXor) {
                result.add(data);
            }
        }

        for(int i=index; i<nums.length; i++){
            data.add(nums[i]);
            subset(result, nums, data, mXor, i+1);
            data.remove(data.size() - 1);
        }
    }
}
