package code.code;

/**
 * ��һ���ַ��� s?������ÿһ����ĸ�Ĵ�д��Сд��ʽ ͬʱ?������ s?�У��ͳ�����ַ���?s?�� ���� �ַ������ȷ�˵��"abABB"?�������ַ�������Ϊ?'A' ��?'a'?ͬʱ�����ˣ���?'B' ��?'b'?Ҳͬʱ�����ˡ�Ȼ����"abA"?���������ַ�����Ϊ?'b'?�����ˣ���?'B'?û�г��֡�
 * <p>
 * ����һ���ַ���?s?�����㷵��?s?���?�������ַ���?������ж���𰸣����㷵��?����?���ֵ�һ��������������������ַ��������㷵��һ�����ַ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "YazaAay"
 * �����"aAa"
 * ���ͣ�"aAa" ��һ�������ַ�������Ϊ����Ӵ��н���һ����ĸ����Сд��ʽ 'a' �ʹ�д��ʽ 'A' Ҳͬʱ�����ˡ�
 * "aAa" ������������ַ�����
 * ʾ�� 2��
 * <p>
 * ���룺s = "Bb"
 * �����"Bb"
 * ���ͣ�"Bb" �������ַ�������Ϊ 'B' �� 'b' �������ˡ������ַ���Ҳ��ԭ�ַ��������ַ�����
 * ʾ�� 3��
 * <p>
 * ���룺s = "c"
 * �����""
 * ���ͣ�û���������ַ�����
 * ʾ�� 4��
 * <p>
 * ���룺s = "dDzeE"
 * �����"dD"
 * ���ͣ�"dD" �� "eE" ������������ַ�����
 * �����ж���������ַ��������� "dD" ����Ϊ�����ֵ����硣
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 100
 * s?ֻ������д��СдӢ����ĸ��
 * ͨ������2,714�ύ����4,438
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-nice-substring
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }
        int length = s.length();
        String ans = "";
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i + len - 1 < length; i++) {
                String substring = s.substring(i, i + len);
                if (substring.length() > ans.length() && check(substring)) {
                    ans = substring;
                }
            }
        }
        return ans;

    }

    private boolean check(String str) {
        int[] aa = new int[26];
        int[] AA = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c - 'A' < 26) {
                AA[c - 'A'] = 1;
            } else {
                aa[c - 'a'] = 1;
            }
        }
        for (int j = 0; j < aa.length; j++) {
            if ((aa[j] > 0 && AA[j] == 0) || (aa[j] == 0 && AA[j] > 0)) {
                return false;
            }
        }
        return true;
    }
}
