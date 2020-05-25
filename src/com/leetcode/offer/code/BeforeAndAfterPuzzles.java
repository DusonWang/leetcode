package com.leetcode.offer.code;

import java.util.*;

/**
 * ����һ��������б�?phrases�������æ����������ƴ�Ӻ�ġ��¶���б�
 * <p>
 * �������phrase���ǽ���СдӢ����ĸ�Ϳո���ɵ��ַ�����������Ŀ�ͷ�ͽ�β��������ֿո񣬡�����еĿո񲻻��������֡�
 * <p>
 * ��ǰ��ƴ�ӡ���Before and After?puzzles���Ǻϲ�����������γɡ��¶���ķ��������ǹ涨ƴ��ʱ����һ����������һ������ �� �ڶ�������ĵ�һ������ ������ͬ��
 * <p>
 * ����ÿ���������?phrases[i]?��?phrases[j]��i != j�����С�ǰ��ƴ�ӡ��õ��ġ��¶����
 * <p>
 * ע�⣬���������ƴ��ʱ��˳��Ҳ����Ҫ��������Ҫͬʱ��������������������⣬ͬһ����������Զ�β���ƴ�ӣ������¶�������ٲ���ƴ�ӡ�
 * <p>
 * ���㰴�ֵ������в����ء��¶���б��б��е��ַ���Ӧ���� ���ظ��� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺phrases = ["writing code","code rocks"]
 * �����["writing code rocks"]
 * ʾ�� 2��
 * <p>
 * ���룺phrases = ["mission statement",
 * "a quick bite to eat",
 * ?               "a chip off the old block",
 * ?               "chocolate bar",
 * ?               "mission impossible",
 * ?               "a man on a mission",
 * ?               "block party",
 * ?               "eat my words",
 * ?               "bar of soap"]
 * �����["a chip off the old block party",
 * ?     "a man on a mission impossible",
 * ?     "a man on a mission statement",
 * ?     "a quick bite to eat my words",
 * "chocolate bar of soap"]
 * ʾ�� 3��
 * <p>
 * ���룺phrases = ["a","b","a"]
 * �����["a"]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= phrases.length <= 100
 * 1 <= phrases[i].length <= 100
 * ͨ������1,016�ύ����2,967
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/before-and-after-puzzle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * @author duson
 */
public class BeforeAndAfterPuzzles {

    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        List<String> res = new ArrayList<>();
        if (phrases.length == 1) {
            return res;
        }
        Set<String> set = new HashSet<>();
        StringBuilder sb;
        for (int i = 0; i < phrases.length; i++) {
            String suffix = phrases[i].substring(phrases[i].lastIndexOf(" ") + 1);
            for (int j = 0; j < phrases.length; j++) {
                if (i == j) {
                    continue;
                }
                String[] split = phrases[j].split(" ");
                if (split[0].equals(suffix)) {
                    sb = new StringBuilder();
                    sb.append(phrases[i]).append(phrases[j].substring(suffix.length()));
                    set.add(sb.toString());
                }
            }
        }
        res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }
}
