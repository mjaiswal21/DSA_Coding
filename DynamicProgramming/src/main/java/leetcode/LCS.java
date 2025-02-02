package DynamicProgramming.src.main.java.leetcode;

import java.util.Arrays;

public class LCS {

    public int longestCommonSubsequence(String text1, String text2) {

        //return bottomUpDP(text1 , text2);
        return topDownDP(text1 , text2);
    }

    private int topDownDP(String text1, String text2){


        int[][] memo = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length() ; i++){
            Arrays.fill(memo[i] , -1);
        }

        int ans =     dp(0, 0 , text1 , text2, memo);
        return ans;
    }

    private int dp(int i , int j , String text1 , String text2, int[][] memo){

        if(i == text1.length() || j == text2.length() ){
            return 0;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }


        int ans = 0;
        if(text1.charAt(i) ==  text2.charAt(j)){
            ans = 1 + dp(i+1, j+1 , text1 , text2 , memo);
        }else{
            ans = Math.max(dp(i+1, j,  text1, text2, memo), dp(i, j+1, text1 , text2, memo) );
        }

        memo[i][j] = ans;
        return memo[i][j];
    }

    private int bottomUpDP(String text1 , String text2){
        int m = text1.length();
        int n = text2.length();

        // adding one row and one col for simplicity to have implementation
        int[][] memo = new int[m+1][n+1];

        for(int i = m- 1; i >=0 ; i--){
            for(int j = n-1 ; j >= 0; j--){

                if(text1.charAt(i) == text2.charAt(j)){
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                }
                if(text1.charAt(i) != text2.charAt(j )){
                    memo[i][j] = Math.max(memo[i+1][j] , memo[i][j+1]);
                }

            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        LCS lcs = new LCS();
        int ans = lcs.longestCommonSubsequence(text1, text2);
        System.out.println(ans);
    }

}
