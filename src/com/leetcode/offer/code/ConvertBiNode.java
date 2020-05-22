package com.leetcode.offer.code;

/**
 * ���������ݽṹTreeNode��������ʾ������������left�ÿգ�rightΪ��һ������ڵ㣩��ʵ��һ���������Ѷ���������ת��Ϊ��������Ҫ��ֵ��˳�򱣳ֲ��䣬ת������Ӧ��ԭַ�ģ�Ҳ������ԭʼ�Ķ�����������ֱ���޸ġ�
 * <p>
 * ����ת����ĵ��������ͷ�ڵ㡣
 * <p>
 * ע�⣺�������ԭ�������Ķ�
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺 [4,2,5,1,3,null,6,0]
 * ����� [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * ��ʾ��
 * <p>
 * �ڵ��������ᳬ�� 100000��
 * ͨ������3,612�ύ����6,148
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/binode-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ConvertBiNode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode convertBiNode(TreeNode root) {
        recur(root);
        return pre;
    }

    public void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        recur(root.left);
        if (head == null) {
            head = root;
            pre = head;
        } else {
            root.left = null;
            head.right = root;
            head = root;
        }
        recur(root.right);
    }
}
