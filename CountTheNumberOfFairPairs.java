// https://leetcode.com/problems/count-the-number-of-fair-pairs/description/?envType=daily-question&envId=2025-02-10

class CountTheNumberOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return getPairs(nums, upper) - getPairs(nums, lower-1);
    }

    private static long getPairs(int[] nums, int val){
        int i=0, j=nums.length-1;
        long count = 0;
        while(i <= j){
            if(nums[i] + nums[j] <= val){
                count += j-i;
                i++;
            } else {
                j--;
            }
        }
        // System.out.println(val + " : " + count);
        return count;
    }
}
