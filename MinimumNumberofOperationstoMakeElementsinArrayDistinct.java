// https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/
// 3396. Minimum Number of Operations to Make Elements in Array Distinct

class MinimumNumberofOperationstoMakeElementsinArrayDistinct {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxIndex = 0;

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                maxIndex = Math.max(map.get(nums[i])+1, maxIndex);
            }
            map.put(nums[i], i);
        }

        // System.out.println(maxIndex);

        return maxIndex%3 == 0 ? maxIndex/3 : maxIndex/3 + 1;
    }
}
