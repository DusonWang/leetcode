package code.code;

/**
 * ����һ�������ƴ�s ��һ��ֻ���� 0 �� 1 ���ַ����������ǿ��Խ� s�ָ�� 3 �� �ǿ��ַ��� s1, s2, s3 ��s1 + s2 + s3 = s����
 * <p>
 * ���㷵�طָ�s�ķ����������� s1��s2 �� s3 ���ַ� '1' ����Ŀ��ͬ��
 * <p>
 * ���ڴ𰸿��ܴܺ��뽫���� 10^9 + 7 ȡ��󷵻ء�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "10101"
 * �����4
 * ���ͣ��ܹ��� 4 �ַ����� s �ָ�ɺ��� '1' ��Ŀ��ͬ���������ַ�����
 * "1|010|1"
 * "1|01|01"
 * "10|10|1"
 * "10|1|01"
 * ʾ�� 2��
 * <p>
 * ���룺s = "1001"
 * �����0
 * ʾ�� 3��
 * <p>
 * ���룺s = "0000"
 * �����3
 * ���ͣ��ܹ��� 3 �ַָ� s �ķ�����
 * "0|0|00"
 * "0|00|0"
 * "00|0|0"
 * ʾ�� 4��
 * <p>
 * ���룺s = "100100010100110"
 * �����12
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * s[i] == '0'����s[i] == '1'
 * 3 <= s.length <= 10^5
 * ͨ������4,043�ύ����13,820
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-ways-to-split-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumWays {

    public int numWays(String s) {
        char[] sChar = s.toCharArray();
        int[] index = new int[sChar.length];
        int k = 0;
        int len = sChar.length;
        int oneNum = 0;
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] == '1') {
                oneNum++;
                index[k++] = i;
            }
        }
        if (oneNum == 0) {
            return (int) ((long) (len - 1) * (len - 2) / 2 % (1000000007));
        }
        if (oneNum % 3 != 0) {
            return 0;
        }
        int partOneNum = oneNum / 3;
        return (int) ((long) (index[partOneNum] - index[partOneNum - 1]) * (index[2 * partOneNum] - index[2 * partOneNum - 1]) % (1000000007));
    }

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays("10101"));
        System.out.println(numWays.numWays("100100010100110"));
    }
}
