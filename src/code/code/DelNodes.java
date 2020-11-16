package code.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author duson
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 *
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 *
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 *
 *
 * 提示：
 *
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 * 通过次数2,266提交次数3,985
 * 在真实的面试中遇到过这道题？
 */
public class DelNodes {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Set<Integer> toDeleteSet;
    private List<TreeNode> res;

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        toDeleteSet = new HashSet<>();
        res = new ArrayList<>();
        for (int i : toDelete) {
            toDeleteSet.add(i);
        }
        helper(root, true);
        return res;
    }

    private TreeNode helper(TreeNode node, boolean isRoot) {
        if (node == null) {
            return null;
        }
        boolean deleted = toDeleteSet.contains(node.val);
        if (isRoot && !deleted) {
            res.add(node);
        }
        node.left = helper(node.left, deleted);
        node.right = helper(node.right, deleted);
        return deleted ? null : node;
    }
}
