package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *  Q206_反转链表
 *
 *  反转一个单链表
 *
 *  @author shenzixing
 *  @since 2021-01-07
 */
public class Q206 {

    /**
     * 迭代法
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode result = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode temp = cur;
                cur = cur.next;
                temp.next = result;
                result = temp;
            }
            return result;
        }
    }

    /**
     * 递归法
     * 参考:https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/
     */
    class RecursionSolution {
        public ListNode reverseList(ListNode head) {
            if(head== null || head.next == null){
                return head;
            }
            ListNode result = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return result;
        }
    }

}
