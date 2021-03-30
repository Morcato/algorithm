package com.morcat.leetcode;

/**
 *
 * Q74_搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 *
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *  
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 *  @author shenzixing
 *  @since 2021-03-30
 */
public class Q74 {

    /**
     * 两个二分查找法:
     * 先查找列,后查找行.
     */
    class TwoBinarySearch {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rowLen = matrix.length;
            int columnLen = matrix[0].length;
            int[] firstColumn = new int[rowLen];
            for (int i = 0; i < rowLen; i++) {
                firstColumn[i] = matrix[i][0];
            }
            int rowIndex = getColumnndex(target, firstColumn);
            return isExistInRow(target, matrix[rowIndex]);


        }

        public boolean isExistInRow(int target, int[] row) {
            int left = 0;
            int right = row.length - 1;
            int index = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (row[mid] == target) {
                    index = mid;
                    break;
                } else if (row[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (index >= 0) {
                return true;
            } else {
                return false;
            }
        }

        public int getColumnndex(int target, int[] column) {
            int left = 0;
            int right = column.length - 1;

            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (column[mid] <= target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;

        }
    }

}
