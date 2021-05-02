package com.morcat.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  Q54_螺旋矩阵
 *
 *  给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *  
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 *
 *  @author shenzixing
 *  @since 2021-05-02
 */
public class Q54 {

    /**
     * 思想: 定义 left,top,right,bottom
     * 一次循环 四次迭代,打印数据
     *
     * 参考题解:https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int columnLen = matrix[0].length;
        int rowLen = matrix.length;
        int left = 0;
        int top = 0;
        int right = columnLen - 1;
        int bottom = rowLen - 1;
        int nums = 0;
        while (nums < columnLen * rowLen) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                nums++;
            }
            if (nums >= columnLen * rowLen) {
                break;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                nums++;
            }
            if (nums >= columnLen * rowLen) {
                break;
            }
            right--;

            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
                nums++;
            }
            if (nums >= columnLen * rowLen) {
                break;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
                nums++;
            }
            if (nums >= columnLen * rowLen) {
                break;
            }
            left++;

        }
        return result;
    }

}
