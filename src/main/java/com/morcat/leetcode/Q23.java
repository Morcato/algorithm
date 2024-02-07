package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * 2024.2.8 重做此题想到的,递归解法更高效!
     *
     * 将K个链表转换成成多组两个链表,将两个链表进行合并,递归处理
     *
     */
    class RecursionSolution {
        public ListNode mergeKLists(ListNode[] lists) {
            List<ListNode> array = Arrays.asList(lists);
            return merge(array);
        }

        private ListNode merge(List<ListNode> lists) {
            if (lists.isEmpty()){
                return null;
            }
            if (lists.size() == 1) {
                return lists.get(0);
            }
            List<ListNode> listA = new ArrayList();
            List<ListNode> listB =new ArrayList();
            for (int i = 0; i < lists.size(); i++) {
                if (i < lists.size() / 2) {
                    listA.add(lists.get(i));
                } else {
                    listB.add(lists.get(i));
                }
            }
            return mergeTwoList(merge(listA), merge(listB));

        }

        private ListNode mergeTwoList(ListNode listA, ListNode listB) {
            ListNode dummyHead = new ListNode();
            ListNode resultIndex = dummyHead;
            ListNode indexA = listA;
            ListNode indexB = listB;

            while (indexA != null && indexB != null) {
                if (indexA.val < indexB.val) {
                    resultIndex.next = indexA;
                    resultIndex = resultIndex.next;
                    indexA = indexA.next;
                } else {
                    resultIndex.next = indexB;
                    resultIndex = resultIndex.next;
                    indexB = indexB.next;
                }
            }
            if (indexA != null) {
                resultIndex.next = indexA;
            }
            if (indexB != null) {
                resultIndex.next = indexB;
            }
            return dummyHead.next;

        }
    }


}
