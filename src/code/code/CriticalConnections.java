package code.code;

import java.util.*;

/**
 * ��������������n̨���������ֱ𰴴�0��n-1�ķ�ʽ�����˱�š�
 * <p>
 * ����֮���ԡ�������������������Ե����ʽ�໥���������һ���ڲ���Ⱥ����������connections ������ġ�
 * <p>
 * ����ʽ�Ͻ���connections[i] = [a, b]��ʾ������ a�� b֮���γ����ӡ��κη�����������ֱ�ӻ��߼�ӵ�ͨ�����絽���κ�������������
 * <p>
 * ���ؼ����ӡ����ڸü�Ⱥ�е���Ҫ���ӣ�Ҳ����˵���������ǽ����Ƴ�����ᵼ��ĳЩ�������޷�����������������
 * <p>
 * ����������˳�򷵻ظü�Ⱥ�ڵ����� ���ؼ����ӡ���
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * �����[[1,3]]
 * ���ͣ�[[3,1]] Ҳ����ȷ�ġ�
 *
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * �������ظ�������
 * ͨ������3,519�ύ����7,058
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/critical-connections-in-a-network
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CriticalConnections {

    private final List<List<Integer>> res = new ArrayList<>();
    private int[] count;
    private final Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for (List<Integer> conn : connections) {
            map.computeIfAbsent(conn.get(0), k -> new ArrayList<>()).add(conn.get(1));
            map.computeIfAbsent(conn.get(1), k -> new ArrayList<>()).add(conn.get(0));
        }
        count = new int[n];
        dfs(0, -1, 1);
        return res;
    }

    private int dfs(int cur, int parent, int time) {
        count[cur] = time;
        for (int neighbor : map.getOrDefault(cur, new ArrayList<>())) {
            if (neighbor == parent) {
                continue;
            }
            if (count[neighbor] != 0) {
                count[cur] = Math.min(count[cur], count[neighbor]);
            } else {
                count[cur] = Math.min(count[cur], dfs(neighbor, cur, time + 1));
            }
            if (time < count[neighbor]) {
                res.add(Arrays.asList(cur, neighbor));
            }
        }
        return count[cur];
    }

}
