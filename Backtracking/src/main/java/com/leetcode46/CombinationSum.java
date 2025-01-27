package Backtracking.src.main.java.com.leetcode46;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
//Leetcode 39
/*
*Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
*
*
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        int start = 0;
        int currSum = 0;
        backtrack(candidates , target, currList, ans, start, currSum);
        return ans;
    }

    private void backtrack(int[] candidates , int target , List<Integer> currList , List<List<Integer>> ans, int start, int currSum){

        //base case
        if(currSum == target){
            ans.add(new ArrayList<>(currList));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(currSum + candidates[i] <= target) {
                currList.add(candidates[i]);
                backtrack(candidates, target, currList, ans, i, currSum + candidates[i]);
                currList.remove(currList.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> ans = combinationSum.combinationSum(candidates , target);
        for(List<Integer> ls :ans){
            System.out.print("[ ");
            for(Integer n :ls){
                System.out.print(" "+ n + " ");
            }
            System.out.println(" ]");

        }

    }
}
