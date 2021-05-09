package code.code;

/**
 * ����һ���������� bloomDay���Լ��������� m �� k ��
 * <p>
 * ����Ҫ���� m ��������������ʱ����Ҫʹ�û�԰�� ���ڵ� k �仨 ��
 * <p>
 * ��԰���� n �仨���� i �仨���� bloomDay[i] ʱʢ����ǡ�� �������� һ�� ���С�
 * <p>
 * ���㷵�شӻ�԰��ժ m ������Ҫ�ȴ������ٵ��������������ժ�� m �����򷵻� -1 ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺bloomDay = [1,10,3,10,2], m = 3, k = 1
 * �����3
 * ���ͣ�������һ��۲�������Ļ������̣�x ��ʾ�������� _ ��ʾ����δ����
 * ������Ҫ���� 3 ������ÿ��ֻ��Ҫ 1 �䡣
 * 1 ���[x, _, _, _, _]   // ֻ������ 1 ����
 * 2 ���[x, _, _, _, x]   // ֻ������ 2 ����
 * 3 ���[x, _, x, _, x]   // �������� 3 ��������Ϊ 3
 * ʾ�� 2��
 * <p>
 * ���룺bloomDay = [1,10,3,10,2], m = 3, k = 2
 * �����-1
 * ���ͣ�Ҫ���� 3 ������ÿ����Ҫ 2 �仨��Ҳ����һ����Ҫ 6 �仨������԰��ֻ�� 5 �仨���޷���������Ҫ�󣬷��� -1 ��
 * ʾ�� 3��
 * <p>
 * ���룺bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * �����12
 * ���ͣ�Ҫ���� 2 ������ÿ����Ҫ 3 �䡣
 * ��԰�� 7 ���� 12 ����������£�
 * 7 ���[x, x, x, x, _, x, x]
 * ������ǰ 3 ��ʢ���Ļ�������һ������������ʹ�ú� 3 ��ʢ���Ļ�����Ϊ���ǲ����ڡ�
 * 12 ���[x, x, x, x, x, x, x]
 * ��Ȼ�����ǿ����ò�ͬ�ķ�ʽ������������
 * ʾ�� 4��
 * <p>
 * ���룺bloomDay = [1000000000,1000000000], m = 1, k = 1
 * �����1000000000
 * ���ͣ���Ҫ�� 1000000000 ����ܲɵ�������������
 * ʾ�� 5��
 * <p>
 * ���룺bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
 * �����9
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * bloomDay.length == n
 * 1 <= n <= 10^5
 * 1 <= bloomDay[i] <= 10^9
 * 1 <= m <= 10^6
 * 1 <= k <= n
 * ͨ������17,796�ύ����31,125
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinDays {

    public int minDays(int[] bloomDay, int m, int k) {
        if (m > bloomDay.length / k) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = 0;
        for (int j : bloomDay) {
            low = Math.min(low, j);
            high = Math.max(high, j);
        }
        while (low < high) {
            int days = (high - low) / 2 + low;
            if (canMake(bloomDay, days, m, k)) {
                high = days;
            } else {
                low = days + 1;
            }
        }
        return low;
    }

    private boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
