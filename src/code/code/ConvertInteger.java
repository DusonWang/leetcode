package code.code;

/**
 * ����ת������дһ��������ȷ����Ҫ�ı伸��λ���ܽ�����Aת������B��
 * <p>
 * ʾ��1:
 * <p>
 * ���룺A = 29 ������0b11101��, B = 15������0b01111��
 * �����2
 * ʾ��2:
 * <p>
 * ���룺A = 1��B = 2
 * �����2
 * ��ʾ:
 * <p>
 * A��B��Χ��[-2147483648, 2147483647]֮��
 * ͨ������2,050�ύ����4,185
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/convert-integer-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ConvertInteger {

    public int convertInteger(int a, int b) {
        return Integer.bitCount(a ^ b);

    }
}
