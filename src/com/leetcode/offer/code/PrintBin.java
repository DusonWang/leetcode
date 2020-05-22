package com.leetcode.offer.code;

/**
 * ��������ת�ַ���������һ������0��1֮���ʵ������0.72��������Ϊdouble����ӡ���Ķ����Ʊ��ʽ����������ֲ���0��1֮�䣬�����޷���ȷ����32λ���ڵĶ����Ʊ�ʾ�����ӡ��ERROR����
 * <p>
 * ʾ��1:
 * <p>
 * ���룺0.625
 * �����"0.101"
 * ʾ��2:
 * <p>
 * ���룺0.1
 * �����"ERROR"
 * ��ʾ��0.1�޷���������׼ȷ��ʾ
 * ��ʾ��
 * <p>
 * 32λ��������е�"0."����λ��
 * ͨ������1,401�ύ����2,389
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/bianry-number-to-string-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class PrintBin {

    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        for (int i = 1; i < 31 && num > 0; i++) {
            double value = Math.pow(0.5, i);
            if (num >= value) {
                num -= value;
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return num == 0 ? sb.toString() : "ERROR";
    }
}
