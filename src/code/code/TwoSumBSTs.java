package code.code;

/**
 * @author duson
 * 给出两棵二叉搜索树，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。
 * <p>
 * 如果可以找到返回 True，否则返回 False。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [2,1,4], root2 = [1,0,3], target = 5
 * 输出：true
 * 解释：2 加 3 和为 5 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 每棵树上最多有 5000 个节点。
 * -10^9 <= target, node.val <= 10^9
 * 通过次数1,352提交次数2,284
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-bsts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumBSTs {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean find(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        } else if (root.val < value) {
            return find(root.right, value);
        } else {
            return find(root.left, value);
        }
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) {
            return false;
        }
        return find(root2, target - root1.val)
                || twoSumBSTs(root1.left, root2, target)
                || twoSumBSTs(root1.right, root2, target);
    }
}
