package code.code;

/**
 * ����һ������?n?���������Խ�?n?��ʾ�����ɸ���ͬ��������֮�ͣ����㷵��?true?�������뷵�� false?��
 * <p>
 * ����һ������ y?������������� x?���� y == 3x?�����ǳ�������� y?�������ݡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 12
 * �����true
 * ���ͣ�12 = 31 + 32
 * ʾ�� 2��
 * <p>
 * ���룺n = 91
 * �����true
 * ���ͣ�91 = 30 + 32 + 34
 * ʾ�� 3��
 * <p>
 * ���룺n = 21
 * �����false
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 107
 * ͨ������4,005�ύ����6,128
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-number-is-a-sum-of-powers-of-three
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CheckPowersOfThree {

    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 > 1) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }
}
