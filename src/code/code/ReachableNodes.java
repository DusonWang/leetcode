package code.code;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * ����һ������ͼ��ԭʼͼ����ͼ���� n ���ڵ㣬��Ŵ� 0 �� n - 1 ���������ͼ�е�ÿ����ϸ��Ϊһ���ڵ�����ÿ����֮����½ڵ���������ͬ��
 * <p>
 * ͼ���ɱ���ɵĶ�ά���� edges ��ʾ������?edges[i] = [ui, vi, cnti] ��ʾԭʼͼ�нڵ�?ui ��?vi ֮�����һ���ߣ�cnti �ǽ���ϸ�ֺ���½ڵ�������ע�⣬cnti == 0 ��ʾ�߲���ϸ�֡�
 * <p>
 * Ҫϸ�ֱ� [ui, vi] ����Ҫ�����滻Ϊ (cnti + 1) ���±ߣ���?cnti ���½ڵ㡣�½ڵ�Ϊ x1, x2, ..., xcnti ���±�Ϊ [ui, x1], [x1, x2], [x2, x3], ..., [xcnti+1, xcnti], [xcnti, vi] ��
 * <p>
 * ���ڵõ�һ���µ� ϸ��ͼ ���������ӽڵ� 0 ���������Ե�����ٸ��ڵ㣿�ڵ� �Ƿ���Ե�����ж����� Ϊ������ڵ������� maxMoves ����٣�����Ϊ���Ե�����򣬲��ɵ��
 * <p>
 * ����ԭʼͼ�� maxMoves �������µ�ϸ��ͼ�дӽڵ� 0 ���� �ɵ���Ľڵ��� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
 * �����13
 * ���ͣ��ߵ�ϸ���������ͼ��ʾ��
 * ���Ե���Ľڵ��Ѿ��û�ɫ��ע������
 * ʾ�� 2��
 * <p>
 * ���룺edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4
 * �����23
 * ʾ�� 3��
 * <p>
 * ���룺edges = [[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]], maxMoves = 17, n = 5
 * �����1
 * ���ͣ��ڵ� 0 ��ͼ�����ಿ��û����ͨ������ֻ�нڵ� 0 ���Ե��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= edges.length <= min(n * (n - 1) / 2, 104)
 * edges[i].length == 3
 * 0 <= ui < vi < n
 * ͼ�� ������ƽ�б�
 * 0 <= cnti <= 104
 * 0 <= maxMoves <= 109
 * 1 <= n <= 3000
 * ͨ������1,283�ύ����2,798
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reachable-nodes-in-subdivided-graph
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ReachableNodes {

    public int reachableNodes(int[][] edges, int m, int n) {
        HashMap<Integer, HashMap<Integer, Integer>> e = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            e.put(i, new HashMap<>());
        }
        for (int[] v : edges) {
            e.get(v[0]).put(v[1], v[2]);
            e.get(v[1]).put(v[0], v[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        pq.offer(new int[]{m, 0});
        HashMap<Integer, Integer> seen = new HashMap<>();
        while (!pq.isEmpty()) {
            int moves = pq.peek()[0];
            int i = pq.peek()[1];
            pq.poll();
            if (!seen.containsKey(i)) {
                seen.put(i, moves);
                for (int j : e.get(i).keySet()) {
                    int mm = moves - e.get(i).get(j) - 1;
                    if (!seen.containsKey(j) && mm >= 0) {
                        pq.offer(new int[]{mm, j});
                    }
                }
            }
        }
        int res = seen.size();
        for (int[] v : edges) {
            int a = seen.getOrDefault(v[0], 0);
            int b = seen.getOrDefault(v[1], 0);
            res += Math.min(a + b, v[2]);
        }
        return res;
    }
}
