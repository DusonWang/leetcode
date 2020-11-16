package code.code;

/**
 * @author duson
 * 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）
 * <p>
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
 * <p>
 * 请你删除所有不足节点，并返回生成的二叉树的根。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 * <p>
 * 输出：[1,2,3,4,null,null,7,8,9,null,14]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 * <p>
 * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [5,-6,-6], limit = 0
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的树有 1 到 5000 个节点
 * -10^5 <= node.val <= 10^5
 * -10^9 <= limit <= 10^9
 * <p>
 * <p>
 * 通过次数1,585提交次数3,613
 * 在真实的面试中遇到过这道题？
 */
public class SufficientSubset {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root.val < limit ? null : root;
        }
        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);
        return root.left == root.right ? null : root;
    }
}
