package LeetCode_Questions;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int [][] grid = {{0, 0, 0, 0},{1, 1, 1, 0},{0, 0, 0, 1}};

        System.out.println(shortestPathBinaryMatrix(grid));
    }

    private static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{0,0, 1});
        grid[0][0] = 1;

        int [][] dir = {{1,0},{0,1},{1,1},{-1,0},{0,-1},{1,-1},{-1,1},{-1,-1}};

        while(!qu.isEmpty()){
            int size = qu.size();
            while(size-- > 0){
                int [] point = qu.poll();

                if(point[0] == m-1 && point[1] == n-1)
                    return point[2];

                for(int[] d : dir){
                    int r = d[0] + point[0];
                    int c = d[1] + point[1];

                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == 0){
                        qu.add(new int[]{r,c, point[2] + 1});
                        grid[r][c] = 1;
                    }
                }
            }
        }

        return -1;
    }
}
