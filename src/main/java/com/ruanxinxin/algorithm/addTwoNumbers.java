package com.ruanxinxin.algorithm;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class addTwoNumbers {

    /**
     * 时间复杂度：O(max(m, n))，假设 mm 和 nn 分别表示 l1 和 l2 的长度，上面的算法最多重复max(m,n) 次。
     * <p>
     * 空间复杂度：O(max(m, n))， 新列表的长度最多为 max(m,n)+1
     *
     * @param node1
     * @param node2
     * @return
     */
    static ListNode solution(ListNode node1, ListNode node2) {
        int sum = 0, carry = 0;
        ListNode dummyNode = new ListNode(0);   //哑节点
        ListNode currentNode = new ListNode(0); //每次循环的当前节点
        dummyNode.next = currentNode;
        while (node1 != null || node2 != null) {
            sum = carry;
            if (node1 != null) {
                sum += node1.val;
                node1 = node1.next;
            }
            if (node2 != null) {
                sum += node2.val;
                node2 = node2.next;
            }
            carry = sum / 10;
            currentNode.val = sum % 10;
            currentNode.next = new ListNode(0);
            currentNode = currentNode.next;
        }
        if (carry > 0) {
            currentNode.next = new ListNode(1);
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(3);
        node1.next = node8;
        node8.next = node9;

        ListNode node2 = new ListNode(5);
        ListNode node21 = new ListNode(6);
        ListNode node22 = new ListNode(4);
        node2.next = node21;
        node21.next = node22;

        ListNode result = solution(node1, node2);
        System.out.println(result);

    }


}

class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("" + val);
        ListNode temp = next;
        int i = 0;
        while (temp != null && i < 10) {
            sb.append("->");
            sb.append(temp.val);
            temp = temp.next;
            i++;
        }
        return sb.toString();
    }
}