package com.ruanxinxin.algorithm;

import com.ruanxinxin.algorithm.dto.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST_98 {

    //解法二：利用BST中序遍历是升序的这个特性
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        //临时变量：遍历出来的值
        Integer prev = null;
        Integer curr = null;

        Deque<Object> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object element = stack.pop();
            if (element instanceof Integer) {
                prev = curr;
                curr = (Integer) element;
                if (prev != null && prev >= curr) {
                    return false;
                }
            } else {
                TreeNode temp = (TreeNode) element;
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                stack.push(temp.val);
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(new IsValidBST_98().isValidBST(root));
    }

    //解法一：递归

//    public boolean isValidBST(TreeNode root) {
//        return helper(root, null, null);
//    }
//
//    boolean helper(TreeNode root, Integer lower, Integer upper) {
//        if (root == null)
//            return false;
//        if (lower != null && root.val <= lower)
//            return false;
//        if (upper != null && root.val >= upper)
//            return false;
//        if (!helper(root.left, lower, root.val))
//            return false;
//        if (!helper(root.right, root.val, upper))
//            return false;
//        return true;
//    }

}
