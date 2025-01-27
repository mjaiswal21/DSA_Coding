package Backtracking.src.main.java.com.leetcode;

//https://leetcode.com/problems/all-paths-from-source-to-target/description/
//RunTime: (O)n*2^n
//Space: (O)n

import java.util.ArrayList;
import java.util.List;

public class LeetCode797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        int n = graph.length - 1;
        currList.add(0);
        backtrack(graph , ans , currList, n, 0 );
        return ans;

    }

    private void backtrack(int[][] graph , List<List<Integer>> ans , List<Integer> currList , int n, int start){
        //base
        if(start == n){
            ans.add(new ArrayList<>(currList));
            return;
        }

        for(int i = 0; i < graph[start].length; i++){

            int neighbor = graph[start][i];
            currList.add(neighbor);
            backtrack(graph, ans, currList , n , neighbor);
            currList.remove(currList.size() -1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = { {1,2}, {3}, {3}, {} };

        LeetCode797 leetCode797 = new LeetCode797();
        List<List<Integer>> ans = leetCode797.allPathsSourceTarget(graph);
        for(List<Integer> ls :ans){
            System.out.print("[");
            for(Integer n :ls){
                System.out.print(" " + n + " ");
            }
            System.out.print("]");
            System.out.println("");
        }

    }
}
