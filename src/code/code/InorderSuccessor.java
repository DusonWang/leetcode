package code.code;

/**
 * @author duson
 * 给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。
 * <p>
 * 结点 p 的后继是值比 p.val 大的结点中键值最小的结点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [2,1,3], p = 1
 * 输出: 2
 * 解析: 这里 1 的顺序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * 输出: null
 * 解析: 因为给出的结点没有顺序后继，所以答案就返回 null 了。
 *  
 * <p>
 * 注意:
 * <p>
 * 假如给出的结点在该树中没有顺序后继的话，请返回 null
 * 我们保证树中每个结点的值是唯一的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/inorder-successor-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InorderSuccessor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        List<TreeNode> res = new ArrayList<>();
//        back(root, res);
//        final int len = res.size();
//        for (int i = 0; i < res.size(); i++) {
//            if (res.get(i) == p) {
//                if (i + 1 < len) {
//                    return res.get(i + 1);
//                }
//            }
//        }
//        return null;
//    }
//
//    private void back(TreeNode root, List<TreeNode> res) {
//        if (root == null) {
//            return;
//        }
//        back(root.left, res);
//        res.add(root);
//        back(root.right, res);
//    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == root) {
            TreeNode next = p.right;
            while (next != null && next.left != null) {
                next = next.left;
            }
            return next;
        } else if (p.val < root.val) {
            TreeNode result = inorderSuccessor(root.left, p);
            return result == null ? root : result;
        }
        return inorderSuccessor(root.right, p);
    }
}
