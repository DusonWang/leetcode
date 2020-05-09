package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * ��������ÿ���ʱ��������ְ����׬Щ�㻨Ǯ��
 * <p>
 * ������?n?�ݼ�ְ������ÿ�ݹ���Ԥ�ƴ�?startTime[i]?��ʼ��?endTime[i]?����������Ϊ?profit[i]��
 * <p>
 * ����һ�ݼ�ְ������������ʼʱ��?startTime������ʱ��?endTime?��Ԥ�Ʊ���?profit?�������飬������㲢���ؿ��Ի�õ���󱨳ꡣ
 * <p>
 * ע�⣬ʱ���ϳ����ص��� 2 �ݹ�������ͬʱ���С�
 * <p>
 * �����ѡ��Ĺ�����ʱ��?X?��������ô��������̽�����ʱ��?X?��ʼ����һ�ݹ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * �����120
 * ���ͣ�
 * ����ѡ���� 1 �ݺ͵� 4 �ݹ�����
 * ʱ�䷶Χ�� [1-3]+[3-6]������ñ��� 120 = 50 + 70��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * �����150
 * ���ͣ�
 * ����ѡ��� 1��4��5 �ݹ�����
 * ����ñ��� 150 = 20 + 70 + 60��
 * ʾ�� 3��
 * <p>
 * <p>
 * <p>
 * ���룺startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * �����6
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= startTime.length == endTime.length ==?profit.length?<= 5 * 10^4
 * 1 <=?startTime[i] <?endTime[i] <= 10^9
 * 1 <=?profit[i] <= 10^4
 * ͨ������1,919�ύ����4,570
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class JobScheduling {

    static class Job implements Comparable<Job> {
        int start;
        int end;
        int profit;

        public Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }

        @Override
        public int compareTo(Job other) {
            return this.end - other.end;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int num = startTime.length;
        if (num == 0) {
            return 0;
        }
        int[] ans = new int[num];
        Job[] jobs = new Job[num];
        for (int i = 0; i < num; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
            ans[i] = 0;
        }
        Arrays.sort(jobs);
        int i, j;
        ans[0] = jobs[0].profit;
        int ret = Integer.MIN_VALUE;
        for (i = 1; i < num; i++) {
            ans[i] = Math.max(jobs[i].profit, ans[i - 1]);
            ret = Math.max(ret, ans[i]);
            for (j = i - 1; j >= 0; j--) {
                if (jobs[i].start >= jobs[j].end) {
                    ans[i] = Math.max(ans[i], ans[j] + jobs[i].profit);
                    ret = Math.max(ret, ans[i]);
                    break;
                }
            }
        }
        return ret;
    }
}
