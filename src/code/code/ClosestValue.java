package code.code;

/**
 * @author duson
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 *
 * 注意：
 *
 * 给定的目标值 target 是一个浮点数
 * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 * 示例：
 *
 * 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closest-binary-search-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClosestValue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int closestValue(TreeNode root, double target) {
        if (target > root.val) {
            if (root.right == null) {
                return root.val;
            }
            int right = closestValue(root.right, target);
            return Math.abs(target - right) > Math.abs(target - root.val) ? root.val : right;
        } else {
            if (root.left == null) {
                return root.val;
            }
            int left = closestValue(root.left, target);
            return Math.abs(left - target) > Math.abs(target - root.val) ? root.val : left;
        }
    }
}
