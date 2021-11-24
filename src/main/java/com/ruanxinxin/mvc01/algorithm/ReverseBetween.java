package com.ruanxinxin.mvc01.algorithm;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null || m == n) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //获取第m-1个节点beforeM
        int i = 0;
        ListNode prev = dummy;
        while (i < m - 1) {
            prev = prev.next;
            i++;
        }
        ListNode beforeM = prev;
        ListNode M = beforeM.next;
        ListNode current = M;
        ListNode tempNext = current.next;
        while (m <= n) {
            tempNext = current.next;
            current.next = prev;

            prev = current;
            current = tempNext;

            m++;
        }
        beforeM.next = prev;
        M.next = tempNext;

        return dummy.next;

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

        ListNode result = new ReverseBetween().reverseBetween(node1, 1, 2);
        System.out.println(result);

    }
}
