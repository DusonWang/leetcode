package code.code;

/**
 * ����һ������?n������ÿ����λ��ӵ㣨�� "." ���ţ���Ϊǧλ�ָ���������������ַ�����ʽ���ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 987
 * �����"987"
 * ʾ�� 2��
 * <p>
 * ���룺n = 1234
 * �����"1.234"
 * ʾ�� 3��
 * <p>
 * ���룺n = 123456789
 * �����"123.456.789"
 * ʾ�� 4��
 * <p>
 * ���룺n = 0
 * �����"0"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= n < 2^31
 * ͨ������8,292�ύ����14,133
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/thousand-separator
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ThousandSeparator {

    public String thousandSeparator(int n) {
        int count = 0;
        StringBuilder ans = new StringBuilder();
        do {
            int cur = n % 10;
            n /= 10;
            ans.append(cur);
            ++count;
            if (count % 3 == 0 && n != 0) {
                ans.append('.');
            }
        } while (n != 0);
        ans.reverse();
        return ans.toString();
    }
}
