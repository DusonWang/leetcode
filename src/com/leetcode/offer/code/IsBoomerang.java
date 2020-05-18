package com.leetcode.offer.code;

/**
 * @author duson
 * �����ڶ���Ϊһ�������㣬��Щ�������ͬ�Ҳ���һ��ֱ���ϡ�
 * <p>
 * ����ƽ������������ɵ��б��ж���Щ���Ƿ���Թ��ɻ����ڡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[[1,1],[2,3],[3,2]]
 * �����true
 * ʾ�� 2��
 * <p>
 * ���룺[[1,1],[2,2],[3,3]]
 * �����false
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * points.length == 3
 * points[i].length == 2
 * 0 <= points[i][j] <= 100
 * ͨ������4,543�ύ����10,790
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/valid-boomerang
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsBoomerang {

    public boolean isBoomerang(int[][] points) {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0])
                != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }
}
