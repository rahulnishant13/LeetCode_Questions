// 2226. Maximum Candies Allocated to K Children
// https://leetcode.com/problems/maximum-candies-allocated-to-k-children

class MaximumCandiesAllocatedtoKChildren {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0, left = 1;
        for(int candy : candies) {
            sum += candy;
            // right = Math.max(right, candy);
        }
        if(sum < k) {
            return 0;
        }

        long result = 0, right = (sum/k);
        
        while(left <= right) {
            long mid = (left+right)/2;
            long child = 0;

            for(int candy : candies) {
                child += (candy/mid);
            }

            if(child >= k){
                result = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }

            // System.out.println(left +" : "+right);

        }

        return (int)result;
    }
}
