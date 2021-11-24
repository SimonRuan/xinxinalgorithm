package com.ruanxinxin.mvc01.algorithm;

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
 */
public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int val;
        int borrow = 0;
        // borrow>0 一定不能忘了！！！！
        while (l1 != null || l2 != null || borrow > 0) {
            int total = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + borrow;
            val = total % 10;
            borrow = total / 10;
            ListNode node = new ListNode(val);
            head.next = node;
            head = node;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }

}
