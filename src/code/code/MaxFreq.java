package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * ����һ���ַ���?s �����㷵���������������ҳ��ִ�������?����?�Ӵ��ĳ��ִ�����
 * <p>
 * �Ӵ��в�ͬ��ĸ����Ŀ����С�ڵ��� maxLetters ��
 * �Ӵ��ĳ��ȱ�����ڵ���?minSize ��С�ڵ���?maxSize ��
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * �����2
 * ���ͣ��Ӵ� "aab" ��ԭ�ַ����г����� 2 �Ρ�
 * ���������е�Ҫ��2 ����ͬ����ĸ������Ϊ 3 ���� minSize �� maxSize ��Χ�ڣ���
 * ʾ�� 2��
 * <p>
 * ���룺s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * �����2
 * ���ͣ��Ӵ� "aaa" ��ԭ�ַ����г����� 2 �Σ����������ص����֡�
 * ʾ�� 3��
 * <p>
 * ���룺s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * �����3
 * ʾ�� 4��
 * <p>
 * ���룺s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 10^5
 * 1 <= maxLetters <= 26
 * 1 <= minSize <= maxSize <= min(26, s.length)
 * s?ֻ����СдӢ����ĸ��
 * ͨ������2,796�ύ����6,502
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-number-of-occurrences-of-a-substring
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxFreq {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int l = 0;
        int r = 0;
        int max = 0;
        int[] charM = new int[128];
        int count = 0;
        Map<String, Integer> resMap = new HashMap<>();
        int len = s.length();
        while (r < len) {
            while (r < len && r - l < minSize) {
                if (charM[s.charAt(r++)]++ == 0) {
                    count++;
                }
            }
            if (count <= maxLetters) {
                String key = s.substring(l, r);
                int cur = resMap.getOrDefault(key, 0) + 1;
                max = Math.max(cur, max);
                resMap.put(key, cur);
            }
            if (--charM[s.charAt(l++)] == 0) {
                count--;
            }
        }
        return max;
    }

}
