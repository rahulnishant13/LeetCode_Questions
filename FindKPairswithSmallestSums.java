// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

class FindKPairswithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
            (a,b) -> Integer.valueOf(a.get(0) + a.get(1)).compareTo(Integer.valueOf(b.get(0) + b.get(1))));

        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                pq.offer(list);
            }
        }

        for(int i=0; i<k; i++){
            result.add(pq.poll());
        }

        return result;
    }
}
