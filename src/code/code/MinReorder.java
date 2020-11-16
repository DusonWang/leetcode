package code.code;

import java.util.*;

/**
 * @author duson
 * n �����У��� 0 �� n-1 ��ţ���乲�� n-1 ��·�ߡ���ˣ�Ҫ����������ͬ����֮������ֻ��Ψһһ��·�߿ɹ�ѡ��·�����γ�һ��������ȥ�꣬��ͨ���䲿�������¹滮·�ߣ��Ըı佻ͨӵ�µ�״����
 * <p>
 * ·���� connections ��ʾ������ connections[i] = [a, b] ��ʾ�ӳ��� a �� b ��һ������·�ߡ�
 * <p>
 * ���꣬���� 0 ����ٰ�һ�����ͱ������ܶ��οͶ���ǰ������ 0 ��
 * <p>
 * ����������¹滮·�߷���ʹÿ�����ж����Է��ʳ��� 0 ��������Ҫ����������С·������
 * <p>
 * ��Ŀ���� ��֤ ÿ�����������¹滮·�߷�����ܵ������ 0 ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * �����3
 * ���ͣ������Ժ�ɫ��ʾ��·�ߵķ���ʹÿ�����ж����Ե������ 0 ��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * �����2
 * ���ͣ������Ժ�ɫ��ʾ��·�ߵķ���ʹÿ�����ж����Ե������ 0 ��
 * ʾ�� 3��
 * <p>
 * ���룺n = 3, connections = [[1,0],[2,0]]
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 * ͨ������2,503�ύ����4,560
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinReorder {

    public int minReorder(int n, int[][] connections) {
        int result = 0;
        Map<Integer, Set<Integer>> connIdx = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < connections.length; i++) {
            int city1 = connections[i][0];
            int city2 = connections[i][1];
            if (!connIdx.containsKey(city1)) {
                connIdx.put(city1, new HashSet<>());
            }
            connIdx.get(city1).add(i);
            if (!connIdx.containsKey(city2)) {
                connIdx.put(city2, new HashSet<>());
            }
            connIdx.get(city2).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : connIdx.get(curr)) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                int a = connections[i][0];
                int b = connections[i][1];

                result += ((a == curr) ? 1 : 0);
                a = ((a == curr) ? b : a);
                queue.offer(a);
            }
        }
        return result;
    }
}
