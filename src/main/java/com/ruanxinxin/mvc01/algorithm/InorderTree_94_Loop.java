package com.ruanxinxin.mvc01.algorithm;

import com.ruanxinxin.mvc01.algorithm.dto.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历，迭代解法
 */
public class InorderTree_94_Loop {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Deque<Object> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object temp = stack.pop();
            if (temp instanceof Integer) {
                res.add((int) temp);
            } else {
                if (((TreeNode) temp).right != null) {
                    stack.push(((TreeNode) temp).right);
                }
                stack.push(((TreeNode) temp).val);
                if (((TreeNode) temp).left != null) {
                    stack.push(((TreeNode) temp).left);
                }
            }
        }

        return res;
    }


}
