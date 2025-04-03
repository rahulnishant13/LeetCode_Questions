// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i
// 2873. Maximum Value of an Ordered Triplet I

class MaximumValueofanOrderedTripletI {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        int n = nums.length;
        int[] max = new int[]{0, Integer.MIN_VALUE};
        int[] min = new int[]{0, Integer.MAX_VALUE};
        boolean flag = false;

        for(int i=0; i<n; i++) {
            if(max[1] < nums[i] && i<n-2){
                max = new int[]{i, nums[i]};
                flag = false;
            } else if((min[1] > nums[i]) || (max[0] > min[0])  && i < n-1) {
                min = new int[]{i, nums[i]};
                flag = true;
            }

            if(flag) {
                int k = min[0] + 1;
                while(k<n) {
                    long curr = (long)(max[1] - min[1]) * nums[k];
                    res = Math.max(res, (curr > 0 ? curr : 0));
                    
                    // System.out.println(max[1] +" - "+ min[1] + " - "+ nums[k]);

                    k++;
                }
            }
        }

        return res;
    }
}
