package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 *  @author shenzixing
 *  @since 2021-01-08
 */
public class Q83 {


    /**
     * 我的解法,用了双指针
     */
    public ListNode deleteDuplicates_MySolution(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode preIndex = head;
        ListNode nextIndex = head.next;
        while (nextIndex != null) {
            if (preIndex.val == nextIndex.val) {
                preIndex.next = preIndex.next.next;
                nextIndex = nextIndex.next;
            } else {
                nextIndex = nextIndex.next;
                preIndex = preIndex.next;
            }
        }
        return head;
    }

    /**
     * 优秀的解法,单指针即可解决
     */
    public ListNode deleteDuplicates_Excellent(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


}
