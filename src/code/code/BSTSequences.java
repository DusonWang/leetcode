package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * �������ұ���һ�����飬ͨ�����Ͻ����е�Ԫ�ز������п����𲽵�����һ�ö���������������һ���ɲ�ͬ�ڵ���ɵĶ�������������п������ɴ��������顣
 * <p>
 * ʾ��:
 * �������¶�����
 * <p>
 * 2
 * / \
 * 1   3
 * ����:
 * <p>
 * [
 * [2,1,3],
 * [2,3,1]
 * ]
 * ͨ������1,212�ύ����2,749
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/bst-sequences-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
