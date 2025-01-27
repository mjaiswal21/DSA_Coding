package Backtracking.src.main.java.com.leetcode;

//51. N-Queens
//https://leetcode.com/problems/n-queens/description/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no
two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

*/
public class NQueensOne {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n; i++) {

            for(int j = 0; j< n; j++) {
                board[i][j] = '.';
            }
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();
        Set<Integer> antiDiagonals = new HashSet<>();
        int row = 0;
        backtrack(row, ans , board, cols, diagonals, antiDiagonals, n );


        return ans;

    }

    private void backtrack(int row , List<List<String>> ans , char[][] board, Set<Integer> cols, Set<Integer> diagonals,
                           Set<Integer> antiDiagonals , int n){

        if(row == n){
            //add ans
            List<String> ls = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                String s = new String(board[i]);
                ls.add(s);
            }
            ans.add(ls);

            return;
        }

        for(int col = 0 ;  col < n; col++ ){

            int diagonal = row - col;
            int antiDiagonal = row + col;

            if(cols.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)){
                continue;
            }
            cols.add(col);
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);
            board[row][col] = 'Q';

            backtrack(row + 1 ,ans , board, cols , diagonals , antiDiagonals, n );

            cols.remove(col);
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
            board[row][col] = '.';
        }


    }

    public static void main(String[] args) {
        int n  = 4;
        NQueensOne nQueensOne = new NQueensOne();
        List<List<String>> ans = nQueensOne.solveNQueens(n);

        for(List<String> ls : ans){
            System.out.print("[ ");
            for (String s :ls){
                System.out.print(" " +  s + " ");
            }
            System.out.print(" ]");
            System.out.println("");
        }
    }

}
