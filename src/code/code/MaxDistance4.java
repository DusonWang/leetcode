package code.code;

import java.util.Arrays;

/**
 * �ڴ���Ϊ C-137 �ĵ����ϣ�Rick �����������������������·��������������֮����γ�������ʽ�Ĵ�����Rick ��?n?���յ����ӣ���?i?�����ӵ�λ����?position[i]?��Morty?���?m?����ŵ���Щ�����ʹ�����������?��С����?���
 * <p>
 * ��֪����������ֱ�λ��?x?��?y?����ô����֮��Ĵ���Ϊ?|x - y|?��
 * <p>
 * ����һ����������?position?��һ������?m?�����㷵����󻯵���С������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺position = [1,2,3,4,7], m = 3
 * �����3
 * ���ͣ��� 3 ����ֱ����λ�� 1��4 �� 7 ���������ӣ������Ĵ����ֱ�Ϊ [3, 3, 6]����С����Ϊ 3 ������û�취����С�������� 3 ��
 * ʾ�� 2��
 * <p>
 * ���룺position = [5,4,3,2,1,1000000000], m = 2
 * �����999999999
 * ���ͣ�����ʹ��λ�� 1 �� 1000000000 ������ʱ��С�������
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * ����?position?�е����� ������ͬ?��
 * 2 <= m <= position.length
 * ͨ������7,941�ύ����15,739
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/magnetic-force-between-two-balls
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxDistance4 {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int x, int[] position, int m) {
        int pre = position[0];
        int cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }
}
