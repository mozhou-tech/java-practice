package com.java.practice.leecode;

/**
 * K个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jerrylau
 */
public class ReverseNodesInKGroup25 {
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
                    ", next=" + next +
                    '}';
        }
    }

    static class Solution {
        static ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0), curr;
            curr = dummy;
            while (head != null) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            }
            return dummy.next;
        }
    }


    public static void main(String[] args) {
        ListNode in = new ListNode(1);
        in.next = new ListNode(2);
        in.next.next = new ListNode(3);
        in.next.next.next = new ListNode(4);
        in.next.next.next.next = new ListNode(5);
        ListNode ou = Solution.reverseKGroup(in, 2);

        while (ou != null) {
            System.out.println(ou.val);
            ou = ou.next;
        }
    }
}
