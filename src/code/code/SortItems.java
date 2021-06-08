package code.code;

import java.util.*;

/**
 * �� n ����Ŀ��ÿ����Ŀ���߲������κ�С�飬�������� m ��С��֮һ��group[i] ��ʾ�� i ����Ŀ������С�飬����� i ����Ŀ�������κ�С�飬�� group[i] ���� -1����Ŀ��С�鶼�Ǵ��㿪ʼ��ŵġ����ܴ���С�鲻�����κ���Ŀ����û���κ���Ŀ�������С�顣
 * <p>
 * �����æ��Ҫ������Щ��Ŀ�Ľ��ȣ���������������Ŀ�б�
 * <p>
 * ͬһС�����Ŀ����������б��б˴����ڡ�
 * ��Ŀ֮�����һ����������ϵ��������һ���б� beforeItems����ʾ������beforeItems[i]��ʾ�ڽ��е�i����Ŀǰ��λ�ڵ� i����Ŀ��ࣩӦ����ɵ�������Ŀ��
 * ������ڶ�����������ֻ��Ҫ������������һ�����ɡ����û�к��ʵĽ�����������뷵��һ�� ���б� ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
 * �����[6,3,4,1,5,2,0,7]
 * ʾ��2��
 * <p>
 * ���룺n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
 * �����[]
 * ���ͣ���ʾ�� 1 ������ͬ���������������б��У�4 ������� 6 ��ǰ�档
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= m <= n <= 3 * 104
 * group.length == beforeItems.length == n
 * -1 <= group[i] <= m - 1
 * 0 <= beforeItems[i].length <= n - 1
 * 0 <= beforeItems[i][j] <= n - 1
 * i != beforeItems[i][j]
 * beforeItems[i] �����ظ�Ԫ��
 * ͨ������11,796�ύ����18,739
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sort-items-by-groups-respecting-dependencies
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SortItems {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> groupItem = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < n + m; ++i) {
            groupItem.add(new ArrayList<>());
            groupGraph.add(new ArrayList<>());
        }
        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            itemGraph.add(new ArrayList<>());
        }
        int[] groupDegree = new int[n + m];
        int[] itemDegree = new int[n];
        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < n + m; ++i) {
            id.add(i);
        }
        int leftId = m;
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = leftId;
                leftId += 1;
            }
            groupItem.get(group[i]).add(i);
        }
        for (int i = 0; i < n; ++i) {
            int curGroupId = group[i];
            for (int item : beforeItems.get(i)) {
                int beforeGroupId = group[item];
                if (beforeGroupId == curGroupId) {
                    itemDegree[i] += 1;
                    itemGraph.get(item).add(i);
                } else {
                    groupDegree[curGroupId] += 1;
                    groupGraph.get(beforeGroupId).add(curGroupId);
                }
            }
        }

        // ������˹�ϵ����
        List<Integer> groupTopSort = topSort(groupDegree, groupGraph, id);
        if (groupTopSort.size() == 0) {
            return new int[0];
        }
        int[] ans = new int[n];
        int index = 0;
        // �������˹�ϵ����
        for (int curGroupId : groupTopSort) {
            int size = groupItem.get(curGroupId).size();
            if (size == 0) {
                continue;
            }
            List<Integer> res = topSort(itemDegree, itemGraph, groupItem.get(curGroupId));
            if (res.size() == 0) {
                return new int[0];
            }
            for (int item : res) {
                ans[index++] = item;
            }
        }
        return ans;
    }

    public List<Integer> topSort(int[] deg, List<List<Integer>> graph, List<Integer> items) {
        Queue<Integer> queue = new LinkedList<>();
        for (int item : items) {
            if (deg[item] == 0) {
                queue.offer(item);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res.add(u);
            for (int v : graph.get(u)) {
                if (--deg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return res.size() == items.size() ? res : new ArrayList<>();
    }
}
