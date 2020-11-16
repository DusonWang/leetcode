package code.code;

import java.util.Arrays;

/**
 * @author duson
 * ����һ�������б�����ɾ���б��б��������������ǵ����䡣
 * <p>
 * ֻ�е�?c <= a?��?b <= d?ʱ�����ǲ���Ϊ����?[a,b) ������?[c,d) ���ǡ�
 * <p>
 * ���������ɾ�����������㷵���б���ʣ���������Ŀ��
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺intervals = [[1,4],[3,6],[2,8]]
 * �����2
 * ���ͣ����� [3,6] ������ [2,8] ���ǣ���������ɾ���ˡ�
 * ?
 * <p>
 * ��ʾ��??????
 * <p>
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] <?intervals[i][1] <= 10^5
 * �������е�?i != j��intervals[i] != intervals[j]
 * ͨ������2,444�ύ����4,355
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/remove-covered-intervals
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 1;
        int r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (r < intervals[i][1]) {
                r = intervals[i][1];
                count++;
            }
        }
        return count;
    }
}
