package code.code;

import java.util.Arrays;

/**
 * ����һ���������� jobs ������ jobs[i] ����ɵ� i ���Ҫ���ѵ�ʱ�䡣
 * <p>
 * ���㽫��Щ��������� k λ���ˡ����й�����Ӧ�÷�������ˣ���ÿ���ֻ�ܷ����һλ���ˡ����˵� ����ʱ�� ����ɷ�������ǵ����й�������ʱ����ܺ͡��������һ����ѵĹ������䷽����ʹ���˵� �����ʱ�� ���� ��С�� ��
 * <p>
 * ���ط��䷽���о����� ��С �� �����ʱ�� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺jobs = [3,2,3], k = 3
 * �����3
 * ���ͣ���ÿλ���˷���һ����������ʱ���� 3 ��
 * ʾ�� 2��
 * <p>
 * ���룺jobs = [1,2,4,7,8], k = 2
 * �����11
 * ���ͣ���������ʽ���乤����
 * 1 �Ź��ˣ�1��2��8������ʱ�� = 1 + 2 + 8 = 11��
 * 2 �Ź��ˣ�4��7������ʱ�� = 4 + 7 = 11��
 * �����ʱ���� 11 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 107
 * ͨ������6,746�ύ����14,111
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinimumTimeRequired {

    private int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        int[] personTime = new int[k];
        backtrack(jobs, personTime, 0);
        return res;

    }

    private void backtrack(int[] jobs, int[] personTime, int index) {
        if (index == jobs.length) {
            int maxTime = -1;
            for (int j : personTime) {
                maxTime = Math.max(j, maxTime);
            }
            res = Math.min(res, maxTime);
            return;
        }
        for (int i = 0; i < personTime.length; i++) {
            if (personTime[i] + jobs[index] >= res) {
                continue;
            }
            personTime[i] += jobs[index];
            backtrack(jobs, personTime, index + 1);
            personTime[i] -= jobs[index];
            if (personTime[i] == 0) {
                break;
            }
        }
    }
}
