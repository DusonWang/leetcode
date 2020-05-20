package com.leetcode.offer.code;

/**
 * �ַ�����ת�����������ַ���s1��s2�����д������s2�Ƿ�Ϊs1��ת���ɣ����磬waterbottle��erbottlewat��ת����ַ�������
 * <p>
 * ʾ��1:
 * <p>
 * ���룺s1 = "waterbottle", s2 = "erbottlewat"
 * �����True
 * ʾ��2:
 * <p>
 * ���룺s1 = "aa", "aba"
 * �����False
 * ��ʾ��
 * <p>
 * �ַ���������[0, 100000]��Χ�ڡ�
 * ˵��:
 * <p>
 * ����ֻ����һ�μ���Ӵ��ķ�����
 * ͨ������6,160�ύ����11,348
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/string-rotation-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsFlipedString {

    public boolean isFlipedString(String s1, String s2) {
        return s1.equals(s2) || (s1.length() == s2.length() && (s1 + s1).contains(s2));
    }
}
