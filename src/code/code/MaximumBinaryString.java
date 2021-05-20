package code.code;

import java.util.Arrays;

/**
 * ����һ���������ַ���?binary?��������?0?����?1?��ɡ������ʹ������Ĳ�������ζ��������޸ģ�
 * <p>
 * ���� 1 ����������ƴ��������ַ���?"00"?���������?"10"?�����滻��
 * �ȷ�˵��?"00010" -> "10010"
 * ���� 2 ����������ƴ��������ַ���?"10"?���������?"01"?�����滻��
 * �ȷ�˵��?"00010" -> "00001"
 * ���㷵��ִ����������������Ժ��ܵõ��� ���������ַ���?������������ַ��� x?��Ӧ��ʮ�������ִ��ڶ������ַ��� y?��Ӧ��ʮ�������֣���ô���ǳƶ������ַ���?x?���ڶ������ַ���?y?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺binary = "000110"
 * �����"111011"
 * ���ͣ�һ�����е�ת��Ϊ��
 * "000110" -> "000101"
 * "000101" -> "100101"
 * "100101" -> "110101"
 * "110101" -> "110011"
 * "110011" -> "111011"
 * ʾ�� 2��
 * <p>
 * ���룺binary = "01"
 * �����"01"
 * ���ͣ�"01" û�취�����κ�ת����
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= binary.length <= 105
 * binary ������?'0' ��?'1' ��
 * ͨ������2,427�ύ����5,130
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-binary-string-after-change
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaximumBinaryString {

    public String maximumBinaryString(String binary) {
        int zeros = 0;
        int ones = 0;
        int len = binary.length();
        char[] chars = binary.toCharArray();
        while (ones < len && chars[ones] == '1') {
            ones++;
        }
        for (char c : chars) {
            if (c == '0') {
                zeros++;
            }
        }
        if (zeros == 0) {
            return binary;
        }
        char[] ar = new char[len];
        Arrays.fill(ar, '1');
        ar[ones + zeros - 1] = '0';
        return String.valueOf(ar);
    }

    public static void main(String[] args) {
        MaximumBinaryString maximumBinaryString = new MaximumBinaryString();
        System.out.println(maximumBinaryString.maximumBinaryString("0110"));
    }
}
