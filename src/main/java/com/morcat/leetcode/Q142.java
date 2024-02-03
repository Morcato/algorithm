package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 * Q142_环形链表 II
 * <p>
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 *
 * @author shenzixing
 * @date 2024/2/3
 */
public class Q142 {

    /**
     * 我的解法:参考Q141的快慢指针法.但是改成了迭代的方式从头节点开始遍历,然后头结点之后开始快慢指针,如果快指针找到了头节点那么直接返回头节点,如果没找到那么久头节点往后开始遍历.
     * (PS:官方算法用了数学公式,效率更高但是太烧脑了,我就不用了)
     */
    public ListNode detectCycle_MySolution(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode result = head;

        ListNode slowIndex = head.next;
        ListNode fastIndex = head.next;
        int num = 0;


        while (slowIndex != null && fastIndex != null) {
            if (num % 2 == 1) {
                slowIndex = slowIndex.next;
            }
            fastIndex = fastIndex.next;

            if (fastIndex == result) {
                return result;
            }
            if (fastIndex == slowIndex) {
                result = result.next;
                slowIndex = result.next;
                fastIndex = result.next;
                num = 0;
                continue;
            }
            num++;
        }

        return null;

    }
}

