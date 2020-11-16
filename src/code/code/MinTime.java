package code.code;


import java.util.*;

/**
 * ����һ����?n?���ڵ�����������ڵ���Ϊ?0?��?n-1?����������һЩ�ڵ���ƻ����ͨ�����ϵ�һ���ߣ���Ҫ���� 1 ���ӡ����?�ڵ� 0?���������㷵��������Ҫ�����룬�����ռ�������ƻ�������ص��ڵ� 0 ��
 * <p>
 * �������ı���?edges?����������?edges[i] = [fromi, toi]?����ʾ��һ��������?from?��?toi ���������⣬����һ����������?hasApple ������?hasApple[i] = true?����ڵ�?i?��һ��ƻ�������򣬽ڵ�?i?û��ƻ����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * �����8
 * ���ͣ���ͼչʾ�˸������������к�ɫ�ڵ��ʾ��ƻ����һ�����ռ�������ƻ�������ŷ�������ɫ��ͷ��ʾ��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
 * �����6
 * ���ͣ���ͼչʾ�˸������������к�ɫ�ڵ��ʾ��ƻ����һ�����ռ�������ƻ�������ŷ�������ɫ��ͷ��ʾ��
 * ʾ�� 3��
 * <p>
 * ���룺n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 10^5
 * edges.length == n-1
 * edges[i].length == 2
 * 0 <= fromi, toi <= n-1
 * fromi?< toi
 * hasApple.length == n
 * ͨ������2,751�ύ����5,985
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-time-to-collect-all-apples-in-a-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinTime {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> map = constructMap(edges);
        return helper(0, map, hasApple, new HashSet<>());
    }

    private int helper(int node, Map<Integer, List<Integer>> map, List<Boolean> hasApple, Set<Integer> visited) {
        visited.add(node);
        int res = 0;
        if (map.containsKey(node)) {
            for (int next : map.get(node)) {
                if (!visited.contains(next)) {
                    res += helper(next, map, hasApple, visited);
                }
            }
        }
        int sum = 0;
        if (res != 0) {
            sum += res + 2;
        } else if (hasApple.get(node)) {
            sum += 2;
        }
        if (node == 0 && sum > 0) {
            sum -= 2;
        }
        return sum;
    }

    private Map<Integer, List<Integer>> constructMap(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        return map;
    }
}
