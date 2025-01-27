package Backtracking.src.main.java.com.leetcode;

//79. Word Search
//https://leetcode.com/problems/word-search/description/

/*

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
 horizontally or vertically neighboring. The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        boolean[][] visited = new boolean[r][c];
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j< c ; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if(backtrack(visited , i , j , board , word , 1)){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }

    int[][] dir = {{0, 1 }, {1, 0}, {0, -1} , {-1 , 0}};
    private boolean isValid(int x, int y , char[][] board){
        if(x < 0 || x >=board.length || y < 0 || y >= board[0].length){
            return false;
        }
        return true;
    }
    private boolean backtrack(boolean[][] visited , int row , int col , char[][] board , String word ,
                              int wordIdx){
        if(wordIdx == word.length()){
            return true;
        }

        for(int i = 0 ; i < 4; i++){

            int newR  =  row + dir[i][0];
            int newC  =  col + dir[i][1];
            if(isValid(newR, newC, board) && !visited[newR][newC] && board[newR][newC] == word.charAt(wordIdx)){
                visited[newR][newC] = true;
                if(backtrack(visited, newR, newC, board, word, wordIdx+1)){
                    return true;
                }
                visited[newR][newC] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        WordSearch wordSearch = new WordSearch();
        boolean ans = wordSearch.exist(board, word);
        System.out.println("ans : " + ans);
    }
}









