package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * ��һ�� N ���ˣ����Ϊ?0, 1, 2, ..., N-1���У�ÿ���˶��в�ͬ��Ŀ��Ǯ���Լ���ͬ�̶ȵİ�����quietness����
 * <p>
 * Ϊ�˷�����������ǽ����Ϊ?x?���˼��Ϊ "person?x?"��
 * <p>
 * ����ܹ��϶� person?x?�� person?y?����Ǯ�Ļ������ǻ�˵?richer[i] = [x, y]?��ע��?richer?����ֻ����Ч�۲��һ���Ӽ���
 * <p>
 * ���⣬��� person?x?�İ����̶�Ϊ?q?�����ǻ�˵?quiet[x] = q?��
 * <p>
 * ���ڣ����ش�?answer?������?answer[x] = y?��ǰ���ǣ�������ӵ�е�Ǯ������?person?x?�����У�person?y?��������ˣ�Ҳ���ǰ���ֵ?quiet[y]?��С���ˣ���
 * <p>
 * ʾ����
 * <p>
 * ���룺richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * �����[5,5,2,5,4,5,6,7]
 * ���ͣ�
 * answer[0] = 5��
 * person 5 �� person 3 �и����Ǯ��person 3 �� person 1 �и����Ǯ��person 1 �� person 0 �и����Ǯ��
 * Ψһ��Ϊ�������нϵ͵İ���ֵ quiet[x]�������� person 7��
 * ����Ŀǰ����������Ƿ�� person 0 ����Ǯ��
 * <p>
 * answer[7] = 7��
 * ������ӵ�е�Ǯ�϶������� person 7 ������(����ܰ��� person 3��4��5��6 �Լ� 7)��
 * ���(�нϵͰ���ֵ quiet[x])������ person 7��
 * <p>
 * �����Ĵ�Ҳ���������Ƶ����������͡�
 * ��ʾ��
 * <p>
 * 1 <= quiet.length = N <= 500
 * 0 <= quiet[i] < N������?quiet[i]?������ͬ��
 * 0 <= richer.length <= N * (N-1) / 2
 * 0 <= richer[i][j] < N
 * richer[i][0] != richer[i][1]
 * richer[i]?���ǲ�ͬ�ġ�
 * ��?richer?�Ĺ۲����߼�����һ�µġ�
 * ͨ������1,780�ύ����4,069
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/loud-and-rich
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LoudAndRich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int m = quiet.length;
        int[] answers = new int[m];
        for (int i = 0; i < m; i++) {
            answers[i] = -1;
        }
        List<Integer>[] graph = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : richer) {
            graph[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < m; i++) {
            dfs(graph, quiet, i, answers);
        }
        return answers;
    }

    private int dfs(List<Integer>[] graph, int[] quiet, int node, int[] answers) {
        if (answers[node] == -1) {
            answers[node] = node;
            for (int richer : graph[node]) {
                int child = dfs(graph, quiet, richer, answers);
                if (quiet[child] < quiet[answers[node]]) {
                    answers[node] = child;
                }
            }
        }
        return answers[node];
    }
}
