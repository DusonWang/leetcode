package code.code;

/**
 * @author duson
 * 给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 * <p>
 * 回想一下：
 * <p>
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3,4]
 * 输出：[4]
 * 示例 3：
 * <p>
 * 输入：root = [1,2,3,4,5]
 * 输出：[2,4,5]
 *  
 * <p>
 * 提示：
 * <p>
 * 给你的树中将有 1 到 1000 个节点。
 * 树中每个节点的值都在 1 到 1000 之间。
 * 通过次数1,786提交次数2,803
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LcaDeepestLeaves {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) {
            return root;
        } else if (left > right) {
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return 1 + Math.max(left, right);
    }
}
