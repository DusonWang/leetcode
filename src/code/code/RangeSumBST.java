package code.code;

/**
 * @author duson
 * <p>
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RangeSumBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum;

    public int rangeSumBST(TreeNode root, int l, int r) {
        sum = 0;
        dfs(root, l, r);
        return sum;
    }

    private void dfs(TreeNode root, int l, int r) {
        if (root == null) {
            return;
        }
        if (root.val >= l && root.val <= r) {
            sum += root.val;
        }
        if (root.left != null) {
            dfs(root.left, l, r);
        }
        if (root.right != null) {
            dfs(root.right, l, r);
        }
    }
}
