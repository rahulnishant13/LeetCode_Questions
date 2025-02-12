// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/?envType=daily-question&envId=2025-02-12


class MaxSumofaPairWithEqualSumofDigits {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int max = -1;

        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            int digitSum = 0;
            while(temp != 0){
                digitSum = digitSum + temp%10 ;
                temp = temp/10;
            }
            if(sumMap.containsKey(digitSum)){
                max = Math.max(max, sumMap.get(digitSum) + nums[i]);
            }
            sumMap.put(digitSum, Math.max(sumMap.getOrDefault(digitSum, 0), nums[i]));
        }

        return max;
    }
}
