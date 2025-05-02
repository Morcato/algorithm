package com.morcat.leetcode;

/**
 * 
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
 *
 *  * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * 
 * @author shenzixing
 * @date 2025-05-03
 * 
 * 
 */

public class Q24 {

    /**
     * 
     * 迭代解法
     * 
     */
    public ListNode swapPairs_iteration(ListNode head) {
            ListNode dummyHead = new ListNode(-1,head);
            ListNode curr = head;
            ListNode pre = dummyHead;
    
            ListNode firstNode = null;
            ListNode secondNode = null;
    
            int count = 0;
    
            while(curr != null){
                count++;
                if(count == 2){
                    secondNode = curr;
                    curr = curr.next;
    
                    pre.next = secondNode;
                    secondNode.next = firstNode;
                    pre = firstNode;
                    firstNode.next = curr;
                    count = 0;
                }else{
                    firstNode = curr;
                    curr = curr.next;
                }
    
            }
            return dummyHead.next;
        }

        /**
         * 
         * 递归解法
         * 
         */
        public ListNode swapPairs_recursion(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
    
            ListNode first = head;
            ListNode second = head.next;
           ListNode newHead = second.next;
    
            second.next = first;
            first.next = swapPairs_recursion(newHead);
            return second;
    
        }
    
}
