package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *  Q234_回文链表
 *
 *  请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 *  @author shenzixing
 *  @since 2021-01-15
 */
public class Q234 {

    /**
     * 我的解法
     * 思路: 先获取链表长度,然后头和尾进行依次进行比较是否相等.
     */
    private class MySolution {
        public boolean isPalindrome(ListNode head) {
            int count = getLength(head);
            int i = 0;
            int j = count - 1;
            while (i <= j) {
                if (getValByPostion(head, i) != getValByPostion(head, j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }


        private int getLength(ListNode head) {
            ListNode curr = head;
            int count = 0;
            while (curr != null) {
                count++;
                curr = curr.next;
            }
            return count;
        }

        private int getValByPostion(ListNode head, int position) {
            ListNode result = new ListNode(-1);
            result.next = head;
            for (int i = 0; i <= position; i++) {
                result = result.next;
            }
            return result.val;
        }
    }

    /**
     * 优秀解法:快慢指针
     * 思路: ：慢指针一次走一步，快指针一次走两步，快慢指针同时出发。当快指针移动到链表的末尾时，
     *        慢指针恰好到链表的中间。通过慢指针将链表分为两部分。
     *
     * 若链表有奇数个节点，则中间的节点应该看作是后半部分。
     * 比较连个链表的值,如果有不一样则不是回文链表.
     */
    private class FastSlowPoint {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            ListNode slowIndex = head;
            ListNode fastIndex = head;
            while (fastIndex.next != null && fastIndex.next.next != null) {
                slowIndex = slowIndex.next;
                fastIndex = fastIndex.next.next;
            }
            if (fastIndex.next != null && fastIndex.next.next == null) {
                slowIndex = slowIndex.next;
                fastIndex = fastIndex.next;
            }
            reverse(slowIndex);

            ListNode curr1 = head;
            ListNode curr2 = fastIndex;
            while (curr1 != slowIndex) {
                if (curr1.val != curr2.val) {
                    return false;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            return true;

        }

        private void reverse(ListNode head) {
            ListNode result = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode temp = curr;
                curr = curr.next;
                temp.next = result;
                result = temp;
            }
        }
    }

    /**
     * 2024.2.6更新
     * 新做这道题,比上面的快慢指针略逊一筹.
     * 思路:先遍历一遍算长度,再遍历半个链表取一半的链表进行反转. 再将两个链表进行比较
     */
   private class ReverseSolution {
        public boolean isPalindrome(ListNode head) {
            int length = getLength(head);
            if(length <=1){
                return true;
            }

            boolean isEven = length % 2 == 0;
            int half = length /2;

            ListNode index = head;
            ListNode result = null;

            int count = 0;

            // 反转半个链表
            while(index != null){
                count++;
                if(count <= half){
                    ListNode temp = index.next;
                    index.next = result;
                    result =index;
                    index = temp;
                }else{
                    break;
                }
            }

            if(isEven){
                return isEqual(result,index);
            }else{
                return isEqual(result,index.next);
            }

        }

        private boolean isEqual(ListNode nodeA,ListNode nodeB){
            ListNode indexA = nodeA;
            ListNode indexB = nodeB;
            while(indexA != null && indexB != null){
                if(indexA.val == indexB.val){
                    indexA = indexA.next;
                    indexB = indexB.next;
                }else{
                    return false;
                }
            }
            return true;
        }

        private int getLength(ListNode head){
            int num = 0;
            ListNode index = head;
            while(index != null){
                num++;
                index = index.next;
            }
            return num;
        }

    }

}
