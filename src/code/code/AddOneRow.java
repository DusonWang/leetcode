package code.code;

/**
 * @author duson
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * <p>
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * <p>
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * <p>
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 二叉树如下所示:
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * <p>
 * v = 1
 * <p>
 * d = 2
 * <p>
 * 输出:
 * 4
 * / \
 * 1   1
 * /     \
 * 2       6
 * / \     /
 * 3   1   5
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 二叉树如下所示:
 * 4
 * /
 * 2
 * / \
 * 3   1
 * <p>
 * v = 1
 * <p>
 * d = 3
 * <p>
 * 输出:
 * 4
 * /
 * 2
 * / \
 * 1   1
 * /     \
 * 3       1
 * 注意:
 * <p>
 * 输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。
 * 输入的二叉树至少有一个节点。
 * 通过次数2,894提交次数5,755
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-one-row-to-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddOneRow {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode addOneRow(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        insert(v, t, 1, d);
        return t;
    }

    public void insert(int val, TreeNode node, int depth, int n) {
        if (node == null) {
            return;
        }
        if (depth == n - 1) {
            TreeNode t = node.left;
            node.left = new TreeNode(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        } else {
            insert(val, node.left, depth + 1, n);
            insert(val, node.right, depth + 1, n);
        }
    }
}
