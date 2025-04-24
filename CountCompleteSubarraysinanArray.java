// 2799. Count Complete Subarrays in an Array
// https://leetcode.com/problems/count-complete-subarrays-in-an-array/

class CountCompleteSubarraysinanArray {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int l = 0;
        int result = 0;

        for(int num : nums) {
            numSet.add(num);
        }

        for(int i=0; i<nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

            while(freqMap.size() == numSet.size()) {
                result += nums.length - i;

                freqMap.put(nums[l], freqMap.getOrDefault(nums[l], 0) - 1);
                if(freqMap.get(nums[l]) == 0) {
                    freqMap.remove(nums[l]);
                }

                l++;
            }
        }

        return result;
    }
}
