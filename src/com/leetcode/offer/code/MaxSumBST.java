package com.leetcode.offer.code;

/**
 * 给你一棵以?root?为根的?二叉树?，请你返回 任意?二叉搜索子树的最大键值和。
 * <p>
 * 二叉搜索树的定义如下：
 * <p>
 * 任意节点的左子树中的键值都?小于?此节点的键值。
 * 任意节点的右子树中的键值都 大于?此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 * 示例 3：
 * <p>
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 * 示例 4：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：6
 * 示例 5：
 * <p>
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 * ?
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有?40000?个节点。
 * 每个节点的键值在?[-4 * 10^4?, 4 * 10^4] 之间。
 * 通过次数1,595提交次数3,725
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSumBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            maxSum = (int) Math.max(root.val, maxSum);
            return root.val;
        }
        int right = dfs(root.right);
        int left = dfs(root.left);

        if (right == Integer.MAX_VALUE || left == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (root.right != null && root.right.val <= root.val) {
            return Integer.MAX_VALUE;
        }
        if (root.left != null && root.left.val >= root.val) {
            return Integer.MAX_VALUE;
        }
        int y = root.val + left + right;
        maxSum = Math.max(maxSum, y);
        return y;
    }
}
