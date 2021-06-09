package code.code;

/**
 * һ���ַ����� ����ֵ����Ϊ������Ƶ������ַ������Ƶ������ַ��ĳ��ִ���֮�
 * <p>
 * �ȷ�˵��"abaacc"������ֵΪ3 - 1 = 2��
 * ����һ���ַ���s�����㷵�����������ַ���������ֵ֮�͡�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "aabcb"
 * �����5
 * ���ͣ�����ֵ��Ϊ����ַ������� ["aab","aabc","aabcb","abcb","bcb"] ��ÿһ���ַ���������ֵ��Ϊ 1 ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "aabcbaa"
 * �����17
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 500
 * sֻ����СдӢ����ĸ��
 * ͨ������3,608�ύ����7,158
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sum-of-beauty-of-all-substrings
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BeautySum {

    public int beautySum(String s) {
        int ans = 0;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            int[] count = new int[26];
            for (int j = i; j < len; ++j) {
                char ch = s.charAt(j);
                count[ch - 'a'] += 1;
                int maxValue = Integer.MIN_VALUE;
                int minValue = Integer.MAX_VALUE;
                for (int value : count) {
                    if (value > 0) {
                        if (value > maxValue) {
                            maxValue = value;
                        }
                        if (value < minValue) {
                            minValue = value;
                        }
                    }
                }
                ans += (maxValue - minValue);
            }
        }
        return ans;
    }

}
