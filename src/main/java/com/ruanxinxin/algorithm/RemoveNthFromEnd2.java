package com.ruanxinxin.algorithm;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 */
public class RemoveNthFromEnd2 {

    static ListNode solution(ListNode origin, int indexFromEnd) {
        ListNode dummy=new ListNode(0);
        dummy.next=origin;
        ListNode left=dummy;
        ListNode right=dummy;
        for(int i=0;i<indexFromEnd;i++){
            right=right.next;
        }
        while (right.next!=null){
            left=left.next;
            right=right.next;
        }
        return left.next;

    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode result = solution(node1, 1);
        System.out.println(result.val);

    }
}

