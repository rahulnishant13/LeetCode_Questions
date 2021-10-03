package LeetCode_Questions;

import java.util.Arrays;

/**
 * [[0,0],[1,1],[0,0]]
 * 0 0
 * 1 1
 * 0 0
 */

public class UniquePathsII {
    public static void main(String[] args) {
//        {{1,0},{0,0}};//{{1}, {0}};//{{1,0}};//{{0,1},{0,0}}; //{{0, 0, 0},{0, 1, 0},{0, 0, 0}};
        int [][] obstacleGrid = {{0,0,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] arr = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid[0].length; i++) {
            arr[0][i] = 1;
            if(obstacleGrid[0][i] == 1){
                arr[0][i] = 0;
                break;
            }
        }

        for (int i = 0; i < obstacleGrid.length; i++) {
            arr[i][0] = 1;
            if(obstacleGrid[i][0] == 1){
                arr[i][0] = 0;
                break;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
                if(obstacleGrid[i][j] == 1){
                    arr[i][j] = 0;
                }
            }
        }
        return arr[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
