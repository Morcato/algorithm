package com.morcat.leetcode;

/**
 *  Q283_移动零
 *
 *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 *  说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *  @author shenzixing
 *  @since 2021-01-05
 */
public class Q283 {


    /**
     * 解题思路:使用快慢指针,慢指针指向当前已经处理好的序列的尾部，快指针指向待处理序列的头部。
     *  最终:慢指针左边均为非零数；
     *       慢指针右边直到数组最后均为0
     */

    /**
     * 我的双指针解题,有点复杂了,但思路没错
     * @param nums
     */
    public void moveZeroes_2Point_MySolution(int[] nums) {
        int slowIndex = 0;
        int zeroCount = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] == 0) {
                zeroCount++;
            } else {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        while (zeroCount != 0) {
            nums[slowIndex] = 0;
            slowIndex = slowIndex + 1;
            zeroCount--;
        }
    }

    /**
     * 优秀的解题方式
     * 不需要使用zeroCount
     */
    public void moveZeroes_2Point_Excellent(int[] nums) {
        int slownIndex = 0;
        for(int fastIndex=0;fastIndex<nums.length;fastIndex++) {
            if(nums[fastIndex]!=0) {
                nums[slownIndex++] = nums[fastIndex];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=slownIndex;i<nums.length;++i) {
            nums[i] = 0;
        }
    }

}
