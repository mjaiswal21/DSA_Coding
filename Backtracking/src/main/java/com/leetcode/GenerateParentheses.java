package Backtracking.src.main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

//22. Generate Parentheses
//https://leetcode.com/problems/generate-parentheses/description/
/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        int leftBracket = 0;
        int rightBracket = 0;
        StringBuilder comb = new StringBuilder();
        backtrack(ans , n , leftBracket , rightBracket, comb );
        return ans;
    }

    private void backtrack(List<String> ans , int n , int leftBracket , int rightBracket, StringBuilder comb ){

        if(comb.length() == 2 * n){
            String s = new String(comb);
            ans.add(s);
            return;
        }

        if(leftBracket < n){
            comb.append("(");
            backtrack(ans , n , leftBracket + 1 , rightBracket, comb );
            comb.deleteCharAt(comb.length()  -1);
        }

        if(leftBracket > rightBracket ){
            comb.append(")");
            backtrack(ans , n , leftBracket , rightBracket + 1, comb );
            comb.deleteCharAt(comb.length()  -1);
        }

    }

    public static void main(String[] args) {
        int n = 3;

        GenerateParentheses parentheses = new GenerateParentheses();
        List<String> ans = parentheses.generateParenthesis(n);
        System.out.print("[ ");
        for(String s: ans){
            System.out.print(" " +s+" ");
        }
        System.out.println(" ]");
    }
}
