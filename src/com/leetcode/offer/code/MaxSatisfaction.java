package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * һ����ʦ�ռ�����?n?���˵�����̶�?satisfaction?�������ʦ����ÿ���˵�ʱ�䶼�� 1 ��λʱ�䡣
 * <p>
 * һ���˵� ��ϲ��ʱ�䡹ϵ������Ϊ���������Լ�֮ǰÿ���������ѵ�ʱ���������˵�����̶ȣ�Ҳ����?time[i]*satisfaction[i]?��
 * <p>
 * ���㷵���������в� ��ϲ��ʱ�䡹�ܺ͵����ֵΪ���١�
 * <p>
 * ����԰�?����?˳�������˵�˳����Ҳ����ѡ�������ĳЩ������ø�����ܺ͡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺satisfaction = [-1,-8,0,5,-9]
 * �����14
 * ���ͣ�ȥ���ڶ��������һ���ˣ�����ϲ��ʱ��ϵ����Ϊ (-1*1 + 0*2 + 5*3 = 14) ��ÿ���˶���Ҫ���� 1 ��λʱ����ɡ�
 * ʾ�� 2��
 * <p>
 * ���룺satisfaction = [4,3,2]
 * �����20
 * ���ͣ�����ԭ��˳���෴��ʱ������ (2*1 + 3*2 + 4*3 = 20)
 * ʾ�� 3��
 * <p>
 * ���룺satisfaction = [-1,-4,-5]
 * �����0
 * ���ͣ���Ҷ���ϲ����Щ�ˣ����Բ����κβ˿��Ի������ϲ��ʱ��ϵ����
 * ʾ�� 4��
 * <p>
 * ���룺satisfaction = [-2,5,-1,0,3,-3]
 * �����35
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * n == satisfaction.length
 * 1 <= n <= 500
 * -10^3 <=?satisfaction[i] <= 10^3
 * ͨ������2,747�ύ����3,788
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reducing-dishes
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxSatisfaction {

    public int maxSatisfaction(int[] s) {
        int prevCo = 0, prevSum = 0;
        Arrays.sort(s);
        for(int i = s.length - 1; i > -1; i--) {
            int temp = prevCo + prevSum + s[i];
            if(temp < prevCo) {
                break;
            }
            prevCo = temp;
            prevSum += s[i];
        }
        return prevCo;
    }
}
