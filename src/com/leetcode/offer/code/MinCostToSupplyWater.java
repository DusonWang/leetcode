package com.leetcode.offer.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author duson
 * ������һ���� n �����ӡ�����ϣ��ͨ������ˮ��������ܵ���Ϊ���з��ӹ�ˮ��
 * <p>
 * ����ÿ������?i�����������ֿ�ѡ�Ĺ�ˮ������
 * <p>
 * һ����ֱ���ڷ����ڽ���ˮ�����ɱ�Ϊ?wells[i]��
 * ��һ���Ǵ���һ�ھ�����ܵ���ˮ������?pipes?�������ڷ��Ӽ�����ܵ��ĳɱ�������ÿ��?pipes[i] = [house1, house2, cost]?�����ùܵ���?house1?��?house2?������һ��ĳɱ�����Ȼ��������˫��ġ�
 * �����æ����Ϊ���з��Ӷ���ˮ������ܳɱ���
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * <p>
 * <p>
 * ���룺n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
 * �����3
 * ���ͣ�
 * ��ͼչʾ������ܵ����ӷ��ݵĳɱ���
 * ��õĲ������ڵ�һ�������ｨ��ˮ�����ɱ�Ϊ 1����Ȼ��������������ܵ����������ɱ�Ϊ 2���������ܳɱ�Ϊ 3��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n?<= 10000
 * wells.length == n
 * 0 <= wells[i] <= 10^5
 * 1 <= pipes.length <= 10000
 * 1 <= pipes[i][0], pipes[i][1] <= n
 * 0 <= pipes[i][2] <= 10^5
 * pipes[i][0] != pipes[i][1]
 * ͨ������670�ύ����1,480
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/optimize-water-distribution-in-a-village
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinCostToSupplyWater {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int ans = 0;
        int[] costs = new int[n + 1];
        int[] roots = new int[n + 1];
        for (int idx = 1; idx <= n; ++idx) {
            roots[idx] = idx;
            costs[idx] = wells[idx - 1];
            ans += wells[idx - 1];
        }
        Arrays.sort(pipes, Comparator.comparingInt(o -> o[2]));

        for (int[] edge : pipes) {
            int vex0 = edge[0], vex1 = edge[1], cost = edge[2];
            int root1 = findRoot(vex0, roots), root2 = findRoot(vex1, roots);
            if (root1 == root2) {
                continue;
            }
            if (costs[root1] > costs[root2] && costs[root1] > cost) {
                roots[root1] = root2;
                ans += cost - costs[root1];
            } else if (costs[root2] > cost) {
                roots[root2] = root1;
                ans += cost - costs[root2];
            }
        }
        return ans;
    }

    private int findRoot(int idx, int[] roots) {
        while (roots[idx] != idx) {
            roots[idx] = roots[roots[idx]];
            idx = roots[idx];
        }
        return idx;
    }
}
