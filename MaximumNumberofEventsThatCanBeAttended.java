// 1353. Maximum Number of Events That Can Be Attended
// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/

class MaximumNumberofEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 0;
        int len = events.length;
        int maxday = 0;
        for (int[] event : events) {
            maxday = Math.max(maxday, event[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1, j=0; i<=maxday; i++) {
            while(j<len && events[j][0] <= i){
                pq.offer(events[j][1]);
                j++;
            }

            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }

            if(!pq.isEmpty()) {
                pq.poll();
                result++;
            }
        }

        return result;
    }
}
