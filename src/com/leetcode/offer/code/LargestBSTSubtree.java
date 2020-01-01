package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，其中最大指的是子树节点数最多的。
 * <p>
 * 注意:
 * 子树必须包含其所有后代。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,5,15,1,8,null,7]
 * <p>
 * 10
 * / \
 * 5  15
 * / \   \
 * 1   8   7
 * <p>
 * 输出: 3
 * 解释: 高亮部分为最大的 BST 子树。
 * 返回值 3 在这个样例中为子树大小。
 * 进阶:
 * 你能想出用 O(n) 的时间复杂度解决这个问题吗？
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-bst-subtree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestBSTSubtree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = 0, preVal = Integer.MIN_VALUE;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preVal = Integer.MIN_VALUE;
        if (isBST(root)) {
            res = Math.max(res, getCount(root));
        }
        largestBSTSubtree(root.left);
        largestBSTSubtree(root.right);
        return res;
    }

    private int getCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getCount(root.right) + getCount(root.left) + 1;
    }

    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftFlag = isBST(root.left);
        if (preVal >= root.val) {
            return false;
        }
        preVal = root.val;
        boolean rightFlag = isBST(root.right);
        return leftFlag && rightFlag;
    }
}
