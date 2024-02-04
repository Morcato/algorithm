package com.morcat.leetcode;

import com.morcat.leetcode.structure.ListNode;

/**
 *
 * Q160_相交链表
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * @author shenzixing
 * @date 2024/2/5
 */
public class Q160 {

    /**
     * 如果要实现时间复杂度 O(m + n) 、仅用 O(1) 内存  个人认为应该算是mid级别的难度
     *
     * 实现思想非常巧妙
     *
     * 两个链表长度不一,因此必须要消除长度差才能计算
     *
     * 假设c的长度代表相交的长度,链表A的长度 a+c,链表B的长度 b+c.
     * a+c+b+c=b+c+a+c 那么就可以消除长度差,让两个链表必定在C相遇.
     * 所以当a走到头,就把指针指向headB,b走到头把指针指向headA. 那么就可以在c相遇啦!
     * 如果a和b为null 则代表两个链表不相交.
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode indexA = headA;
            ListNode indexB = headB;

            while(indexA != indexB){
                if(indexA == null){
                    indexA = headB;
                    continue;
                }
                if(indexB == null){
                    indexB = headA;
                    continue;
                }
                indexA = indexA.next;
                indexB = indexB.next;
            }
            return indexA;
        }
    }

}
