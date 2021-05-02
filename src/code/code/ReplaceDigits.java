package code.code;

/**
 * ����һ���±�� 0?��ʼ���ַ��� s?������ ż�� �±괦ΪСдӢ����ĸ������?�±괦Ϊ���֡�
 * <p>
 * ����һ������?shift(c, x)?������?c?��һ���ַ���?x?��һ�����֣�����������ĸ����?c?����� x?���ַ���
 * <p>
 * �ȷ�˵��shift('a', 5) = 'f'?��?shift('x', 0) = 'x'?��
 * ����ÿ�� ����?�±�?i?������Ҫ������?s[i] ��?shift(s[i-1], s[i])?�滻��
 * <p>
 * �����滻���������Ժ󣬽��ַ��� s?���ء���Ŀ ��֤?shift(s[i-1], s[i])?���ᳬ�� 'z'?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "a1c1e1"
 * �����"abcdef"
 * ���ͣ����ֱ��滻������£�
 * - s[1] -> shift('a',1) = 'b'
 * - s[3] -> shift('c',1) = 'd'
 * - s[5] -> shift('e',1) = 'f'
 * ʾ�� 2��
 * <p>
 * ���룺s = "a1b2c3d4e"
 * �����"abbdcfdhe"
 * ���ͣ����ֱ��滻������£�
 * - s[1] -> shift('a',1) = 'b'
 * - s[3] -> shift('b',2) = 'd'
 * - s[5] -> shift('c',3) = 'f'
 * - s[7] -> shift('d',4) = 'h'
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 100
 * s?ֻ����СдӢ����ĸ�����֡�
 * ������ ���� �±괦��?i?������?shift(s[i-1], s[i]) <= 'z'?��
 * ͨ������2,219�ύ����2,588
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/replace-all-digits-with-characters
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ReplaceDigits {

    public String replaceDigits(String s) {
        StringBuilder s1 = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (i % 2 == 0) {
                s1.append(c[i]);
            } else {
                s1.append((char) (c[i - 1] + (c[i] - '0')));
            }
        }
        return s1.toString();
    }
}
