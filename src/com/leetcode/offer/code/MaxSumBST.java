package com.leetcode.offer.code;

/**
 * ����һ����?root?Ϊ����?������?�����㷵�� ����?������������������ֵ�͡�
 * <p>
 * �����������Ķ������£�
 * <p>
 * ����ڵ���������еļ�ֵ��?С��?�˽ڵ�ļ�ֵ��
 * ����ڵ���������еļ�ֵ�� ����?�˽ڵ�ļ�ֵ��
 * ����ڵ�������������������Ƕ�����������
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * �����20
 * ���ͣ���ֵΪ 3 �������Ǻ����Ķ�����������
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺root = [4,3,null,1,2]
 * �����2
 * ���ͣ���ֵΪ 2 �ĵ��ڵ������Ǻ����Ķ�����������
 * ʾ�� 3��
 * <p>
 * ���룺root = [-4,-2,-5]
 * �����0
 * ���ͣ����нڵ��ֵ��Ϊ�����������Ķ���������Ϊ�ա�
 * ʾ�� 4��
 * <p>
 * ���룺root = [2,1,3]
 * �����6
 * ʾ�� 5��
 * <p>
 * ���룺root = [5,4,8,3,null,6,3]
 * �����7
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * ÿ���������?40000?���ڵ㡣
 * ÿ���ڵ�ļ�ֵ��?[-4 * 10^4?, 4 * 10^4] ֮�䡣
 * ͨ������1,595�ύ����3,725
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxSumBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            maxSum = (int) Math.max(root.val, maxSum);
            return root.val;
        }
        int right = dfs(root.right);
        int left = dfs(root.left);

        if (right == Integer.MAX_VALUE || left == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (root.right != null && root.right.val <= root.val) {
            return Integer.MAX_VALUE;
        }
        if (root.left != null && root.left.val >= root.val) {
            return Integer.MAX_VALUE;
        }
        int y = root.val + left + right;
        maxSum = Math.max(maxSum, y);
        return y;
    }
}
