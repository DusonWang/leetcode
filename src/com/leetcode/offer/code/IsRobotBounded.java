package com.leetcode.offer.code;

/**
 * @author duson
 * �����޵�ƽ���ϣ����������λ��?(0, 0)?�����泯�����������˿��Խ�����������ָ��֮һ��
 * <p>
 * "G"��ֱ�� 1 ����λ
 * "L"����ת 90 ��
 * "R"����ת 90 ��
 * �����˰�˳��ִ��ָ��?instructions����һֱ�ظ����ǡ�
 * <p>
 * ֻ����ƽ���д��ڻ�ʹ�û�������Զ�޷��뿪ʱ������?true�����򣬷��� false��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺"GGLLGG"
 * �����true
 * ���ͣ�
 * �����˴� (0,0) �ƶ��� (0,2)��ת 180 �ȣ�Ȼ��ص� (0,0)��
 * �ظ���Щָ������˽���������ԭ��Ϊ���ģ�2 Ϊ�뾶�Ļ��н����ƶ���
 * ʾ�� 2��
 * <p>
 * ���룺"GG"
 * �����false
 * ���ͣ�
 * �������������ƶ���
 * ʾ�� 3��
 * <p>
 * ���룺"GL"
 * �����true
 * ���ͣ�
 * �����˰� (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ... �����ƶ���
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= instructions.length <= 100
 * instructions[i] ��?{'G', 'L', 'R'}?��
 * ͨ������3,490�ύ����7,977
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/robot-bounded-in-circle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsRobotBounded {

    public boolean isRobotBounded(String instructions) {
        int[] currCor = new int[2];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ind = 0;
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                ind = (ind + 3) % 4;
                continue;
            } else if (instructions.charAt(i) == 'R') {
                ind = (ind + 1) % 4;
                continue;
            }
            currCor[0] += dir[ind][0];
            currCor[1] += dir[ind][1];
        }
        return (currCor[0] == 0 && currCor[1] == 0) || ind > 0;
    }
}
