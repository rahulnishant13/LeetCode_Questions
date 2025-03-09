// 239. Sliding Window Maximum
// https://leetcode.com/problems/sliding-window-maximum/

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0; i<n; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            // System.out.println(dq + " :: "+ i);

            if(!dq.isEmpty() && dq.peekFirst() < (i-k+1)) {
                dq.pollFirst();
            }

            // System.out.println(dq + " : "+ i);

            if(i >= k-1) {
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
