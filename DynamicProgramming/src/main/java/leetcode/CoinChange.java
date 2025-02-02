package DynamicProgramming.src.main.java.leetcode;

//322. Coin Change
//https://leetcode.com/problems/coin-change/description/

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);  // -2 means "not yet computed"
        return helper(coins, amount, memo);
    }

    private int helper(int[] coins, int amount, int[] memo) {
        // Base cases
        if (amount == 0) return 0;  // No coins needed for 0
        if (amount < 0) return -1;  // No valid combination possible

        // Return if already computed
        if (memo[amount] != -2) return memo[amount];

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = helper(coins, amount - coin, memo);
            if (result != -1) {  // Only consider valid results
                minCoins = Math.min(minCoins, result + 1);
            }
        }

        // Store the result in memo
        memo[amount] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[amount];

    }

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        System.out.println(sol.coinChange(new int[]{2}, 3));  // Output: -1
    }
}
