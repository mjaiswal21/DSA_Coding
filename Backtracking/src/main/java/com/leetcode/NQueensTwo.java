package Backtracking.src.main.java.com.leetcode;

import java.util.HashSet;
import java.util.Set;

//52. N-Queens II
//https://leetcode.com/problems/n-queens-ii/
/*

The n-queens puzzle is the problem of placing n queens on an n x n
chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

 */
public class NQueensTwo {

    public int totalNQueens(int n) {

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();
        Set<Integer> antiDiagonals = new HashSet<>();
        int row = 0;
        int count = backtrack(row , cols , diagonals, antiDiagonals , n);
        return count;

    }

    private int backtrack(int row , Set<Integer> cols , Set<Integer> diagonals , Set<Integer> antiDiagonals, int n ){
            if(row == n){
                return 1;
            }
            int count  = 0;
            for(int col = 0 ; col < n; col++){

                int diagonal = row - col;
                int antiDiagonal = row + col;

                if(cols.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)){
                    continue;
                }
                cols.add(col);
                diagonals.add(diagonal);
                antiDiagonals.add(antiDiagonal);

                count = count + backtrack(row + 1, cols, diagonals, antiDiagonals, n);

                cols.remove(col);
                diagonals.remove(diagonal);
                antiDiagonals.remove(antiDiagonal);

            }

            return count;
    }

    public static void main(String[] args) {
        NQueensTwo nQueensTwo = new NQueensTwo();
        int n = 4;
        int ans = nQueensTwo.totalNQueens(n);
        System.out.println("ans " + ans);
    }
}
