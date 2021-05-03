package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数 distance 。
 * <p>
 * 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
 * <p>
 * 返回树中 好叶子节点对的数量 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * ?
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4], distance = 3
 * 输出：1
 * 解释：树的叶节点是 3 和 4 ，它们之间的最短路径的长度是 3 。这是唯一的好叶子节点对。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], distance = 3
 * 输出：2
 * 解释：好叶子节点对为 [4,5] 和 [6,7] ，最短路径长度都是 2 。但是叶子节点对 [4,6] 不满足要求，因为它们之间的最短路径长度为 4 。
 * 示例 3：
 * <p>
 * 输入：root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
 * 输出：1
 * 解释：唯一的好叶子节点对是 [2,5] 。
 * 示例 4：
 * <p>
 * 输入：root = [100], distance = 1
 * 输出：0
 * 示例 5：
 * <p>
 * 输入：root = [1,1,1], distance = 2
 * 输出：1
 * ?
 * <p>
 * 提示：
 * <p>
 * tree 的节点数在 [1, 2^10] 范围内。
 * 每个节点的值都在 [1, 100] 之间。
 * 1 <= distance <= 10
 * 通过次数7,488提交次数13,588
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountPairs {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countPairs(TreeNode root, int distance) {
        return traverse(root, distance);
    }

    private int traverse(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }
        int curCount = calculateCurRoot(root, distance);
        int leftCount = traverse(root.left, distance);
        int rightCount = traverse(root.right, distance);
        return curCount + leftCount + rightCount;
    }

    private int calculateCurRoot(TreeNode root, int distance) {
        int count = 0;
        List<Integer> leftDepth = new ArrayList<>();
        List<Integer> rightDepth = new ArrayList<>();
        childrenDepth(root.left, distance, 1, leftDepth);
        childrenDepth(root.right, distance, 1, rightDepth);
        for (int left : leftDepth) {
            for (int right : rightDepth) {
                if (left + right <= distance) {
                    count++;
                }
            }
        }
        return count;

    }

    private void childrenDepth(TreeNode root, int distance, int depth, List<Integer> leaf) {
        if (root == null) {
            return;
        }
        if (depth > distance) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaf.add(depth);
            return;
        }
        childrenDepth(root.left, distance, depth + 1, leaf);
        childrenDepth(root.right, distance, depth + 1, leaf);
    }
}
