package com.leetcode.offer.code;

/**
 * ��������Ż��Ǽ���������Ż��Ĺؼ�����֮һ���������ڶ�ʱ����ͬ�ĵ��Ȳ��Կ��ܻ�õ���ͬ������ִ��ʱ�䣬���Ѱ��һ�����ŵĵ��ȷ����Ƿǳ��б�Ҫ�ġ�
 * <p>
 * ͨ������֮���Ǵ���������ϵ�ģ�������ĳ����������Ҫ���������ǰ����������ǿգ������ܿ�ʼִ�и��������Ǳ�֤�����������ϵ��һ�ö����������� root Ϊ������root.left �� root.right Ϊ��������ǰ�����񣨿���Ϊ�գ���root.val Ϊ�������ִ��ʱ�䡣
 * <p>
 * ��һ�� CPU ��ִ��ĳ������ʱ�����ǿ������κ�ʱ����ͣ��ǰ�����ִ�У���������ǰִ�н��ȡ����´μ���ִ�и�����ʱ�����֮ǰͣ���Ľ��ȿ�ʼ����ִ�С���ͣ��ʱ����Բ���������
 * <p>
 * ���ڣ�ϵͳ������ CPU �ˣ������ǿ���ͬʱִ���������񣬵���ͬһ��������ͬʱ����������ִ�С�����������������������������ִ����ϵ���Сʱ�䡣
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺root = [47, 74, 31]
 * <p>
 * �����121
 * <p>
 * ���ͣ����ڵ�����ҽڵ���Բ���ִ��31���ӣ�ʣ�µ�43+47����ֻ�ܴ���ִ�У��������ִ��ʱ����121���ӡ�
 * <p>
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺root = [15, 21, null, 24, null, 27, 26]
 * <p>
 * �����87
 * <p>
 * ʾ�� 3��
 * <p>
 * <p>
 * <p>
 * ���룺root = [1,3,2,null,null,4,4]
 * <p>
 * �����7.5
 * <p>
 * ���ƣ�
 * <p>
 * 1 <= �ڵ����� <= 1000
 * 1 <= ���ڵ�ִ��ʱ�� <= 1000
 * ͨ������595�ύ����1,210
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/er-cha-shu-ren-wu-diao-du
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinimalExecTime {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public double minimalExecTime(TreeNode root) {
        double[] res = execTime(root, 2);
        return res[0];
    }

    private double[] execTime(TreeNode node, int n) {
        if (node == null) {
            return new double[]{0.0d, 0.0d};
        }
        double[] leftTime = execTime(node.left, n);
        double[] rightTime = execTime(node.right, n);
        double sum = leftTime[1] + rightTime[1];
        double minTime = Math.max(Math.max(leftTime[0], rightTime[0]), sum / n) + node.val;
        return new double[]{minTime, sum + node.val};
    }
}
