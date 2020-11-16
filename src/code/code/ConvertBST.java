package code.code;

/**
 * @author duson
 * <p>
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * 例如：
 * <p>
 * 输入: 二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            dfs(root, 0);
        }
        return root;
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        int right = dfs(node.right, sum);
        int value = node.val;
        node.val += right;
        sum = right + value;
        return dfs(node.left, sum);
    }

    public int number = 0;

    public TreeNode convertBST2(TreeNode root) {
        if (root != null) {
            convertBST2(root.right);
            root.val = number + root.val;
            number = root.val;
            convertBST2(root.left);
            return root;
        }
        return null;
    }
}
