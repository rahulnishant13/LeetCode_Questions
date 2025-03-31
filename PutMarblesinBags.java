// 2551. Put Marbles in Bags
// https://leetcode.com/problems/put-marbles-in-bags/

class PutMarblesinBags {
    public long putMarbles(int[] weights, int k) {
        if(weights.length <= k) return 0;

        int n = weights.length;
        int [] arr = new int[n-1];
        // PriorityQueue<Integer> heap = new PriorityQueue<>();
        // PriorityQueue<Integer> maxHip = new PriorityQueue<>((a,b) -> (b-a));

        // minHip.offer(weights[0]+weights[0]);
        // minHip.offer(weights[n-1]+weights[n-1]);
        // maxHip.offer(weights[0]+weights[0]);
        // maxHip.offer(weights[n-1]+weights[n-1]);
        // for(int i=1; i<(n/2 + 1); i++){
        //     minHip.offer(weights[i] + weights[n-i]);
        //     maxHip.offer(weights[i] + weights[n-i]);
        // }

        for(int i=0; i<n-1; i++){
            arr[i] = weights[i] + weights[i+1];
            // heap.offer(weights[i] + weights[i+1]);
            // maxHip.offer(weights[i] + weights[i+1]);
        }

        // int minCost = weights[0] + weights[weights.length-1];
        // int maxCost = minCost;
        // System.out.println(maxCost +" - "+ minCost);

        long result = 0;
        Arrays.sort(arr);
        // int size = heap.size();

        for(int i=0; i<k-1; i++){
            result += arr[n-i-2] - arr[i];
        }

        // System.out.println(maxCost +" - "+ minCost);

        return result;
    }
}
