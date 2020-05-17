package com.leetcode.offer.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author duson
 * Ŷ�������㲻С�İ�һ����ƪ�����еĿո񡢱�㶼ɾ���ˣ����Ҵ�дҲŪ����Сд�������"I reset the computer. It still didn��t boot!"�Ѿ������"iresetthecomputeritstilldidntboot"���ڴ�������źʹ�Сд֮ǰ������Ȱ����ϳɴ����Ȼ�ˣ�����һ�����Ĵʵ�dictionary����������Щ��û�ڴʵ������������sentence��ʾ�����һ���㷨�������¶Ͽ���Ҫ��δʶ����ַ����٣�����δʶ����ַ�����
 * <p>
 * ע�⣺�������ԭ�������Ķ���ֻ�践��δʶ����ַ���
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * ����� 7
 * ���ͣ� �Ͼ��Ϊ"jess looked just like tim her brother"����7��δʶ���ַ���
 * ��ʾ��
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary�����ַ��������� 150000��
 * �������Ϊdictionary��sentence��ֻ����Сд��ĸ��
 * ͨ������988�ύ����1,938
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/re-space-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Respace {

    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int l = sentence.length();
        int[] dp = new int[l + 1];
        for (int i = 1; i < l + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int k = 0; k < i; k++) {
                String s = sentence.substring(k, i);
                if (set.contains(s)) {
                    dp[i] = Math.min(dp[i], dp[k]);
                }
            }
        }
        return dp[l];
    }
}
