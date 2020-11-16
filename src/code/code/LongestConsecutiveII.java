package code.code;

/**
 * @author duson
 * 给定一个二叉树，你需要找出二叉树中最长的连续序列路径的长度。
 * <p>
 * 请注意，该路径可以是递增的或者是递减。例如，[1,2,3,4] 和 [4,3,2,1] 都被认为是合法的，而路径 [1,2,4,3] 则不合法。另一方面，路径可以是 子-父-子 顺序，并不一定是 父-子 顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * 输出: 2
 * 解释: 最长的连续路径是 [1, 2] 或者 [2, 1]。
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: 3
 * 解释: 最长的连续路径是 [1, 2, 3] 或者 [3, 2, 1]。
 *  
 * <p>
 * 注意: 树上所有节点的值都在 [-1e7, 1e7] 范围内。
 * <p>
 * 通过次数341提交次数710
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutiveII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private int maxVal = 0;

    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxVal;
    }

    private int[] longestPath(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1) {
                dcr = l[1] + 1;
            } else if (root.val == root.left.val - 1) {
                inr = l[0] + 1;
            }
        }
        if (root.right != null) {
            int[] r = longestPath(root.right);
            if (root.val == root.right.val + 1) {
                dcr = Math.max(dcr, r[1] + 1);
            } else if (root.val == root.right.val - 1) {
                inr = Math.max(inr, r[0] + 1);
            }
        }
        maxVal = Math.max(maxVal, dcr + inr - 1);
        return new int[]{inr, dcr};
    }
}
