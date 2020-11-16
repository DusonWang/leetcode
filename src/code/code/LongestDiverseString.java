package code.code;

/**
 * ����ַ����в������κ� 'aaa'��'bbb' �� 'ccc' �������ַ�����Ϊ�Ӵ�����ô���ַ�������һ���������ַ�������
 * <p>
 * ������������ a��b ��c�����㷵�� ����һ�� ��������ȫ���������ַ��� s��
 * <p>
 * s ��һ�������ܳ��Ŀ����ַ�����
 * s �� ��� ��a ����ĸ 'a'��b?����ĸ 'b'��c ����ĸ 'c' ��
 * s ��ֻ���� 'a'��'b' ��'c' ������ĸ��
 * ����������������ַ��� s ���뷵��һ�����ַ��� ""��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺a = 1, b = 1, c = 7
 * �����"ccaccbcc"
 * ���ͣ�"ccbccacc" Ҳ��һ����ȷ�𰸡�
 * ʾ�� 2��
 * <p>
 * ���룺a = 2, b = 2, c = 1
 * �����"aabbc"
 * ʾ�� 3��
 * <p>
 * ���룺a = 7, b = 1, c = 0
 * �����"aabaa"
 * ���ͣ����Ǹò���������Ψһ��ȷ�𰸡�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 * ͨ������2,566�ύ����5,825
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-happy-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LongestDiverseString {

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int size = a + b + c;
        int A = 0, B = 0, C = 0;
        for(int i = 0; i < size; i++) {
            if ((a >= b && a >= c && A != 2) || (B == 2 && a > 0) || (C == 2 && a > 0))  {
                sb.append("a");
                a--;
                A++;
                B = 0;
                C = 0;
            } else if ((b >= a && b >= c && B != 2) || (A == 2 && b > 0) || (C == 2 && b > 0)) {
                sb.append("b");
                b--;
                B++;
                A = 0;
                C = 0;
            } else if ((c >= a && c >= b && C != 2) || (B == 2 && c > 0) || (A == 2 && c > 0)) {
                sb.append("c");
                c--;
                C++;
                A = 0;
                B = 0;
            }
        }
        return sb.toString();
    }
}
