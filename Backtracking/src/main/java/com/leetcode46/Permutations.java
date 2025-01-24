package Backtracking.src.main.java.com.leetcode46;

import java.util.ArrayList;
import java.util.List;

public class Permutations {


    //LeetCode 46. Permutations
    //https://leetcode.com/problems/permutations/description/

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(nums, ans , currList);

        return ans;

    }

    private void backtrack( int[] nums , List<List<Integer>> ans , List<Integer> currList){

        //base Condition
        if( currList.size() == nums.length){
            List<Integer> newList = new ArrayList<>(currList);
            ans.add(newList);
            return;
        }

        for(int no : nums){

            if(!currList.contains(no)){
                currList.add(no);
                backtrack(nums, ans, currList);
                currList.remove(currList.size() - 1);
            }
        }
    }


    public static void main(String[] args) {

        int[] test1 = new int[] {1, 2, 3};
        //int[] test2 = new int[] {0, 1};
        //int[] test3 = new int[] {1};

        Permutations permutations = new Permutations();
        List<List<Integer>> ans = permutations.permute(test1);
        List<Integer> printList =   ans.get(0);
        for (List<Integer> inner : ans) {
            System.out.print(" [ " );
            for (int n : inner) {
                System.out.print(" " + n + " ");
            }
            System.out.print(" ] " );
            System.out.println(" ");
        }


    }
}
