package code.code;

import java.util.Stack;

/**
 * @author duson
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * 进阶:
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RecoverTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (firstNode == null && pre.val > p.val) {
                firstNode = pre;
            }
            if (firstNode != null && pre.val > p.val) {
                secondNode = p;
            }

            pre = p;
            p = p.right;
        }
        if (firstNode != null) {
            int tmp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = tmp;
        }
    }

    private TreeNode pre = null, t1 = null, t2 = null;

    public void recoverTree2(TreeNode root) {
        helper(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (pre != null && pre.val >= root.val) {
            t2 = root;
            if (t1 == null) {
                t1 = pre;
            } else {
                return;
            }
        }
        pre = root;
        helper(root.right);
    }
}
