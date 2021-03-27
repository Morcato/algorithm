package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *
 *  Q61_旋转链表
 *
 *  给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *  
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 *
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 *
 *  @author shenzixing
 *  @since 2021-03-27
 */
public class Q61 {

    /**
     * 我的解法:
     * 1.先计算链表长度
     * 2.使用k对length取模算出移动的长度
     * 3.旋转连表
     */
    class MySolution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int length = getLength(head);
            int move = k % length;
            int index = length - move;
            ListNode curr = head;
            ListNode tail = new ListNode();
            ListNode core = new ListNode();
            while (curr != null) {
                index--;
                if (index == 0) {
                    core = curr;
                }
                tail = curr;
                curr = curr.next;
            }
            tail.next = head;
            ListNode newHead = core.next;
            core.next = null;
            return newHead;

        }

        public int getLength(ListNode head) {
            int length = 0;
            ListNode curr = head;
            while (curr != null) {
                length++;
                curr = curr.next;
            }
            return length;
        }
    }

}
