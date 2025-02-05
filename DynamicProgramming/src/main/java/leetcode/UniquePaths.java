package DynamicProgramming.src.main.java.leetcode;

//https://leetcode.com/problems/unique-paths/description/
//62. Unique Paths

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Input: m = 3, n = 7
Output: 28
 */

import java.util.Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            Arrays.fill(memo[i] , -1);
        }

        int ans = topDownDP(m - 1, n- 1 , memo);
        return ans;
    }

    private int topDownDP(int r , int c , int[][] memo){

        if(r + c == 0){
            return 1;
        }

        if(memo[r][c] != -1){
            return memo[r][c];
        }

        int cellVal = 0;
        if(r > 0) {
            cellVal = cellVal + topDownDP(r- 1 , c, memo);
        }

        if(c > 0) {
            cellVal = cellVal + topDownDP(r , c -1, memo);
        }

        memo[r][c] = cellVal;
        return memo[r][c];

    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int m = 3;
        int n = 7;
        int ans = uniquePaths.uniquePaths(m , n);
        System.out.println(ans);

    }
}
