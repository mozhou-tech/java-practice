package com.java.practice.leecode;

import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jerrylau
 */
public class addTwoNumbers2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    static class Solution {
        static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyNode = new ListNode(0), curr, q, p;
            // 是否进位
            int carry = 0, sum = 0;
            q = l1;
            p = l2;
            curr = dummyNode; // 存放计算结果
            while (q != null || p != null) {
                sum = carry + (q == null ? 0 : q.val) + (p == null ? 0 : p.val);
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (q != null) {
                    q = q.next;
                }
                if (p != null) {
                    p = p.next;
                }
            }
            if (carry > 0) {
                curr.next = new ListNode(1);
            }
            return dummyNode.next;
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        // 打印结果
        ListNode result = Solution.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
