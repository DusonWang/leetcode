package code.code;

/**
 * @author duson
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * <p>
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * <p>
 * 请你返回给定树中最长 交错路径 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * 输出：3
 * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
 * 输出：4
 * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 50000 个节点。
 * 每个节点的值在 [1, 100] 之间。
 * 通过次数1,409提交次数3,469
 * 在真实的面试中遇到过这道题？
 */
public class LongestZigZag {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = 0;

    public int longestZigZag(TreeNode root) {
        move(root);
        return max - 1;
    }

    private int[] move(TreeNode curr) {
        if (curr == null) {
            return new int[2];
        }
        int[] l = move(curr.left);
        int[] r = move(curr.right);
        int[] res = {l[1] + 1, r[0] + 1};
        max = Math.max(max, Math.max(res[0], res[1]));
        return res;
    }
}
