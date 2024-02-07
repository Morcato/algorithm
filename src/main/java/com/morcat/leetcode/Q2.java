package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *
 *  Q2_两数相加
 *
 *  给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *  @author shenzixing
 *  @since 2021-02-13
 */
public class Q2 {

    /**
     * 从链表头依次相加,十位进1
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n = 0;
        ListNode dummy = new ListNode();
        ListNode index = dummy;

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1 != null || curr2 != null) {
            int curr1Val = 0;
            int curr2Val = 0;
            if (curr1 != null) {
                curr1Val = curr1.val;
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                curr2Val = curr2.val;
                curr2 = curr2.next;
            }


            int val = curr1Val + curr2Val + n;
            n = val / 10;
            int mod = val % 10;
            index.next = new ListNode(mod);
            index = index.next;

        }
        if (n == 1) {
            index.next = new ListNode(1);
        }
        return dummy.next;
    }

    /**
     * 更新于2024.2.7
     */
    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode indexRes = result;

        ListNode index1 = l1;
        ListNode index2 = l2;

        int temp = 0;

        while(index1 != null || index2 != null){
            int num1;
            int num2;
            if(index1 == null){
                num1 = 0;
                num2 = index2.val;
                index2 = index2.next;
            }else if(index2 == null){
                num2 = 0;
                num1 = index1.val;
                index1 = index1.next;
            }else{
                num1 = index1.val;
                num2 = index2.val;
                index1 = index1.next;
                index2 = index2.next;
            }

            int sum = num1 + num2 + temp;
            int val = sum % 10;
            temp = sum/10;

            indexRes.next = new ListNode(val);
            indexRes = indexRes.next;

        }
        if(temp == 1){
            indexRes.next = new ListNode(1);
        }

        return result.next;

    }

}
