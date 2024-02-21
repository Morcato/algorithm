package com.morcat.leetcode;

/**
 *  Q33_搜索旋转排序数组
 *
 *  升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 *
 *  @author shenzixing
 *  @since 2021-02-07
 */
public class Q33 {

    /**
     * 思路:二分查找法
     * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
     * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }

    /**
     * 2024.2.22 第二次做该题想到了用递归去解决,方案也是类似将数组一分为二,有序的部分二分查找,无序的部分继续递归
     */
    class RecursionSolution {
        public int search(int[] nums, int target) {
            return search(nums,target,0,nums.length-1);
        }

        private int search(int[] nums, int target,int start,int end) {
            if(start>=end){
                if(nums[start] == target){
                    return start;
                }else{
                    return -1;
                }
            }
            int mid =  start + (end - start) / 2 ;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start] <= nums[mid]){
                // 左半边二分查找
                int value = binarySearch(nums,target,start,mid -1);
                if(value != -1){
                    return value;
                }

                // 右半边递归
                return search(nums,target,mid+1,end);

            }else{
                // 左半边递归
                int value =  search(nums,target,start,mid-1);
                if(value != -1){
                    return value;
                }
                // 右半边二分查找
                return binarySearch(nums,target,mid+1,end);

            }
        }

        private int binarySearch(int[] nums,int target,int start,int end){
            while(start <= end){
                int mid = start + ( end - start)/2;
                int value = nums[mid];
                if(value == target){
                    return mid;
                }else if(value < target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }

            }
            return -1;
        }
    }
}
