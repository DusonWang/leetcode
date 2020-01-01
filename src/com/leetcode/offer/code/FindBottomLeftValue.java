package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出:
 * 1
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * 输出:
 * 7
 *  
 * <p>
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindBottomLeftValue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int ans = 0, h = 0;

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }

    private void findBottomLeftValue(TreeNode root, int depth) {
        if (h < depth) {
            ans = root.val;
            h = depth;
        }
        if (root.left != null) {
            findBottomLeftValue(root.left, depth + 1);
        }
        if (root.right != null) {
            findBottomLeftValue(root.right, depth + 1);
        }
    }
}
