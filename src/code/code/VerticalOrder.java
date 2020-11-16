package code.code;

import java.util.*;

/**
 * @author duson
 * 给定一个二叉树，返回其结点 垂直方向（从上到下，逐列）遍历的值。
 * <p>
 * 如果两个结点在同一行和列，那么顺序则为 从左到右。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [3,9,20,null,null,15,7]
 * <p>
 * 3
 * /\
 * /  \
 * 9   20
 * /\
 * /  \
 * 15   7
 * <p>
 * 输出:
 * <p>
 * [
 * [9],
 * [3,15],
 * [20],
 * [7]
 * ]
 * 示例 2:
 * <p>
 * 输入: [3,9,8,4,0,1,7]
 * <p>
 * 3
 * /\
 * /  \
 * 9    8
 * /\   /\
 * /  \ /  \
 * 4   0 1   7
 * <p>
 * 输出:
 * <p>
 * [
 * [4],
 * [9],
 * [3,0,1],
 * [8],
 * [7]
 * ]
 * 示例 3:
 * <p>
 * 输入: [3,9,8,4,0,1,7,null,null,null,2,5]（注意：0 的右侧子节点为 2，1 的左侧子节点为 5）
 * <p>
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * /\
 * /  \
 * 5   2
 * <p>
 * 输出:
 * <p>
 * [
 * [4],
 * [9,5],
 * [3,0,1],
 * [8,2],
 * [7]
 * ]
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-vertical-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class VerticalOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static class QueueNode {
        int index;
        TreeNode node;

        public QueueNode(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(0, root));
        while (!queue.isEmpty()) {
            QueueNode node = queue.poll();
            List<Integer> list = treeMap.getOrDefault(node.index, new ArrayList<>());
            list.add(node.node.val);
            treeMap.put(node.index, list);
            if (node.node.left != null) {
                queue.offer(new QueueNode(node.index - 1, node.node.left));
            }
            if (node.node.right != null) {
                queue.offer(new QueueNode(node.index + 1, node.node.right));
            }
        }
        return new ArrayList<>(treeMap.values());
    }
}
