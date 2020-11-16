package code.code;

/**
 * @author duson
 * Ϊ������Լ��Ĵ���������С���ƶ��� LeetCode ˢ��ƻ�����ѡ���� LeetCode ����е� n ���⣬��Ŵ� 0 �� n-1�����ƻ��� m ���ڰ�����Ŀ���˳��ˢ�����е���Ŀ��ע�⣬С�Ų����ö������ͬһ�⣩��
 * <p>
 * ��С��ˢ��ƻ��У�С����Ҫ�� time[i] ��ʱ����ɱ�� i ����Ŀ�����⣬С�Ż�����ʹ�ó����������ܣ�ͨ��ѯ�����ĺ�����С����Ŀ�Ľⷨ������ʡȥ���������ʱ�䡣Ϊ�˷�ֹ��С��ˢ��ƻ�����ɡ�С��ˢ��ƻ�����С��ÿ�����ʹ��һ��������
 * <p>
 * ���Ƕ��� m ��������ʱ������һ���ʱΪ T��С����ɵ���Ŀ������������ʱ�䣩�������С�������С�� T�Ƕ��١�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺time = [1,2,3,3], m = 2
 * <p>
 * �����3
 * <p>
 * ���ͣ���һ��С�����ǰ���⣬���е�������С���æ���ڶ�����ɵ����⣬������С���æ����������ʱ������һ�컨���� 3 ��ʱ�䣬�������ֵ����С�ġ�
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺time = [999,999,999], m = 4
 * <p>
 * �����0
 * <p>
 * ���ͣ���ǰ�����У�С��ÿ������С��һ�Σ�������������������������е���Ŀ�������κ�ʱ�䡣
 * <p>
 * ?
 * <p>
 * ���ƣ�
 * <p>
 * 1 <= time.length <= 10^5
 * 1 <= time[i] <= 10000
 * 1 <= m <= 1000
 * ͨ������1,423�ύ����5,322
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinTime2 {

    public int minTime(int[] time, int m) {
        int n = time.length;
        if (n <= m) {
            return 0;
        }
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isOk(time, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isOk(int[] time, int k, int m) {
        int max = 0;
        int sum = 0;
        int n = time.length;
        for (int i = 0; i < n; i++) {
            if (m == 0) {
                return false;
            }
            if (max < time[i]) {
                max = time[i];
            }
            sum += time[i];
            if (sum - max > k) {
                i--;
                max = 0;
                m--;
                sum = 0;
            }
        }
        return true;
    }
}
