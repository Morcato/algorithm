package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *
 *  Q23_合并K个升序链表
 *
 *  给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 *  @author shenzixing
 *  @since 2021-04-02
 */
public class Q23 {

    /**
     * 我的思路:
     * 每次获取链表数组里最小的一个数据,并在原有链表中移除.最终拼出一个新的链表
     */
    class MySolution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummyHead = new ListNode();
            ListNode curr = dummyHead;

            while (hasElements(lists)) {
                curr.next = getAndRemoveMin(lists);
                curr = curr.next;
            }
            return dummyHead.next;

        }

        public ListNode getAndRemoveMin(ListNode[] lists) {
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val <= min.val) {
                        minIndex = i;
                        min = lists[i];
                    }
                }
            }
            lists[minIndex] = min.next;
            min.next = null;
            return min;
        }

        public Boolean hasElements(ListNode[] lists) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    return true;
                }
            }
            return false;
        }
    }

}
