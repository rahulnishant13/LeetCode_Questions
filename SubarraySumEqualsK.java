// https://leetcode.com/problems/subarray-sum-equals-k/description/?envType=problem-list-v2&envId=5go9wqm5

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0; int resCount =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                resCount += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return resCount;
    }
}
