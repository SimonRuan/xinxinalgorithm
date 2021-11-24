package com.ruanxinxin.algorithm;

import com.ruanxinxin.algorithm.dto.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class InorderTree_94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        inorder(res, root);
        return res;
    }

    void inorder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }


}
