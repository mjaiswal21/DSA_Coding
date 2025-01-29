package Backtracking.src.main.java.com.leetcode;

//967. Numbers With Same Consecutive Differences
//https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/

import java.util.ArrayList;
import java.util.List;

/*

Given two integers n and k, return an array of all the integers of length n where the difference
between every two consecutive digits is k. You may return the answer in any order.

Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.

Example 1:

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 */
public class NumberSameConsecDiff {
    public int[] numsSameConsecDiff(int n, int k) {

        List<String> ls = new ArrayList<>();
        StringBuilder comb = new StringBuilder();
        int start = 0;
        backtrack(ls , comb , start, n , k);
        int[] ans = new int[ls.size()];
        int count =0 ;
        for(String s : ls){

            ans[count] = Integer.parseInt(s);
            count++;
        }

        return ans;
    }

    private void  backtrack(List<String>  ls , StringBuilder comb , int start, int n , int k){

        if(comb.length() == n){
            String s = new String(comb);
            ls.add(s);
            return;
        }

        for(int i = 0 ; i <= 9 ; i++){

            if( i == 0 && start == 0){
                continue;
            }

            if(comb.length() >= 1){
                char lastNum = comb.charAt(comb.length() -1);
                int diff = Math.abs( (lastNum - '0') - i);
                if(diff == k){
                    comb.append(i);
                    backtrack(ls , comb , start + 1, n , k);
                    comb.deleteCharAt(comb.length() - 1);

                }

            }else{
                comb.append(i);
                backtrack(ls , comb , start + 1, n , k);
                comb.deleteCharAt(comb.length() - 1);

            }


        }

    }

    public static void main(String[] args) {
        int n = 3;
        int k = 7;

        NumberSameConsecDiff consecDiff = new NumberSameConsecDiff();
        int[] ans = consecDiff.numsSameConsecDiff(n, k);

        System.out.print("[ ");
        for(int i : ans){
            System.out.print(" " +i+ " ");
        }
        System.out.print(" ]");
    }
}
