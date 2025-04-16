// 2537. Count the Number of Good Subarrays
// https://leetcode.com/problems/count-the-number-of-good-subarrays/

class CounttheNumberofGoodSubarrays {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> pairMap = new HashMap<>();
        long count = 0;
        long result = 0;
        int left = 0;

        for(int i=0; i<nums.length; i++) {
            pairMap.put(nums[i], pairMap.getOrDefault(nums[i], 0) + 1);
            if(pairMap.get(nums[i]) >= 2) {
                count += pairMap.get(nums[i]) - 1;
            }

            while(count >= k){
                result += nums.length - i;
                count -= pairMap.get(nums[left]) - 1;
                pairMap.put(nums[left], pairMap.getOrDefault(nums[left], 0) - 1);

                if(pairMap.get(nums[left]) == 0) {
                    pairMap.remove(nums[left]);
                }

                left++;
            }
        }

        // System.out.println(result);

    
        return result;
    }
}
