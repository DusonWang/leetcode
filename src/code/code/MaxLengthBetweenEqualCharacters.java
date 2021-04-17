package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���ַ��� s�����㷵�� ������ͬ�ַ�֮�������ַ����ĳ��� �����㳤��ʱ�����������ַ���������������������ַ��������� -1 ��
 * <p>
 * ���ַ��� ���ַ����е�һ�������ַ����С�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "aa"
 * �����0
 * ���ͣ����ŵ����ַ��������� 'a' ֮��Ŀ����ַ�����
 * ʾ�� 2��
 * <p>
 * ���룺s = "abca"
 * �����2
 * ���ͣ����ŵ����ַ����� "bc" ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "cbzxy"
 * �����-1
 * ���ͣ�s �в����ڳ��ֳ������ε��ַ������Է��� -1 ��
 * ʾ�� 4��
 * <p>
 * ���룺s = "cabbac"
 * �����4
 * ���ͣ����ŵ����ַ����� "abba" �������ķ����Ž���� "bb" �� "" ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 300
 * s ֻ��СдӢ����ĸ
 * ͨ������9,057�ύ����14,475
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxLengthBetweenEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
            } else {
                max = Math.max(max, i - map.get(chars[i]) - 1);
            }
        }
        return max;
    }

}
