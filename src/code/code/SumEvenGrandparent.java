package code.code;

/**
 * @author duson
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * <p>
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumEvenGrandparent {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int evenSum(TreeNode root, boolean addSelf, boolean addChild) {
        if (root == null) {
            return 0;
        }
        int left = evenSum(root.left, addChild, root.val % 2 == 0);
        int right = evenSum(root.right, addChild, root.val % 2 == 0);
        return addSelf ? root.val + left + right : left + right;
    }

    public int sumEvenGrandparent(TreeNode root) {
        return evenSum(root, false, false);
    }
}
