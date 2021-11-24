package com.ruanxinxin.mvc01.algorithm;

import com.ruanxinxin.mvc01.algorithm.dto.TreeNode;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class RobIII_337 {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}
