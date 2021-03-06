package code.code;

/**
 * @author duson
 * 给你一棵二叉搜索树（BST）、它的根结点 root 以及目标值 V。
 * <p>
 * 请将该树按要求拆分为两个子树：其中一个子树结点的值都必须小于等于给定的目标值 V；另一个子树结点的值都必须大于目标值 V；树中并非一定要存在值为 V 的结点。
 * <p>
 * 除此之外，树中大部分结构都需要保留，也就是说原始树中父节点 P 的任意子节点 C，假如拆分后它们仍在同一个子树中，那么结点 P 应仍为 C 的子结点。
 * <p>
 * 你需要返回拆分后两个子树的根结点 TreeNode，顺序随意。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,6,1,3,5,7], V = 2
 * 输出：[[2,1],[4,3,6,null,null,5,7]]
 * 解释：
 * 注意根结点 output[0] 和 output[1] 都是 TreeNode 对象，不是数组。
 * <p>
 * 给定的树 [4,2,6,1,3,5,7] 可化为如下示意图：
 * <p>
 * 4
 * /   \
 * 2      6
 * / \    / \
 * 1   3  5   7
 * <p>
 * 输出的示意图如下：
 * <p>
 * 4
 * /   \
 * 3      6       和    2
 * / \           /
 * 5   7         1
 * 注意：
 * <p>
 * 二叉搜索树节点个数不得超过 50 个
 * 二叉搜索树始终是有效的，并且每个节点的值dku bu xiang t
 * 通过次数631提交次数1,147
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode[] splitBST(TreeNode root, int v) {
        if (root == null) {
            return new TreeNode[]{null, null};
        } else if (root.val <= v) {
            TreeNode[] bns = splitBST(root.right, v);
            root.right = bns[0];
            bns[0] = root;
            return bns;
        } else {
            TreeNode[] bns = splitBST(root.left, v);
            root.left = bns[1];
            bns[1] = root;
            return bns;
        }
    }
}
