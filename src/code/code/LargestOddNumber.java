package code.code;

/**
 * ����һ���ַ��� num ����ʾһ�����������������ַ��� num �����зǿ����ַ��� ���ҳ� ֵ�������� �������ַ�����ʽ���ء�����������������򷵻�һ�����ַ��� "" ��
 * <p>
 * ���ַ��� ���ַ����е�һ���������ַ����С�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺num = "52"
 * �����"5"
 * ���ͣ��ǿ����ַ������� "5"��"2" �� "52" ��"5" ������Ψһ��������
 * ʾ�� 2��
 * <p>
 * ���룺num = "4206"
 * �����""
 * ���ͣ��� "4206" �в�����������
 * ʾ�� 3��
 * <p>
 * ���룺num = "35427"
 * �����"35427"
 * ���ͣ�"35427" �������һ��������
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= num.length <= 105
 * num ������������Ҳ���ǰ����
 * ͨ������4,153�ύ����6,440
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/largest-odd-number-in-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LargestOddNumber {

    public String largestOddNumber(String num) {
        char[] chars = num.toCharArray();
        int len = chars.length;
        for (int i = len - 1; i >= 0; i--) {
            if (((chars[i] - '0') & 1) == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        LargestOddNumber largestOddNumber = new LargestOddNumber();
        System.out.println(largestOddNumber.largestOddNumber("52"));
        System.out.println(largestOddNumber.largestOddNumber("4206"));
        System.out.println(largestOddNumber.largestOddNumber("35427"));
    }
}
