package code.code;

/**
 * һ��������õı�?A������� 1 ������һЩ����.? ���б��е�ÿһ�� p<q ʱ�����ǿ��Թ���һ������ p/q ��
 * <p>
 * ��ô��?k?����С�ķ����Ƕ�����?? �������������ʽ������Ĵ�, ����?answer[0] = p?��?answer[1] = q.
 * <p>
 * ʾ��:
 * ����: A = [1, 2, 3, 5], K = 3
 * ���: [2, 5]
 * ����:
 * �ѹ���õķ���,�����������ʾ:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
 * �����Ե�������С�ķ����� 2/5.
 * <p>
 * ����: A = [1, 7], K = 1
 * ���: [1, 7]
 * ע��:
 * <p>
 * A ���ȵ�ȡֵ��Χ�� 2 �� 2000.
 * ÿ��?A[i] ��ֵ�� 1 ��30000.
 * K ȡֵ��ΧΪ 1 ��A.length * (A.length - 1) / 2
 * ͨ������1,390�ύ����3,692
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/k-th-smallest-prime-fraction
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] primes, int k) {
        double lo = 0, hi = 1;
        int[] ans = new int[]{0, 1};
        while (hi - lo > 1e-9) {
            double mi = lo + (hi - lo) / 2.0;
            int[] res = under(mi, primes);
            if (res[0] < k) {
                lo = mi;
            } else {
                ans[0] = res[1];
                ans[1] = res[2];
                hi = mi;
            }
        }
        return ans;
    }

    public int[] under(double x, int[] primes) {
        int numer = 0, denom = 1, count = 0, i = -1;
        for (int j = 1; j < primes.length; ++j) {
            while (primes[i + 1] < primes[j] * x) {
                ++i;
            }
            count += i + 1;
            if (i >= 0 && numer * primes[j] < denom * primes[i]) {
                numer = primes[i];
                denom = primes[j];
            }
        }
        return new int[]{count, numer, denom};
    }
}
