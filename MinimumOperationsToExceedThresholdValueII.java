// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/


class MinimumOperationsToExceedThresholdValueII {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int count = 0;

        for(int i =0; i<nums.length; i++){
            pq.add((long) nums[i]);
        }        
        
        while(pq.peek() < k){
            long x = pq.poll();
            long y = pq.poll();

            long sum = Math.min(x,y) * 2 + Math.max(x,y);
            pq.add(sum);
            count++;
        }
        

        return count;
    }
}
