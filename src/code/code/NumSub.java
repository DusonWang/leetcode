package code.code;

/**
 * ����һ���������ַ��� s������ '0' �� '1' ��ɵ��ַ�������
 * <p>
 * ���������ַ���Ϊ 1 �����ַ�������Ŀ��
 * <p>
 * ���ڴ𰸿��ܴܺ����㽫���� 10^9 + 7 ȡģ�󷵻ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "0110111"
 * �����9
 * ���ͣ����� 9 �����ַ������� '1' ���
 * "1" -> 5 ��
 * "11" -> 3 ��
 * "111" -> 1 ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "101"
 * �����2
 * ���ͣ����ַ��� "1" �� s �й����� 2 ��
 * ʾ�� 3��
 * <p>
 * ���룺s = "111111"
 * �����21
 * ���ͣ�ÿ�����ַ��������� '1' ���
 * ʾ�� 4��
 * <p>
 * ���룺s = "000"
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * s[i] == '0' �� s[i] == '1'
 * 1 <= s.length <= 10^5
 * ͨ������10,141�ύ����27,093
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-substrings-with-only-1s
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumSub {

    public int numSub(String s) {
        long count = 0;
        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                ones = 0;
            } else {
                count += ++ones;
            }
        }
        return (int) (count % 1_000_000_007);
    }

    public static void main(String[] args) {
        NumSub numSub = new NumSub();
        System.out.println(numSub.numSub("0110111"));
    }
}
