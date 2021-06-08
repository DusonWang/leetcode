package code.code;

/**
 * ����һ������n�����㽫1�� n�Ķ����Ʊ�ʾ�������������������ӽ����Ӧ�� ʮ�������ֶ� 109+ 7ȡ��Ľ����
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 1
 * �����1
 * ���ͣ������Ƶ� "1" ��Ӧ��ʮ���Ƶ� 1 ��
 * ʾ�� 2��
 * <p>
 * ���룺n = 3
 * �����27
 * ���ͣ��������£�1��2 �� 3 �ֱ��Ӧ "1" ��"10" �� "11" ��
 * �������������ӣ����ǵõ� "11011" ����Ӧ��ʮ���Ƶ� 27 ��
 * ʾ�� 3��
 * <p>
 * ���룺n = 12
 * �����505379714
 * ���ͣ����ӽ��Ϊ "1101110010111011110001001101010111100" ��
 * ��Ӧ��ʮ��������Ϊ 118505380540 ��
 * �� 109 + 7 ȡ��󣬽��Ϊ 505379714 ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 105
 * ͨ������4,916�ύ����10,780
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/concatenation-of-consecutive-binary-numbers
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ConcatenatedBinary {

    public int concatenatedBinary(int n) {
        int m = 1_000_000_007;
        int b = 0;
        long ans = 0;
        for (int k = 1; k <= n; k++) {
            if ((k & (k - 1)) == 0) {
                ++b;
            }
            ans <<= b;
            ans += k;
            ans %= m;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        ConcatenatedBinary concatenatedBinary = new ConcatenatedBinary();
        System.out.println(concatenatedBinary.concatenatedBinary(12));
    }
}
