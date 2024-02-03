package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 * Q21_合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author shenzixing
 * @since 2021-01-07
 */
public class Q21 {

    /**
     * 解决思路:
     * 方案一:迭代
     * 我们可以用迭代的方法来实现上述算法。当 l1 和 l2 都不是空链表时，判断 l1 和 l2 哪一个链表的头节点的值更小，
     * 将较小值的节点添加到结果里，当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。
     *
     */

    /**
     * 我的解决方案__迭代法
     */
    public ListNode mergeTwoLists_MySolution(ListNode l1, ListNode l2) {
        ListNode dummyListNode = new ListNode(0);
        ListNode tail = dummyListNode;
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        while (currL1 != null || currL2 != null) {
            if (currL1 == null) {
                tail.next = currL2;
                currL2 = currL2.next;
            } else if (currL2 == null) {
                tail.next = currL1;
                currL1 = currL1.next;
            } else if (currL1.val <= currL2.val) {
                tail.next = currL1;
                currL1 = currL1.next;
            } else if (currL1.val > currL2.val) {
                tail.next = currL2;
                currL2 = currL2.next;
            }
            tail = tail.next;
        }
        return dummyListNode.next;
    }

    /**
     * 优秀的迭代法,省去了我的很多无用代码
     */
    public ListNode mergeTwoLists_Excellent(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    /**
     * 2024.2.3 重温该题,按照优秀迭代法完成! 点赞!
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();

        ListNode index1 = list1;
        ListNode index2 = list2;
        ListNode resultIndex = result;

        while (index1 != null && index2 != null) {
            if (index1.val <= index2.val) {
                resultIndex.next = index1;
                index1 = index1.next;
                resultIndex = resultIndex.next;
            } else {
                resultIndex.next = index2;
                index2 = index2.next;
                resultIndex = resultIndex.next;
            }
        }
        if (index1 != null) {
            resultIndex.next = index1;
        }
        if (index2 != null) {
            resultIndex.next = index2;
        }
        return result.next;
    }

}
