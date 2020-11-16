package code.code;

/**
 * @author duson
 * �����æ���һ�����������ҳ���?n?��������
 *
 * �����ǿ��Ա�?a?��?b?�� c?������ ��������
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺n = 3, a = 2, b = 3, c = 5
 * �����4
 * ���ͣ���������Ϊ 2, 3, 4, 5, 6, 8, 9, 10... ���е� 3 ���� 4��
 * ʾ�� 2��
 *
 * ���룺n = 4, a = 2, b = 3, c = 4
 * �����6
 * ���ͣ���������Ϊ 2, 3, 4, 6, 8, 9, 12... ���е� 4 ���� 6��
 * ʾ�� 3��
 *
 * ���룺n = 5, a = 2, b = 11, c = 13
 * �����10
 * ���ͣ���������Ϊ 2, 4, 6, 8, 10, 11, 12, 13... ���е� 5 ���� 10��
 * ʾ�� 4��
 *
 * ���룺n = 1000000000, a = 2, b = 217983653, c = 336916467
 * �����1999999984
 * ?
 *
 * ��ʾ��
 *
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * ��������?[1,?2 * 10^9]?�ķ�Χ��
 * ͨ������2,367�ύ����11,161
 * ����ʵ������������������⣿
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/ugly-number-iii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NthUglyNumberIII {

    public int nthUglyNumber(int n, int A, int B, int C) {
        if (A == 1 || B == 1 || C == 1) {
            return n;
        }
        long res = 0;
        long a = A;
        long b = B;
        long c = C;
        long ab = a * b / gcd(a, b);
        long ac = a * c / gcd(a, c);
        long bc = b * c / gcd(b, c);
        long abc = a * bc / gcd(a, bc);
        long left = 0;
        long right = 2000000000;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long cnt = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (cnt == n) {
                res = mid;
                right = mid - 1;
            } else if (cnt > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) res;
    }

    private long gcd(long a, long b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
