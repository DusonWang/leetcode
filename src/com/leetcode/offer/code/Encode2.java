package com.leetcode.offer.code;

/**
 * @author duson
 * ����һ���Ǹ����� num ���������ġ������ַ�������
 * <p>
 * ���ܵĹ����ǰ�һ��������ĳ��δ֪��������ת��������Ҫ���±��Ʋ����ת��������
 * <p>
 * <p>
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺num = 23
 * �����"1000"
 * ʾ�� 2��
 * <p>
 * ���룺num = 107
 * �����"101100"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= num <= 10^9
 * ͨ������1,032�ύ����1,674
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/encode-number
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Encode2 {

    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}
