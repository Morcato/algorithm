package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *  Q86_分隔链表
 *
 *  给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 *
 *  @author shenzixing
 *  @since 2021-01-11
 */
public class Q86 {

    /**
     * 我的解法,也是官方解法.
     * 类似用双指针
     * 只需维护两个链表 left 和 right 即可，left 链表按顺序存储所有小于 xx 的节点，right 链表按顺序存储所有大于等于 xx 的节点。
     * 遍历完原链表后，我们只要将 left 链表尾节点指向 right链表的头节点即能完成对链表的分隔。
     */
    public ListNode partition_MySolution(ListNode head, int x) {

        ListNode leftNodeDummyHead = new ListNode(-1);
        ListNode leftNodeTail = leftNodeDummyHead;
        ListNode rightNodeDummyHead = new ListNode(-1);
        ListNode rightNodeTail = rightNodeDummyHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val >= x) {
                rightNodeTail.next = curr;
                rightNodeTail = rightNodeTail.next;
            } else {
                leftNodeTail.next = curr;
                leftNodeTail = leftNodeTail.next;
            }
            curr = curr.next;
        }
        rightNodeTail.next = null;
        leftNodeTail.next = rightNodeDummyHead.next;
        return leftNodeDummyHead.next;

    }

}
