package Backtracking.src.main.java.com.leetcode;

//216. Combination Sum III
//https://leetcode.com/problems/combination-sum-iii/description/
/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice,
and the combinations may be returned in any order.



Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

 */


import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currComb = new ArrayList<>();
        int start = 1;
        int sum = 0;
        backtrack(ans , currComb, k , n , start, sum);

        return ans;
    }

    private void backtrack(List<List<Integer>> ans , List<Integer> currComb, int k , int n , int start, int sum) {

        if(currComb.size() == k && sum == n){
            List<Integer> ls = new ArrayList<>(currComb);
            ans.add(ls);
            return;
        }

        for(int i = start ; i <=9 ; i++){

            if(currComb.size() >= 1){
                if(n >= sum+ i ){
                    currComb.add(i);
                    backtrack(ans , currComb, k , n , i+1, sum + i);
                    currComb.remove(currComb.size() -1);
                }

            }else{
                currComb.add(i);
                backtrack(ans , currComb, k , n , i+1, sum + i);
                currComb.remove(currComb.size() -1);
            }

        }


    }

    public static void main(String[] args) {
        int n = 3;
        int k = 9;
        CombinationSumIII combination = new CombinationSumIII();
        List<List<Integer>> ans = combination.combinationSum3(n , k );
        for(List<Integer> ls : ans) {
            System.out.print("[  ");
            for (Integer i : ls){
                System.out.print(" "+i);
            }
            System.out.print("  ] ");
        }
    }

}
