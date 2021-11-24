package com.ruanxinxin.mvc01.algorithm;

public class MergeTwoList {

    static ListNode solution(ListNode node1, ListNode node2) {

        ListNode head = new ListNode(-1);
        ListNode prev = head;

        while (node1 != null && node2 != null) {

            if (node1.val < node2.val) {
                prev.next = node1;
                node1 = node1.next;
            } else {
                prev.next = node2;
                node2 = node2.next;
            }
            prev = prev.next;
        }

        prev.next = node1 == null ? node2 : node1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node4;
        node4.next = node5;
        node5.next = node7;

        node2.next = node3;
        node3.next = node6;

        ListNode result=solution(node1,node2);
        System.out.println(result);

    }

}
