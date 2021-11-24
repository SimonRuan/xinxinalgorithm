package com.ruanxinxin.mvc01.algorithm;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicateNode {

    public ListNode deleteDuplicates(ListNode head) {
        //特殊场景
        if (head == null || head.next == null) {
            return head;
        }

        //双指针
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            while (right != null && left.val == right.val) {
                right = right.next;
            }

            left.next = right;
            if (right == null) {
                break;
            }
            left = right;
            right = right.next;

        }
        return head;
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

        ListNode result = new DeleteDuplicateNode().deleteDuplicates(node1);
        System.out.println(result);
    }

}
