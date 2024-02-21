package com.morcat.leetcode;

/**
 * Q415_字符串相加
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * @author shenzixing
 * @since 2021-05-14
 */
public class Q415 {

    /**
     * 思路: 双指针
     */
    public String addStrings(String s1, String s2) {
        String result = "";
        int s1Index = s1.length() - 1;
        int s2Index = s2.length() - 1;
        int temp = 0;
        while (s1Index >= 0 || s2Index >= 0) {
            if (s2Index < 0) {
                int s1Value = s1.charAt(s1Index) - '0' + temp;

                if (s1Value >= 10) {
                    temp = 1;
                } else {
                    temp = 0;
                }
                result = s1Value % 10 + result;
                s1Index--;
            } else if (s1Index < 0) {
                int s2Value = s2.charAt(s2Index) - '0' + temp;
                if (s2Value >= 10) {
                    temp = 1;
                } else {
                    temp = 0;
                }
                result = s2Value % 10 + result;
                s2Index--;
            } else {
                int s1Value = s1.charAt(s1Index) - '0';

                int s2Value = s2.charAt(s2Index) - '0';
                int sum = s1Value + s2Value + temp;

                if (sum >= 10) {
                    temp = 1;
                } else {
                    temp = 0;
                }
                result = sum % 10 + result;
                s1Index--;
                s2Index--;
            }
        }
        if (temp == 1) {
            result = 1 + result;
        }
        return result;
    }

    /**
     * 2024.2.22 第二次做该题,逻辑更清晰
     */
    public String addStringsV2(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();

        int temp = 0;
        String result = "";
        while (length1 > 0 || length2 > 0) {
            int value1 = length1 <= 0 ? 0 : num1.charAt(length1 - 1) - '0';
            int value2 = length2 <= 0 ? 0 : num2.charAt(length2 - 1) - '0';

            int sum = value1 + value2 + temp;

            temp = sum / 10;
            int value = sum % 10;
            result = value + result;

            length1--;
            length2--;
        }
        if (temp != 0) {
            result = "1" + result;
        }
        return result;
    }

}
