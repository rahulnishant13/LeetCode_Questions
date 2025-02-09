// https://leetcode.com/problems/count-number-of-bad-pairs/?envType=daily-question&envId=2025-02-09


class CountNumberOfBadPairs {
    public long countBadPairs(int[] nums) {
        long goodPairCount = 0;
        long totalPairCount = 0;
        Map<Integer, Long> goodPairs = new HashMap<>();

        // for(int i=0; i < nums.length; i++){
        //     for(int j = i+1; j<nums.length; j++){
        //         if(j-i != (nums[j] - nums[i])){
        //             badPairCount++;
        //         }
        //     }
        // }

        for(int i=0; i < nums.length; i++){
            totalPairCount += i;
            int diff = nums[i] - i;
            goodPairCount += goodPairs.getOrDefault(diff, 0l);
            goodPairs.put(diff, goodPairs.getOrDefault(diff, 0l) + 1l);
        }



        return totalPairCount - goodPairCount;
        
    }
}
