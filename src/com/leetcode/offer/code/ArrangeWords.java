package com.leetcode.offer.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author duson
 * �����ӡ���һ���ÿո�ָ����ʵ��ַ���������һ������������ʽ�ľ��� text :
 * <p>
 * ���ӵ�����ĸ��д
 * text �е�ÿ�����ʶ��õ����ո�ָ���
 * ������������ text �еĵ��ʣ�ʹ���е��ʰ��䳤�ȵ��������С�����������ʵĳ�����ͬ����������ԭ�����е����˳��
 * <p>
 * ��ͬ����������ʽ�����µľ��ӡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺text = "Leetcode is cool"
 * �����"Is cool leetcode"
 * ���ͣ������й��� 3 �����ʣ�����Ϊ 8 �� "Leetcode" ������Ϊ 2 �� "is" �Լ�����Ϊ 4 �� "cool" ��
 * �����Ҫ�����ʵĳ����������У��¾����еĵ�һ����������ĸ��Ҫ��д��
 * ʾ�� 2��
 * <p>
 * ���룺text = "Keep calm and code on"
 * �����"On and keep calm code"
 * ���ͣ����������������£�
 * "On" 2 ����ĸ��
 * "and" 3 ����ĸ��
 * "keep" 4 ����ĸ����Ϊ���ڳ�����ͬ���������ʣ���������֮����Ҫ������ԭ�����е����˳��
 * "calm" 4 ����ĸ��
 * "code" 4 ����ĸ��
 * ʾ�� 3��
 * <p>
 * ���룺text = "To be or not to be"
 * �����"To be or to be not"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * text �Դ�д��ĸ��ͷ��Ȼ���������Сд��ĸ�Լ����ʼ�ĵ����ո�
 * 1 <= text.length <= 10^5
 * ͨ������3,815�ύ����8,350
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/rearrange-words-in-a-sentence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ArrangeWords {

    public String arrangeWords(String text) {
        String[] s = text.toLowerCase().split(" ");
        Arrays.sort(s, Comparator.comparingInt(String::length));
        char first = s[0].charAt(0);
        first = (char) (first - 32);
        s[0] = first + s[0].substring(1);
        return String.join(" ", s);
    }
}
