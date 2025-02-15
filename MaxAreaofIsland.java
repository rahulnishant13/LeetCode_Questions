// https://leetcode.com/problems/max-area-of-island/description

class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       int count = 0;
       int max = 0;

       for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            count = getDFS(grid, i, j, n, m);
            max = Math.max(max, count);
        }
       }

       return max;
    }

    int getDFS(int[][] grid, int i, int j, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == 0){
            return 0;
        }
        if(grid[i][j] == 1){
            grid[i][j] = 0;
        }

        return 1 + getDFS(grid, i+1, j, n, m)
                 + getDFS(grid, i-1, j, n, m)
                 + getDFS(grid, i, j+1, n, m)
                 + getDFS(grid, i, j-1, n, m);
    }
}
