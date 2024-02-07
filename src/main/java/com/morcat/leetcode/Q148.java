package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * @author shenzixing
 * @date 2024/2/7
 */
public class Q148 {

    /**
     * 我的解题思路: 遍历整个链表,然后通过冒泡排序将整个链表变为升序
     * <p>
     * 耗时长,不优雅
     */
    public static class Bubbling {
        public ListNode sortList(ListNode head) {
            ListNode dummyHead = new ListNode(0, head);
            ListNode tail = dummyHead.next;

            while (tail != null) {

                ListNode node = tail.next;
                if (node == null) {
                    break;
                }
                if (node.val >= tail.val) {
                    tail = tail.next;
                    continue;
                } else {
                    tail.next = node.next;
                    node.next = null;

                    ListNode fast = dummyHead.next;
                    ListNode slow = dummyHead;
                    while (fast != null) {
                        if (node.val >= fast.val) {
                            fast = fast.next;
                            slow = slow.next;
                        } else {
                            slow.next = node;
                            node.next = fast;
                            break;
                        }
                    }
                }
            }
            return dummyHead.next;
        }
    }

    /**
     * 参考官方提示的 归并排序法(递归):
     * <p>
     * 1.找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，快指针每次移动 2 步，慢指针每次移动 1 步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
     * <p>
     * 2.对两个子链表分别排序。
     * <p>
     * 3. 将两个排序后的子链表合并，得到完整的排序后的链表。可以使用「21. 合并两个有序链表」的做法，将两个有序的子链表进行合并。
     */
    public static class Merge {
        public ListNode sortList(ListNode head) {
            return sort(head);
        }

        private ListNode sort(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode right = slow.next;
            slow.next = null;

            return merge(sort(head), sort(right));

        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummyHead = new ListNode();
            ListNode indexResult = dummyHead;
            ListNode indexLeft = left;
            ListNode indexRight = right;
            while (indexLeft != null && indexRight != null) {
                if (indexLeft.val < indexRight.val) {
                    indexResult.next = indexLeft;
                    indexResult = indexResult.next;
                    indexLeft = indexLeft.next;
                } else {
                    indexResult.next = indexRight;
                    indexResult = indexResult.next;
                    indexRight = indexRight.next;
                }
            }
            if (indexLeft != null) {
                indexResult.next = indexLeft;
            }
            if (indexRight != null) {
                indexResult.next = indexRight;
            }
            return dummyHead.next;
        }

    }
}
