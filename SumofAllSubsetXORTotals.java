// 1863. Sum of All Subset XOR Totals
// https://leetcode.com/problems/sum-of-all-subset-xor-totals/

class SumofAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        int[] result = new int[1];
        getAllSubset(nums, new ArrayList<>(), result, 0);
        return result[0];
    }

    void getAllSubset(int[] nums, List<Integer> data, int[] result, int index) {
        int xorD = 0;
        for(int d : data) {
            xorD ^= d;
        }
        result[0] += xorD;

        for(int i=index; i<nums.length; i++) {
            data.add(nums[i]);
            getAllSubset(nums, data, result, i+1);
            data.remove(data.size() - 1);
        }
    }
}
