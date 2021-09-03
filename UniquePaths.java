package LeetCode_Questions;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println("using recursion: "+uniquePaths(m-1, n-1, 0, 0));
        System.out.println("using dp: "+getUniquePaths(m, n));
    }

    // using recursion
    private static int uniquePaths(int m, int n, int i, int j) {
        if(i == m && j == n)
            return 1;
        if (i > m)
            return 0;
        if (j > n)
            return 0;
        int result = uniquePaths(m, n, i, j+1) + uniquePaths(m, n, i+1, j);
        return result;
    }

    // using DP
    private static int getUniquePaths(int m, int n) {
        int [][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}
