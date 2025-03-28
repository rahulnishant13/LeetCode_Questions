// 516. Longest Palindromic Subsequence
// https://leetcode.com/problems/longest-palindromic-subsequence/

class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String newS = sb.reverse().toString();
        int len = s.length();
        int[][] dp = new int[len+1][len+1];

        for(int i=1; i<len+1; i++) {
            for(int j=1; j<len+1; j++) {
                if(s.charAt(i-1) == newS.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[len][len];
    }
}
