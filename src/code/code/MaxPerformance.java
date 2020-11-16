package code.code;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author duson
 * ��˾�б��Ϊ 1?�� n?�� n?������ʦ�������������� speed?�� efficiency?������ speed[i]?�� efficiency[i]?�ֱ����� i?λ����ʦ���ٶȺ�Ч�ʡ����㷵�������?k?������ʦ��ɵ�???????����Ŷӱ���ֵ?�����ڴ𰸿��ܴܺ����㷵�ؽ���� 10^9 + 7 ȡ���Ľ����
 * <p>
 * �Ŷӱ���ֵ?�Ķ���Ϊ��һ���Ŷ��С����й���ʦ�ٶȵĺ͡��������ǡ�Ч��ֵ�е���Сֵ����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * �����60
 * ���ͣ�
 * ����ѡ�񹤳�ʦ 2��speed=10 �� efficiency=4���͹���ʦ 5��speed=5 �� efficiency=7�������ǵ��Ŷӱ���ֵΪ performance = (10 + 5) * min(4, 7) = 60 ��
 * ʾ�� 2��
 * <p>
 * ���룺n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * �����68
 * ���ͣ�
 * ��ʾ�����һ��ʾ����ͬ������ k = 3 �����ǿ���ѡ�񹤳�ʦ 1 ������ʦ 2 �͹���ʦ 5 �õ������Ŷӱ���ֵ������ֵΪ performance = (2 + 10 + 5) * min(5, 4, 7) = 68 ��
 * ʾ�� 3��
 * <p>
 * ���룺n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
 * �����72
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 10^5
 * speed.length == n
 * efficiency.length == n
 * 1 <= speed[i] <= 10^5
 * 1 <= efficiency[i] <= 10^8
 * 1 <= k <= n
 * ͨ������2,079�ύ����7,347
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-performance-of-a-team
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxPerformance {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = speed[i];
            items[i][1] = efficiency[i];
        }
        Arrays.sort(items, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            if (queue.size() > k - 1) {
                sum -= queue.poll();
            }
            res = Math.max(res, (sum + items[i][0]) * items[i][1]);
            queue.add(items[i][0]);
            sum += items[i][0];
        }
        return (int) (res % ((int) 1e9 + 7));
    }
}
