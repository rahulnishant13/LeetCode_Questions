// https://leetcode.com/problems/house-robber-ii/description/

class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0) {
            return 0;
        } else if(n == 1){
            return nums[0];
        } else if(n == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n-1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        int[] dp1 = new int[n];
        dp1[1] = nums[1];
        dp1[2] = Math.max(nums[2], nums[1]);
    
        for(int i=3; i<n; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
        }

        // System.out.println(dp1[n-1] + " : "+ dp[n-2]);

        return Math.max(dp[n-2], dp1[n-1]);
    }
}
