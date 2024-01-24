class JumpGameII {
    public int jump(int[] nums) {
        int jumpCount=0, maxJump=0, coverage=0 ;
        if (nums.length == 1) return 0;
        for (int i=0; i<nums.length; i++){
            
            coverage = coverage > nums[i]+i ? coverage : nums[i]+i;

            if(i == maxJump){
                maxJump = coverage;
                jumpCount++;
            }

            if(maxJump >= nums.length-1){
                return jumpCount;
            }
        }

        return jumpCount;
    }
}
