package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *
 *  Q82_删除排序链表中的重复元素 II
 *
 *  存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 *
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *  
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 *  @author shenzixing
 *  @since 2021-03-25
 */
public class Q82 {

    /**
     * 双指针法
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;

            ListNode curr = head;
            ListNode pre = dummyHead;
            while (curr != null && curr.next != null) {

                if (curr.val == curr.next.val) {
                    while (curr.next != null && curr.val == curr.next.val) {
                        curr = curr.next;
                    }
                    curr = curr.next;
                    pre.next = curr;

                } else {
                    pre = curr;
                    curr = curr.next;
                }
            }
            return dummyHead.next;
        }
    }

}
