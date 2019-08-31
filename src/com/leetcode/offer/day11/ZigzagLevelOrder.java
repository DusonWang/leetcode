package com.leetcode.offer.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigzagLevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        back(root, 0, list);
        return list;
    }

    private void back(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }

        if ((level & 1) == 0) {
            list.get(level).add(node.val);
        } else {
            list.get(level).add(0, node.val);
        }

        if (node.left != null) {
            back(node.left, level + 1, list);
        }
        if (node.right != null) {
            back(node.right, level + 1, list);
        }
    }

}
