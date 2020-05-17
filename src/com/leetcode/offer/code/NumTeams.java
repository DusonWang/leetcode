package com.leetcode.offer.code;

/**
 * @author duson
 * n ��ʿ��վ��һ�š�ÿ��ʿ������һ�� ��һ�޶� ������ rating ��
 * <p>
 * ÿ 3 ��ʿ���������һ����ս��λ������������£�
 * <p>
 * �Ӷ�����ѡ���±�ֱ�Ϊ i��j��k �� 3 ��ʿ�������ǵ����ֱַ�Ϊ rating[i]��rating[j]��rating[k]
 * ��ս��λ�����㣺 rating[i] < rating[j] < rating[k] ���� rating[i] > rating[j] > rating[k] ������? 0?<= i <?j <?k <?n
 * ���㷵�ذ��������������齨����ս��λ������ÿ��ʿ���������Ƕ����ս��λ��һ���֡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺rating = [2,5,3,4,1]
 * �����3
 * ���ͣ����ǿ����齨������ս��λ (2,3,4)��(5,4,1)��(5,3,1) ��
 * ʾ�� 2��
 * <p>
 * ���룺rating = [2,1,3]
 * �����0
 * ���ͣ�������Ŀ�����������޷��齨��ս��λ��
 * ʾ�� 3��
 * <p>
 * ���룺rating = [1,2,3,4]
 * �����4
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * n == rating.length
 * 1 <= n <= 200
 * 1 <= rating[i] <= 10^5
 * ͨ������5,698�ύ����6,922
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-number-of-teams
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumTeams {

    public int numTeams(int[] rating) {
        int count = 0;
        for (int j = 1; j < rating.length - 1; j++) {
            int smaller = 0, larger = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    smaller++;
                }
            }
            for (int k = j + 1; k < rating.length; k++) {
                if (rating[k] > rating[j]) {
                    larger++;
                }
            }
            count += smaller * larger;
            count += (j - smaller) * (rating.length - (j + 1) - larger);
        }
        return count;
    }
}
