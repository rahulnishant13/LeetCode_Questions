// https://leetcode.com/problems/partition-equal-subset-sum
// 416. Partition Equal Subset Sum


class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
       int sum = 0;

       for(int num : nums) {
        sum += num;
       }

       if(sum%2 != 0){
        return false;
       }

       boolean[] dp = new boolean[sum/2 + 1];
       dp[0] = true;

       for(int num : nums) {
        for(int i=sum/2; i>=0; i--){
            if(i-num >= 0){
                dp[i] = dp[i] || dp[i-num];
            }
        }
       }

       return dp[sum/2];
        
    }
}
