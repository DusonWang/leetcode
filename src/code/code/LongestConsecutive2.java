package code.code;

/**
 * @author duson
 * 给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。
 * <p>
 * 该路径，可以是从某个初始结点到树中任意结点，通过「父 - 子」关系连接而产生的任意路径。
 * <p>
 * 这个最长连续的路径，必须从父结点到子结点，反过来是不可以的。
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * <p>
 * 1
 * \
 * 3
 * / \
 * 2   4
 * \
 * 5
 * <p>
 * 输出: 3
 * <p>
 * 解析: 当中，最长连续序列是 3-4-5，所以返回结果为 3
 * 示例 2：
 * <p>
 * 输入:
 * <p>
 * 2
 * \
 * 3
 * /
 * 2
 * /
 * 1
 * <p>
 * 输出: 2
 * <p>
 * 解析: 当中，最长连续序列是 2-3。注意，不是 3-2-1，所以返回 2。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        int ans = depth;
        if (root.left == null && root.right == null) {
            return ans;
        }
        if (root.left != null) {
            if (root.val + 1 == root.left.val) {
                ans = Math.max(ans, dfs(root.left, depth + 1));
            } else {
                ans = Math.max(ans, dfs(root.left, 1));
            }
        }
        if (root.right != null) {
            if (root.val + 1 == root.right.val) {
                ans = Math.max(ans, dfs(root.right, depth + 1));
            } else {
                ans = Math.max(ans, dfs(root.right, 1));
            }
        }
        return ans;
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 1);
    }
}
