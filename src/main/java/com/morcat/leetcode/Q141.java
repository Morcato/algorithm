package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *  Q141_环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 *  @author shenzixing
 *  @since 2021-01-06
 */
public class Q141 {

    /**
     * 解题思路:使用快慢指针.
     * 快指针移动速度是慢指针的2倍，那么当链表中有环时，则快指针会在环中与慢指针相遇。
     */

    /**
     * 我的快慢指针解题思路--快指针每次循环走一步,慢指针两次循环走一步.
     * 实现较为复杂
     */
    public boolean hasCycle_2Point_MySolution(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        int flag = 1;
        while (fastNode != null) {
            if (flag % 2 == 0) {
                slowNode = slowNode.next;
            }
            flag = flag + 1;
            fastNode = fastNode.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;

    }

    /**
     * 优秀的解题方式
     * 快指针步长两步,慢指针步长一步
     */
    public boolean hasCycle_2Point_Excellent(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (fastNode != slowNode) {
            if (fastNode == null || fastNode.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return true;
    }

}
