package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 案例 1:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * 输出: True
 *  
 * <p>
 * 案例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * 输出: False
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTarget {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        return findRoot(root, root, k);
    }

    private boolean findRoot(TreeNode node, TreeNode root, int k) {
        if (node == null) {
            return false;
        }
        TreeNode node1 = find(root, k - node.val);
        if (node1 != null && node != node1) {
            return true;
        }
        return findRoot(node.left, root, k) || findRoot(node.right, root, k);
    }

    public TreeNode find(TreeNode root, int v) {
        if (root == null) {
            return null;
        }
        if (root.val == v) {
            return root;
        }
        if (root.val < v) {
            return find(root.right, v);
        } else {
            return find(root.left, v);
        }
    }
}
