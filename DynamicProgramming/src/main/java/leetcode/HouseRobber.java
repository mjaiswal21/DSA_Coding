package DynamicProgramming.src.main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/house-robber/description/
//198. House Robber
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount
of money stashed, the only constraint stopping you from robbing each of them is that adjacent
houses have security systems connected and it will automatically contact the police if two adjacent
houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum
amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

 */
public class HouseRobber {

    public int rob(int[] nums) {


        // Top Down approach
        /*
        int state = nums.length -1;
        int ans = topDownDP(state , nums);
        return ans;
        */


        int ans = bottomUpDP(nums);
        return ans;
    }

    private int bottomUpDP(int[] nums){

        if(nums.length == 1){
            return nums[0];
        }

        int secondPrev = nums[0];
        int prev = Math.max(nums[1] , nums[0]);

        for(int i = 2 ; i < nums.length; i++){

            int temp = prev;
            prev = Math.max(nums[i] + secondPrev , prev);
            secondPrev = temp;
        }

    return prev;
    }


    Map<Integer , Integer> memoizationMap = new HashMap<>();
    private int topDownDP(int state , int[] nums){

        if(state == 0){
            return nums[state];
        }

        if(state == 1){
            return Math.max(nums[state] , nums[state -1]);
        }

        if(memoizationMap.containsKey(state)){
            return memoizationMap.get(state);
        }

        //rob the house
        int ch1 = nums[state] + topDownDP(state - 2 , nums);
        //dont Rob the house
        int ch2 = topDownDP(state -1 , nums);
        int maxMoney = Math.max(ch1, ch2);
        memoizationMap.put(state, maxMoney);

        return memoizationMap.get(state);


    }

    public static void main(String[] args) {
        //int [] nums = {1, 2, 3, 1};

        int [] nums = {2, 7, 9, 3, 1};

        /*
        HouseRobber houseRobber = new HouseRobber();
        int ans = houseRobber.rob(nums);
        System.out.print("[ ");
        System.out.print(" " +ans+" ");
        System.out.println(" ]");
        */

        HouseRobber houseRobber = new HouseRobber();
        int ans =  houseRobber.rob(nums);
        System.out.print("[ ");
        System.out.print(" " +ans+" ");
        System.out.println(" ]");


    }

}
