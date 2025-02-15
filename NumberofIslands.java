// https://leetcode.com/problems/number-of-islands/description

class NumberofIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result =0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    result += getIsland(grid, i, j, n, m);
                }
            }
        }

        return result;
    }

    int getIsland(char[][] grid, int i, int j, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == '0'){
            return 0;
        }

        grid[i][j] = '0';
        getIsland(grid, i, j+1, n, m);
        getIsland(grid, i, j-1, n, m);
        getIsland(grid, i+1, j, n, m);
        getIsland(grid, i-1, j, n, m);
        return 1;
    }
}
