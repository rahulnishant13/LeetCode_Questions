// 873. Length of Longest Fibonacci Subsequence
// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
class LengthofLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> data = new HashSet<>();
        for(int num : arr){
            data.add(num);
        }
        int n = arr.length;
        int result = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int prev = arr[i];
                int curr = arr[j];
                int next = curr+prev;
                int count = 2;
                
                while(next <= arr[n-1] && data.contains(next)){
                    count++;
                    prev = curr;
                    curr = next;
                    next = curr+prev;
                }
                result = Math.max(result, count);
            }
        }

        return result > 2 ? result : 0;
    }
}
