package DynamicProgramming.src.main.java.leetcode;

import java.util.Arrays;

public class BuyStockIV {

    public int maxProfit(int k, int[] prices) {

        //return bottomUpDP(k , prices);
        return topDownDP(k, prices);
    }

    private int topDownDP(int k , int[] prices){
        int m = prices.length;
        int[][][] memo = new int[m][2][k+1];
        for(int i = 0 ; i < m; i++ ){
            for(int j = 0; j< 2; j++){
                Arrays.fill(memo[i][j] , -1);
            }
        }


        int ans = dp(0, 0 , prices , k, memo);
        return ans;
    }

    private  int dp(int i , int holding , int[] prices , int k , int[][][] memo){

        if(i == prices.length || k == 0){
            return 0;
        }

        if(memo[i][holding][k] != -1){
            return  memo[i][holding][k];
        }


        //case 1- skip
        int ans = dp(i + 1, holding, prices, k, memo);

        //case 2 - buy
        if(holding == 0) {
            ans = Math.max(ans , - prices[i] + dp(i+1 , 1 , prices , k , memo));
        }else{
            //case 3 - sell
            ans = Math.max(ans , prices[i] + dp(i+1, 0, prices , k- 1 , memo));

        }

        memo[i][holding][k] = ans;

        return memo[i][holding][k];
    }


    private int bottomUpDP(int k , int[] prices){
        int m = prices.length;
        //keeping price on a day , holding 0/1 , number of transaction + 1 day zero would be zero transation
        int[][][] memo = new int[m+1][2][k+1];

        for(int i = m - 1 ; i >=0 ; i--){ // day price
            for(int t = 1 ; t <= k; t++){  // transaction

                for(int h = 0; h < 2; h++){ // holding

                    int ans = memo[i +1] [h] [t];
                    if(h == 1 ){ // sell
                        ans = Math.max(ans , memo[i+1][0][t -1] + prices[i]);
                    }else{ // buy
                        ans = Math.max(ans , memo[i+1][1][t] - prices[i]);
                    }
                    memo[i][h][t] = ans;
                }
            }
        }

        return memo[0][0][k];

    }

    public static void main(String[] args) {
        BuyStockIV buyStockIV = new BuyStockIV();
        int k = 3 ;
        int[]  prices = {2,4,1};
        //int ans = buyStockIV.bottomUpDP(k , prices);
        int ans = buyStockIV.topDownDP(k , prices);
        System.out.println(ans);
    }
}
