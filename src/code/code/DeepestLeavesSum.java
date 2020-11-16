package code.code;

/**
 * @author duson
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *  
 *
 * 提示：
 *
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deepest-leaves-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeepestLeavesSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = -1, ans = 0;

    public int deepestLeavesSum(TreeNode root) {
        dewIt(root, 1);
        return ans;
    }

    private void dewIt(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > max) {
                max = depth;
                ans = root.val;
            } else if (depth == max) {
                ans += root.val;
            }
        } else {
            if (root.left != null) {
                dewIt(root.left, depth + 1);
            }
            if (root.right != null) {
                dewIt(root.right, depth + 1);
            }
        }
    }
}
