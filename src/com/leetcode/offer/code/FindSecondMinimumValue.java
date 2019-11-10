package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 * <p>
 * 输入:
 * 2
 * / \
 * 2   2
 * <p>
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSecondMinimumValue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) {
            return -1;
        }
        int l = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;
        int r = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;
        return (l == -1 || r == -1) ? Math.max(l, r) : Math.min(l, r);
    }
}
