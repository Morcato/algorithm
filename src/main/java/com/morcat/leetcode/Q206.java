package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *  Q169_多数元素
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

}
