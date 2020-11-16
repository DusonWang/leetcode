package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉树，输出所有可能生成此树的数组。
 * <p>
 * 示例:
 * 给定如下二叉树
 * <p>
 * 2
 * / \
 * 1   3
 * 返回:
 * <p>
 * [
 * [2,1,3],
 * [2,3,1]
 * ]
 * 通过次数1,212提交次数2,749
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bst-sequences-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BSTSequences {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            return list;
        }
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<TreeNode> next = new ArrayList<>();
        next.add(root);
        ArrayList<Integer> visit = new ArrayList<>();
        visit(next, visit, res);
        if (res.isEmpty()) {
            res.add(new ArrayList<>());
        }
        return res;
    }

    public void visit(ArrayList<TreeNode> cur, ArrayList<Integer> visit, List<List<Integer>> res) {
        if (cur.isEmpty()) {
            res.add(new ArrayList<>(visit));
            return;
        }
        for (int i = 0; i < cur.size(); i++) {
            TreeNode node = cur.remove(i);
            visit.add(node.val);
            if (node.left != null) {
                cur.add(node.left);
            }
            if (node.right != null) {
                cur.add(node.right);
            }
            visit(cur, visit, res);
            visit.remove(visit.size() - 1);
            if (node.left != null) {
                cur.remove(cur.size() - 1);
            }
            if (node.right != null) {
                cur.remove(cur.size() - 1);
            }
            cur.add(i, node);
        }
    }
}
