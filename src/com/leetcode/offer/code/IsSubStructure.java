package com.leetcode.offer.code;

/**
 * @author duson
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ��(Լ��������������һ�������ӽṹ)
 * <p>
 * B��A���ӽṹ�� �� A���г��ֺ�B��ͬ�Ľṹ�ͽڵ�ֵ��
 * <p>
 * ����:
 * �������� A:
 * <p>
 * ? ? ?3
 * ? ? / \
 * ? ?4 ? 5
 * ? / \
 * ?1 ? 2
 * �������� B��
 * <p>
 * ? ?4?
 * ? /
 * ?1
 * ���� true����Ϊ B �� A ��һ������ӵ����ͬ�Ľṹ�ͽڵ�ֵ��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺A = [1,2,3], B = [3,1]
 * �����false
 * ʾ�� 2��
 * <p>
 * ���룺A = [3,4,5,1,2], B = [4,1]
 * �����true
 * ���ƣ�
 * <p>
 * 0 <= �ڵ���� <= 10000
 * <p>
 * ͨ������15,658�ύ����33,752
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsSubStructure {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }
        return treeEquals(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }

    private boolean treeEquals(TreeNode a, TreeNode b) {
        if (null == b) {
            return true;
        }
        if (null == a) {
            return false;
        }
        return a.val == b.val && treeEquals(a.left, b.left) && treeEquals(a.right, b.right);
    }
}
