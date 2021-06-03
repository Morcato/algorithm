package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 * Q92_反转链表2
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 *  @author shenzixing
 *  @since 2021-01-14
 */
public class Q92 {

    /**
     * TODO 官方解法,待完善
     * 我的解法,代码写的很复杂
     * 思路:一次遍历,获取m,n的链表节点.之后反转m和n的节点再拼接.
     */
    public ListNode reverseBetween_MySolution(ListNode head, int m, int n) {

        ListNode preM = null;
        ListNode nodeM = null;
        ListNode afterN = null;
        ListNode nodeN = null;
        int count = 1;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr.next != null) {
            if (count == m) {
                preM = curr;
                nodeM = curr.next;
            } else if (count == n) {
                nodeN = curr.next;
                afterN = curr.next.next;
            }
            count++;
            curr = curr.next;
        }
        if (nodeN != null) {
            nodeN.next = null;
            ListNode reverseNode = null;
            ListNode curr2 = nodeM;
            while (curr2 != null) {
                ListNode temp = curr2;
                curr2 = curr2.next;
                temp.next = reverseNode;
                reverseNode = temp;
            }
            nodeM.next = afterN;
            preM.next = nodeN;
        }
        return dummyHead.next;
    }

    /**
     * 美团面试中出现原题的解法
     */
    class MeiTuanSolution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode curr = head;
            ListNode pre = dummy;
            ListNode mNode = null;
            ListNode preM = null;
            ListNode nNode = null;
            ListNode nextN = null;
            while (curr != null) {
                m--;
                n--;
                if (m <= 0 && mNode == null) {
                    mNode = curr;
                    preM = pre;
                }
                if (n <= 0 && nNode == null) {
                    nNode = curr;
                    nextN = curr.next;
                }
                pre = pre.next;
                curr = curr.next;
            }
            nNode.next = null;
            preM.next = reverse(mNode);
            mNode.next = nextN;
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
