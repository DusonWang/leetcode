package code.code;

/**
 * @author duson
 * ����һ����������ֺ���ĸ���ַ��� s�����е���ĸ��ΪСдӢ����ĸ��
 * <p>
 * ���㽫���ַ������¸�ʽ����ʹ���������������ַ������Ͷ���ͬ��Ҳ����˵����ĸ����Ӧ�ø������֣������ֺ���Ӧ�ø�����ĸ��
 * <p>
 * ���㷵�� ���¸�ʽ���� ���ַ���������޷���Ҫ�����¸�ʽ�����򷵻�һ�� ���ַ��� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "a0b1c2"
 * �����"0a1b2c"
 * ���ͣ�"0a1b2c" ���������������ַ������Ͷ���ͬ�� "a0b1c2", "0a1b2c", "0c2a1b" Ҳ��������ĿҪ��Ĵ𰸡�
 * ʾ�� 2��
 * <p>
 * ���룺s = "leetcode"
 * �����""
 * ���ͣ�"leetcode" ��ֻ����ĸ�������޷��������¸�ʽ����������
 * ʾ�� 3��
 * <p>
 * ���룺s = "1229857369"
 * �����""
 * ���ͣ�"1229857369" ��ֻ�����֣������޷��������¸�ʽ����������
 * ʾ�� 4��
 * <p>
 * ���룺s = "covid2019"
 * �����"c2o0v1i9d"
 * ʾ�� 5��
 * <p>
 * ���룺s = "ab123"
 * �����"1a2b3"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 500
 * s ����СдӢ����ĸ��/��������ɡ�
 * ͨ������5,895�ύ����11,707
 * ����ʵ������������������⣿
 * <p>
 * ��
 * <p>
 * <p>
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reformat-the-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Reformat {

    public String reformat(String s) {
        int num1 = 0, num2 = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                num1++;
            } else {
                num2++;
            }
        }
        if (num1 - num2 < -1 || num1 - num2 > 1) {
            return "";
        }
        if (num1 > num2) {
            num1 = 0;
            num2 = 1;
        } else {
            num1 = 1;
            num2 = 0;
        }
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                chars[num1] = c;
                num1 += 2;
            } else {
                chars[num2] = c;
                num2 += 2;
            }
        }
        return new String(chars);
    }
}