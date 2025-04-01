// https://leetcode.com/problems/increasing-triplet-subsequence/
// 334. Increasing Triplet Subsequence

class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        long first = Long.MAX_VALUE;
        long second = Long.MAX_VALUE;

        for(int num : nums) {
            if(num <= first){
                first = num;
            } else if(num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
