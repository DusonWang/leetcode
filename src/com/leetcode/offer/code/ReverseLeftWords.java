package com.leetcode.offer.code;

/**
 * @author duson
 * �ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β�����붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ����磬�����ַ���"abcdefg"������2���ú�������������ת��λ�õ��Ľ��"cdefgab"��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ����: s = "abcdefg", k = 2
 * ���:?"cdefgab"
 * ʾ�� 2��
 * <p>
 * ����: s = "lrloseumgh", k = 6
 * ���:?"umghlrlose"
 * ?
 * <p>
 * ���ƣ�
 * <p>
 * 1 <= k < s.length <= 10000
 * ͨ������27,803�ύ����32,928
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
