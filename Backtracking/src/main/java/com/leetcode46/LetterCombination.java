package Backtracking.src.main.java.com.leetcode46;

//LeetCode 17. Letter Combinations of a Phone Number

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**Given a string containing digits from 2-9 inclusive, return all possible letter
 * combinations that the number could represent. Return the answer in any order.
    A mapping of digits to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombination {

     public List<String> letterCombinations(String digits) {

         //digit setup for 2 to 9 as per question
         Map<Character , String> keyMap = new HashMap<>();keyMap.put('2', "abc");
         keyMap.put('2', "abc");
         keyMap.put('3', "def");
         keyMap.put('4', "ghi");
         keyMap.put('5', "jkl");
         keyMap.put('6', "mno");
         keyMap.put('7', "pqrs");
         keyMap.put('8', "tuv");
         keyMap.put('9', "wxyz");

         List<String> ans = new ArrayList<>();
         StringBuilder comb = new StringBuilder();
         int start = 0;
         backtrack(keyMap, ans, comb, digits, start);

         return ans;
     }

     private void backtrack(Map<Character, String> keyMap , List<String> ans , StringBuilder comb , String digits, int start){
         //base case
         if(start == digits.length()){
             ans.add(comb.toString());
             return;
         }


         char digit = digits.charAt(start);
         String letters = keyMap.get(digit);
         for(int i = 0 ; i < letters.length(); i++){
             comb.append(letters.charAt(i));
             backtrack(keyMap, ans, comb, digits, start+1);
             comb.deleteCharAt(comb.length() - 1);
         }

     }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombination letterCombination = new LetterCombination();
        List<String> ans = letterCombination.letterCombinations(digits);
        System.out.print("[ ");
        int count = 0;
        for(String s: ans){
            count++;
            System.out.print(s);
            if(ans.size() > count) {
                System.out.print(" ,");
            }
        }
        System.out.println(" ]");
    }

}
