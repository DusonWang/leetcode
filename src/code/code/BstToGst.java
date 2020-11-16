package code.code;

/**
 * @author duson
 * 给出二叉 搜索 树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数介于 1 和 100 之间。
 * 每个节点的值介于 0 和 100 之间。
 * 给定的树为二叉搜索树。
 *  
 * <p>
 * 注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/  相同
 * <p>
 * 通过次数6,316提交次数8,708
 * 在真实的面试中遇到过这道题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BstToGst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int pre = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) {
            bstToGst(root.right);
        }
        pre = root.val = pre + root.val;
        if (root.left != null) {
            bstToGst(root.left);
        }
        return root;
    }
}
