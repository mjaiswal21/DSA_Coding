package Backtracking.src.main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    //https://leetcode.com/problems/subsets/
    //LeetCode 78

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(nums, 0 , currList , ans);
        return ans;

    }

    private void backtrack(int[] nums , int i , List<Integer> currList , List<List<Integer>> ans){

        //base
        if(i > nums.length){
            return;
        }

        ans.add(new ArrayList<>(currList));

        for(int j = i ; j < nums.length; j++ ){
            currList.add(nums[j]);
            backtrack(nums, j + 1 , currList , ans);
            currList.remove(currList.size() -1 );
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1 ,2 , 3};
        Subset subset = new Subset();
        List<List<Integer>> ans = subset.subsets(input);
        for(List<Integer> ls : ans){
            System.out.print("[");
            for(Integer n : ls ){
                System.out.print(" "+n+ " ");
            }
            System.out.print("]");
            System.out.println("");
        }
    }
}