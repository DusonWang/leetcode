package code.code;

/**
 * ���������Ǹ�����?low ��?high?�����㷵��?low ��?high?֮�䣨�������ߣ���������Ŀ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺low = 3, high = 7
 * �����3
 * ���ͣ�3 �� 7 ֮����������Ϊ [3,5,7] ��
 * ʾ�� 2��
 * <p>
 * ���룺low = 8, high = 10
 * �����1
 * ���ͣ�8 �� 10 ֮����������Ϊ [9] ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= low <= high?<= 10^9
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-odd-numbers-in-an-interval-range
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountOdds {

    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        } else {
            return (high - low) / 2 + 1;
        }
    }
}
