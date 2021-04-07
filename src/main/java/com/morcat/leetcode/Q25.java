package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *
 *  Q25_K 个一组翻转链表
 *
 *  给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 *
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 *
 * 示例 3：
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 *
 *
 * 示例 4：
 * 输入：head = [1], k = 1
 * 输出：[1]
 *
 *
 *  @author shenzixing
 *  @since 2021-03-15
 */
public class Q25 {

    /**
     * 递归解法
     * 结构化该问题,每次递归返回前k个反转链表,并在链表尾添加之后递归的数据
     */
    class recursionSolution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            if (!hasEnoughLength(head, k)) {
                return head;
            }
            ListNode reverseListNode = null;
            ListNode curr = head;
            int count = 0;
            while (curr != null && count < k) {
                ListNode temp = curr;
                curr = curr.next;
                temp.next = reverseListNode;
                reverseListNode = temp;
                count++;
            }

            head.next = reverseKGroup(curr, k);
            return reverseListNode;
        }

        private Boolean hasEnoughLength(ListNode head, int k) {
            while (k > 0) {
                if (head == null) {
                    return false;
                }
                head = head.next;
                k--;
            }
            return true;
        }
    }


    /**
     * 迭代解法
     */
    class IterationSolution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1, head);
            ListNode curr = head;

            ListNode prepre = dummy;
            ListNode pre = head;
            int count = 0;
            while (curr != null) {
                count++;
                if (k == count) {
                    ListNode temp = curr.next;
                    curr.next = null;
                    ListNode node = reverse(pre);

                    prepre.next = node;
                    pre.next = temp;
                    prepre = pre;
                    pre = temp;
                    curr = temp;
                    count = 0;
                } else {
                    curr = curr.next;
                }
            }
            return dummy.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode result = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode temp = curr;
                curr = curr.next;
                temp.next = result;
                result = temp;
            }
            return result;
        }

    }

}
