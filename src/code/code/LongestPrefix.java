package code.code;

/**
 * @author duson
 * ������ǰ׺������ԭ�ַ����м���?�ǿ� ǰ׺Ҳ�Ǻ�׺��������ԭ�ַ����������ַ�����
 * <p>
 * ����һ���ַ��� s�����㷵������ �����ǰ׺��
 * <p>
 * ������������������ǰ׺���򷵻�һ�����ַ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "level"
 * �����"l"
 * ���ͣ������� s �Լ���һ���� 4 ��ǰ׺��"l", "le", "lev", "leve"���� 4 ����׺��"l", "el", "vel", "evel"������ļ���ǰ׺Ҳ�Ǻ�׺���ַ����� "l" ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "ababab"
 * �����"abab"
 * ���ͣ�"abab" ����ļ���ǰ׺Ҳ�Ǻ�׺���ַ�������Ŀ����ǰ��׺��ԭ�ַ������ص���
 * ʾ�� 3��
 * <p>
 * ���룺s = "leetcodeleet"
 * �����"leet"
 * ʾ�� 4��
 * <p>
 * ���룺s = "a"
 * �����""
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 10^5
 * s ֻ����СдӢ����ĸ
 * ͨ������3,051�ύ����8,796
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-happy-prefix
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LongestPrefix {

    public String longestPrefix(String s) {
        char[] w = s.toCharArray();
        int n = s.length();
        int[] next = new int[n];
        int len = 0, i = 1;
        while (i < n) {
            if (w[i] == w[len]) {
                len++;
                next[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = next[len - 1];
                } else {
                    i++;
                }
            }
        }
        return s.substring(0, next[n - 1]);
    }
}
