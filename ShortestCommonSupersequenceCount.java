// https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

class ShortestCommonSupersequenceCount {
    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0; i<n+1; i++){
            dp[i][0] = i;
        }
        
        for(int j=0; j<m+1; j++){
            dp[0][j] = j;
        }
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        
        return dp[n][m];
    }
}
