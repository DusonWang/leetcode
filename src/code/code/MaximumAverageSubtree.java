package code.code;

/**
 * @author duson
 * 给你一棵二叉树的根节点 root，找出这棵树的 每一棵 子树的 平均值 中的 最大 值。
 * <p>
 * 子树是树中的任意节点和它的所有后代构成的集合。
 * <p>
 * 树的平均值是树中节点值的总和除以节点数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[5,6,1]
 * 输出：6.00000
 * 解释：
 * 以 value = 5 的节点作为子树的根节点，得到的平均值为 (5 + 6 + 1) / 3 = 4。
 * 以 value = 6 的节点作为子树的根节点，得到的平均值为 6 / 1 = 6。
 * 以 value = 1 的节点作为子树的根节点，得到的平均值为 1 / 1 = 1。
 * 所以答案取最大值 6。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数介于 1 到 5000之间。
 * 每个节点的值介于 0 到 100000 之间。
 * 如果结果与标准答案的误差不超过 10^-5，那么该结果将被视为正确答案。
 * 通过次数743提交次数1,331
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subtree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumAverageSubtree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public double res = 0.0;

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) {
            return res;
        }
        postOrder(root);
        return res;
    }

    public int[] postOrder(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = postOrder(root.left);
        int[] r = postOrder(root.right);
        int sum = l[0] + r[0] + root.val;
        int count = l[1] + r[1] + 1;
        res = Math.max(res, 1.0 * sum / count);
        return new int[]{sum, count};
    }
}
