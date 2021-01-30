package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *  Q143_重排链表
 *
 *  给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 *  @author shenzixing
 *  @since 2021-01-28
 */
public class Q143 {

    /**
     * 思路:  寻找链表中点 + 链表逆序 + 合并链表
     * 1. 先使用快慢指针的方式,获取前半部分链表与后半部分链表.
     * 2. 反转后半部分链表
     * 3. 遍历前半部分链表与后半部分反转的链表,依次交错插入
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseListNode = reverse(slow.next);
        slow.next = null;

        ListNode curr = head;
        while (curr != null) {

            if (reverseListNode != null) {
                ListNode temp = reverseListNode;
                reverseListNode = reverseListNode.next;

                temp.next = curr.next;
                curr.next = temp;
                curr = curr.next.next;

            } else {
                curr = curr.next;
            }

        }

    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode result = null;
        while (curr != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = result;
            result = temp;
        }
        return result;

    }

}
