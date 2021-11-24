package com.ruanxinxin.algorithm;

public class CoinCount {

    static int solution(int[] coins, int amount) {
        int max = amount + 1;
        Integer[] dp = new Integer[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        int count = solution(new int[]{1, 2, 5}, 5);
        System.out.println(count);
    }
}
