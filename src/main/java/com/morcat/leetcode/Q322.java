package com.morcat.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *  Q322_零钱兑换
 *
 *  @author shenzixing
 *  @since 2021-03-17
 */
public class Q322 {

    /**
     * 暴力递归求解,会超时
     */
    class ClassicSolution {

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            int result = Integer.MAX_VALUE;
            for (int coin : coins) {


                int subProblem = coinChange(coins, amount - coin);
                if (subProblem == -1) {
                    continue;
                }
                result = Math.min(result, subProblem + 1);
            }
            if (result == Integer.MAX_VALUE) {
                return -1;
            } else {
                return result;
            }
        }

    }

    /**
     * 使用备忘录优化(自顶而下)
     */
    class MemorySolution {

        Map<Integer, Integer> memory = new HashMap<>();

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                memory.put(amount, 0);
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            int result = Integer.MAX_VALUE;
            for (int coin : coins) {
                int subProblem;
                if (memory.containsKey(amount - coin)) {
                    subProblem = memory.get(amount - coin);
                } else {
                    subProblem = coinChange(coins, amount - coin);
                }

                if (subProblem == -1) {
                    continue;
                }
                result = Math.min(result, subProblem + 1);
            }
            if (result == Integer.MAX_VALUE) {
                memory.put(amount, -1);
                return -1;
            } else {
                memory.put(amount, result);
                return result;
            }
        }

    }

    /**
     * dp 数组的迭代解法 (自底而上)
     */
    class DpTableSolution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;
            for(int i = 0 ; i<=amount ; i++){
                for(int coin:coins){
                    if(i-coin>=0 && dp[i - coin] != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                    }
                }
            }
            if(dp[amount] == Integer.MAX_VALUE){
                return -1;
            }else{
                return dp[amount];
            }
        }
    }


}
