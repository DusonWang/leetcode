package com.leetcode.offer.code;

/**
 * @author duson
 * ����һ�ø�Ϊ?root?�Ķ����������㷵�ض������кýڵ����Ŀ��
 *
 * ���ýڵ㡹X ����Ϊ���Ӹ����ýڵ� X �������Ľڵ��У�û���κνڵ��ֵ���� X ��ֵ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺root = [3,1,4,3,null,1,5]
 * �����4
 * ���ͣ�ͼ����ɫ�ڵ�Ϊ�ýڵ㡣
 * ���ڵ� (3) ��Զ�Ǹ��ýڵ㡣
 * �ڵ� 4 -> (3,4) ��·���е����ֵ��
 * �ڵ� 5 -> (3,4,5) ��·���е����ֵ��
 * �ڵ� 3 -> (3,1,3) ��·���е����ֵ��
 * ʾ�� 2��
 *
 *
 *
 * ���룺root = [3,3,null,4,2]
 * �����3
 * ���ͣ��ڵ� 2 -> (3, 3, 2) ���Ǻýڵ㣬��Ϊ "3" ������
 * ʾ�� 3��
 *
 * ���룺root = [1]
 * �����1
 * ���ͣ����ڵ��Ǻýڵ㡣
 * ?
 *
 * ��ʾ��
 *
 * �������нڵ���Ŀ��Χ��?[1, 10^5]?��
 * ÿ���ڵ�Ȩֵ�ķ�Χ��?[-10^4, 10^4]?��
 * ͨ������1,908�ύ����2,744
 * ����ʵ������������������⣿
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GoodNodes {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int res = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    private void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            res++;
        }
        dfs(root.left, Math.max(max, root.val));
        dfs(root.right, Math.max(max, root.val));
    }
}
