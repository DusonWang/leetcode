package com.leetcode.offer.day52;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AverageOfLevels {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> tmp : lists) {
            if (tmp.size() == 0) {
                continue;
            }
            double sum = 0;
            for (int m : tmp) {
                sum += m;
            }
            list.add(sum / tmp.size());
        }
        return list;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        back(root, 0, list);
        return list;
    }

    private void back(TreeNode node, int level, List<List<Integer>> list) {
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(node.val);

        if (node.left != null) {
            back(node.left, level + 1, list);
        }
        if (node.right != null) {
            back(node.right, level + 1, list);
        }
    }
}
