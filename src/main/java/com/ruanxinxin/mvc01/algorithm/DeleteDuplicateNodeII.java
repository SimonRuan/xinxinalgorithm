package com.ruanxinxin.mvc01.algorithm;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class DeleteDuplicateNodeII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = head;
        while (right != null && right.next != null) {
            if (left.next.val != right.next.val) {
                left = left.next;
                right = right.next;
            } else {
                while (right.next != null && left.next.val == right.next.val) {
                    right = right.next;
                }
                left.next = right.next;
                right = right.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;

        ListNode result = new DeleteDuplicateNodeII().deleteDuplicates(node1);
        System.out.println(result);
    }

}
