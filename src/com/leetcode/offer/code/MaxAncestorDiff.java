package com.leetcode.offer.code;

/**
 * @author duson
 * 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * <p>
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 2 到 5000 之间。
 * 每个节点的值介于 0 到 100000 之间。
 * 通过次数2,547提交次数4,486
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAncestorDiff {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int mn, int mx) {
        if (root == null) {
            return mx - mn;
        }
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
    }
}
