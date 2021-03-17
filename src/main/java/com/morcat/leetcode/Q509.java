package com.morcat.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Q509_斐波那契数
 *
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 *  
 *
 * 提示：
 *
 * 0 <= n <= 30
 *
 *
 *  @author shenzixing
 *  @since 2021-03-17
 */
public class Q509 {

    /**
     * 经典解法,使用递归求解.
     * 时间复杂度,空间复杂度都很高
     */
    class classicSolution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {

                return 1;
            }
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * 备忘录法,可以减少空间复杂度.
     */
    class memorySolution {
        Map<Integer, Integer> map = new HashMap<>();

        public int fib(int n) {
            if (n == 0) {
                map.put(n, 0);
                return 0;
            }
            if (n == 1) {
                map.put(n, 1);
                return 1;
            }
            int fibA;
            int fibB;
            if (map.containsKey(n - 1)) {
                fibA = map.get(n - 1);
            } else {
                fibA = fib(n - 1);
                map.put(n - 1, fibA);
            }

            if (map.containsKey(n - 2)) {
                fibB = map.get(n - 2);
            } else {
                fibB = fib(n - 2);
                map.put(n - 2, fibB);
            }

            return fibA + fibB;
        }
    }

}
