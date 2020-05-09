package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 * <p>
 * 这里有?n?份兼职工作，每份工作预计从?startTime[i]?开始到?endTime[i]?结束，报酬为?profit[i]。
 * <p>
 * 给你一份兼职工作表，包含开始时间?startTime，结束时间?endTime?和预计报酬?profit?三个数组，请你计算并返回可以获得的最大报酬。
 * <p>
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 * <p>
 * 如果你选择的工作在时间?X?结束，那么你可以立刻进行在时间?X?开始的下一份工作。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * 输出：120
 * 解释：
 * 我们选出第 1 份和第 4 份工作，
 * 时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * 输出：150
 * 解释：
 * 我们选择第 1，4，5 份工作。
 * 共获得报酬 150 = 20 + 70 + 60。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * 输出：6
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= startTime.length == endTime.length ==?profit.length?<= 5 * 10^4
 * 1 <=?startTime[i] <?endTime[i] <= 10^9
 * 1 <=?profit[i] <= 10^4
 * 通过次数1,919提交次数4,570
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
