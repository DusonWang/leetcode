package com.leetcode.offer.code;

/**
 * 任务调度优化是计算机性能优化的关键任务之一。在任务众多时，不同的调度策略可能会得到不同的总体执行时间，因此寻求一个最优的调度方案是非常有必要的。
 * <p>
 * 通常任务之间是存在依赖关系的，即对于某个任务，你需要先完成他的前导任务（如果非空），才能开始执行该任务。我们保证任务的依赖关系是一棵二叉树，其中 root 为根任务，root.left 和 root.right 为他的两个前导任务（可能为空），root.val 为其自身的执行时间。
 * <p>
 * 在一个 CPU 核执行某个任务时，我们可以在任何时刻暂停当前任务的执行，并保留当前执行进度。在下次继续执行该任务时，会从之前停留的进度开始继续执行。暂停的时间可以不是整数。
 * <p>
 * 现在，系统有两个 CPU 核，即我们可以同时执行两个任务，但是同一个任务不能同时在两个核上执行。给定这颗任务树，请求出所有任务执行完毕的最小时间。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [47, 74, 31]
 * <p>
 * 输出：121
 * <p>
 * 解释：根节点的左右节点可以并行执行31分钟，剩下的43+47分钟只能串行执行，因此总体执行时间是121分钟。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [15, 21, null, 24, null, 27, 26]
 * <p>
 * 输出：87
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,3,2,null,null,4,4]
 * <p>
 * 输出：7.5
 * <p>
 * 限制：
 * <p>
 * 1 <= 节点数量 <= 1000
 * 1 <= 单节点执行时间 <= 1000
 * 通过次数595提交次数1,210
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-ren-wu-diao-du
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimalExecTime {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public double minimalExecTime(TreeNode root) {
        double[] res = execTime(root, 2);
        return res[0];
    }

    private double[] execTime(TreeNode node, int n) {
        if (node == null) {
            return new double[]{0.0d, 0.0d};
        }
        double[] leftTime = execTime(node.left, n);
        double[] rightTime = execTime(node.right, n);
        double sum = leftTime[1] + rightTime[1];
        double minTime = Math.max(Math.max(leftTime[0], rightTime[0]), sum / n) + node.val;
        return new double[]{minTime, sum + node.val};
    }
}
