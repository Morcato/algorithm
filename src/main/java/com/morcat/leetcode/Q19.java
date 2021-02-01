package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *  Q19_删除链表的倒数第 N 个结点
 *
 *  给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *  @author shenzixing
 *  @since 2021-02-01
 */
public class Q19 {

    /**
     * 思路: 第一次遍历获取长度.第二次遍历找到对应节点并删除.
     */
    class MySolution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            int length = getLength(head);
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            ListNode pre = dummyHead;
            while ((length - n) != 0) {
                length--;
                pre = pre.next;
            }
            pre.next = pre.next.next;
            return dummyHead.next;

        }

        private int getLength(ListNode head) {
            ListNode curr = head;
            int length = 0;
            while (curr != null) {
                length++;
                curr = curr.next;
            }
            return length;

        }

    }

    /**
     * 双指针解法
     *
     * 采取双重遍历肯定是可以解决问题的，但题目要求我们一次遍历解决问题，那我们的思路得发散一下。
     *
     * 我们可以设想假设设定了双指针 p 和 q 的话，当 q 指向末尾的 NULL，p 与 q 之间相隔的元素个数为 n 时，那么删除掉 p 的下一个指针就完成了要求。
     *
     */
    class TwoPoints {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode(0, head);
            ListNode slowIndex = dummyHead;
            ListNode fastIndex = dummyHead;
            while (fastIndex != null) {
                if (n < 0) {
                    slowIndex = slowIndex.next;
                }
                n--;
                fastIndex = fastIndex.next;
            }
            slowIndex.next = slowIndex.next.next;
            return dummyHead.next;

        }

    }

}
