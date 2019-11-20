package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 给定一个二叉树，统计该二叉树数值相同的子树个数。
 * <p>
 * 同值子树是指该子树的所有节点都拥有相同的数值。
 * <p>
 * 示例：
 * <p>
 * 输入: root = [5,1,5,5,5,null,5]
 * <p>
 * 5
 * / \
 * 1   5
 * / \   \
 * 5   5   5
 * <p>
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-univalue-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountUnivalSubtrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int count = 0;

    private boolean isValidPart(TreeNode node, int val) {
        if (node == null) {
            return true;
        }

        if (!isValidPart(node.left, node.val) | !isValidPart(node.right, node.val)) {
            return false;
        }
        count++;
        return node.val == val;
    }

    public int countUnivalSubtrees(TreeNode root) {
        isValidPart(root, 0);
        return count;
    }

}
