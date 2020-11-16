package code.code;

import java.util.*;

/**
 * @author duson
 * ������һϵ�й���·�ߡ�ÿһ��·�� routes[i]?�϶���һ��������������ѭ����ʻ�����磬��һ��·��?routes[0] = [1, 5, 7]����ʾ��һ�� (�±�Ϊ0) ��������һֱ����?1->5->7->1->5->7->1->...?�ĳ�վ·����ʻ��
 * <p>
 * �������Ǵ�?S?��վ��ʼ����ʼʱ���ڹ������ϣ���Ҫȥ��?T?վ�� �ڼ���ɳ�����������������ٳ����Ĺ��������������� -1 ��ʾ�����ܵ����յ㳵վ��
 * <p>
 * ʾ��:
 * ����:
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * ���: 2
 * ����:
 * ���Ų������ȳ�����һ�����������ﳵվ 7, Ȼ�󻻳˵ڶ�������������վ 6��
 * ˵��:
 * <p>
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 500.
 * 0 <= routes[i][j] < 10 ^ 6.
 * ͨ������3,147�ύ����10,140
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/bus-routes
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumBusesToDestination {

    public int numBusesToDestination(int[][] routes, int s, int t) {
        if (routes == null || routes.length == 0 || s == t) {
            return 0;
        }
        Map<Integer, Set<Integer>> stopToBussesMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBussesMap.putIfAbsent(stop, new HashSet<>());
                stopToBussesMap.get(stop).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int busCount = 0;
        Set<Integer> bussTaken = new HashSet<>();
        while (!queue.isEmpty()) {
            for (int count = queue.size(); count > 0; count--) {
                int stop = queue.poll();
                if (stop == t) {
                    return busCount;
                }
                for (int bus : stopToBussesMap.get(stop)) {
                    if (bussTaken.add(bus)) {
                        for (int nextStop : routes[bus]) {
                            queue.offer(nextStop);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}
