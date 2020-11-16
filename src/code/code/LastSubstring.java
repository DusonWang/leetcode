package code.code;

/**
 * @author duson
 * ����һ���ַ���?s���ҳ����������Ӵ������ֵ������У��������������Ǹ��Ӵ���
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺"abab"
 * �����"bab"
 * ���ͣ����ǿ����ҳ� 7 ���Ӵ� ["a", "ab", "aba", "abab", "b", "ba", "bab"]�����ֵ������������Ӵ��� "bab"��
 * ʾ��?2��
 * <p>
 * ���룺"leetcode"
 * �����"tcode"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 4 * 10^5
 * s ������СдӢ���ַ���
 * ͨ������2,789�ύ����11,953
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/last-substring-in-lexicographical-order
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LastSubstring {

    public String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length();
        char[] ss = s.toCharArray();
        while (j < n) {
            if (ss[j] < ss[i]) {
                j++;
            } else {
                int k = 0;
                while (j + k < n && ss[i + k] == ss[j + k]) {
                    k++;
                }
                if (j + k == n) {
                    break;
                }
                if (ss[j + k] < ss[i + k]) {
                    j = j + k + 1;
                } else {
                    i = j;
                    j = i + 1;
                }
            }
        }
        return s.substring(i);
    }
}
