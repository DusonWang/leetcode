package com.leetcode.offer.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * ������һ����ļ��ϣ����е�?i?���ֵΪ?values[i]����ǩΪ?labels[i]��
 * <p>
 * ���Ǵ���Щ����ѡ��һ���Ӽ�?S������һ����
 * <p>
 * |S| <= num_wanted
 * ��������ı�ǩ L���Ӽ� S �б�ǩΪ L?�������Ŀ������?<= use_limit��
 * �����Ӽ�?S?�������ܵ�?�͡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * �����9
 * ���ͣ�ѡ�����Ӽ��ǵ�һ�������͵����
 * ʾ�� 2��
 * <p>
 * ���룺values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 * �����12
 * ���ͣ�ѡ�����Ӽ��ǵ�һ��ڶ���͵����
 * ʾ�� 3��
 * <p>
 * ���룺values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
 * �����16
 * ���ͣ�ѡ�����Ӽ��ǵ�һ��͵����
 * ʾ�� 4��
 * <p>
 * ���룺values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
 * �����24
 * ���ͣ�ѡ�����Ӽ��ǵ�һ��ڶ���͵����
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= values.length == labels.length <= 20000
 * 0 <= values[i], labels[i]?<= 20000
 * 1 <= num_wanted, use_limit?<= values.length
 * ͨ������1,998�ύ����3,927
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/largest-values-from-labels
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * @author duson
 */
public class LargestValsFromLabels {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int len = values.length;
        int[][] items = new int[len][2];
        for (int i = 0; i < len; ++i) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }
        Arrays.sort(items, Comparator.comparingInt(i -> -i[0]));
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] item : items) {
            int labelCount = map.getOrDefault(item[1], 0);
            if (labelCount < useLimit) {
                res += item[0];
                if (--numWanted == 0) {
                    break;
                }
                map.put(item[1], labelCount + 1);
            }
        }
        return res;
    }
}
