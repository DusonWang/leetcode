package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 您需要在二叉树的每一行中找到最大的值。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * 输出: [1, 3, 9]
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestValues {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        dfs(0, list, root);
        return list;
    }

    private void dfs(int level, List<Integer> list, TreeNode node) {
        if (level == list.size()) {
            list.add(level, node.val);
        }
        list.set(level, Math.max(list.get(level), node.val));
        if (node.left != null) {
            dfs(level + 1, list, node.left);
        }
        if (node.right != null) {
            dfs(level + 1, list, node.right);
        }
    }
}
