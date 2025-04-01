// 2140. Solving Questions With Brainpower
// https://leetcode.com/problems/solving-questions-with-brainpower/

class SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n-1] = questions[n-1][0];

        for(int i=n-2; i>=0; i--) {
            int nextIndex = i + questions[i][1] + 1;
            int currValue = questions[0][0];

            long data = (nextIndex <= n-1) ? dp[nextIndex] : 0;
            dp[i] = Math.max(questions[i][0] + data, dp[i+1]);
        }

        // System.out.println(Arrays.toString(dp));

        return dp[0];
    }
}
