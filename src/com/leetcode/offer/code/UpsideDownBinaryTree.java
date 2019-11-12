package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。返回新的根。
 * <p>
 * 例子:
 * <p>
 * 输入: [1,2,3,4,5]
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 输出: 返回二叉树的根 [4,5,2,#,#,3,1]
 * <p>
 * 4
 * / \
 * 5   2
 * / \
 * 3   1
 * 说明:
 * <p>
 * 对 [4,5,2,#,#,3,1] 感到困惑? 下面详细介绍请查看 二叉树是如何被序列化的。
 * <p>
 * 二叉树的序列化遵循层次遍历规则，当没有节点存在时，'#' 表示路径终止符。
 * <p>
 * 这里有一个例子:
 * <p>
 * 1
 * / \
 * 2   3
 * /
 * 4
 * \
 * 5
 * 上面的二叉树则被序列化为 [1,2,3,#,#,4,#,#,5].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-upside-down
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UpsideDownBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return helper(null, root);
    }

    public TreeNode helper(TreeNode parent, TreeNode node) {
        if (node == null) {
            return parent;
        }
        TreeNode ret = helper(node, node.left);
        if (parent != null) {
            node.left = parent.right;
        } else {
            node.left = null;
        }
        node.right = parent;
        return ret;
    }

    public TreeNode upsideDownBinaryTree2(TreeNode root) {
        TreeNode parent = null, parentRight = null;
        while (root != null) {
            TreeNode rootLeft = root.left;
            root.left = parentRight;
            parentRight = root.right;
            root.right = parent;
            parent = root;
            root = rootLeft;
        }
        return parent;
    }
}
