package Backtracking.src.main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/description/
//LeetCode : 77
//Run Time : O(K*(N * Choose K))
//Space : O(N)
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(n , currList , ans, k , 1);
        return ans;

    }

    private void backtrack(int n , List<Integer> currList , List<List<Integer>> ans , int k, int start){
        //base
        if(currList.size() == k){
            ans.add(new ArrayList<>(currList));
            return;
        }

        for(int i = start; i <= n; i++){

            currList.add(i);
            backtrack(n, currList, ans, k, i+1);
            currList.remove(currList.size() -1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combinations combinations = new Combinations();
        List<List<Integer>> lists = combinations.combine(n, k);
        for (List<Integer> list :lists){
            System.out.print("[");
            for (int no: list){
                System.out.print(" "+no+" ");
            }
            System.out.print("]");
            System.out.println("");
        }

    }
}
