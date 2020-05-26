package com.leetcode.offer.code;

/**
 * @author duson
 * ��������ͼ�ı�?edges���Լ���ͼ��ʼ��?source?��Ŀ���յ�?destination��ȷ����ʼ��?source?����������·���Ƿ����ս�����Ŀ���յ�?destination������
 * <p>
 * ��ʼ��?source ��Ŀ���յ�?destination ��������һ��·��
 * ������ڴ�ʼ��?source ��û�г��ߵĽڵ��·������ýڵ����·���յ㡣
 * ��ʼ��source��Ŀ���յ�?destination ����·��������������
 * ����ʼ��?source ����������·�������Ե���Ŀ���յ�?destination ʱ����?true�����򷵻� false��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
 * �����false
 * ˵�����ڵ� 1 �ͽڵ� 2 �����Ե����Ҳ�Ῠ�����
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
 * �����false
 * ˵���������ֿ��ܣ��ڽڵ� 3 �������������ڽڵ� 1 �ͽڵ� 2 ֮������ѭ����
 * ʾ�� 3��
 * <p>
 * <p>
 * <p>
 * ���룺n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
 * �����true
 * ʾ�� 4��
 * <p>
 * <p>
 * <p>
 * ���룺n = 3, edges = [[0,1],[1,1],[1,2]], source = 0, destination = 2
 * �����false
 * ˵������ʼ�����������·������Ŀ���յ���������������޶��·������ 0-1-2��0-1-1-2��0-1-1-1-2��0-1-1-1-1-2 �ȡ�
 * ʾ�� 5��
 * <p>
 * <p>
 * <p>
 * ���룺n = 2, edges = [[0,1],[1,1]], source = 0, destination = 1
 * �����false
 * ˵������Ŀ��ڵ��ϴ������޵��Ի���
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * ������ͼ�п��ܴ����Ի���ƽ�бߡ�
 * ͼ�еĽڵ���?n?����?1 ��?10000?֮�䡣
 * ͼ�еı�����?0 ��?10000?֮�䡣
 * 0 <= edges.length <= 10000
 * edges[i].length == 2
 * 0 <= source <= n - 1
 * 0 <= destination <= n - 1
 * ͨ������964�ύ����3,153
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/all-paths-from-source-lead-to-destination
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeadsToDestination {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        if (n <= 0 || edges == null || edges.length == 0) {
            return true;
        }
        Node[] graph = new Node[n];
        for (int[] edge : edges) {
            graph[edge[0]] = new Node(edge[1], graph[edge[0]]);
        }
        if (graph[destination] != null) {
            return false;
        }
        int[] visited = new int[n];
        return dfs(source, destination, graph, visited);
    }

    private boolean dfs(int start, int end, Node[] graph, int[] visited) {
        if (visited[start] == 1) {
            return false;
        }
        if (visited[start] == -1) {
            return true;
        }
        if (start == end) {
            visited[start] = -1;
            return true;
        }
        visited[start] = 1;
        Node cur = graph[start];
        if (cur == null) {
            return false;
        }
        while (cur != null) {
            if (!dfs(cur.ver, end, graph, visited)) {
                return false;
            }
            cur = cur.next;
        }
        visited[start] = -1;
        return true;
    }
}

class Node {
    int ver;
    Node next;

    Node(int ver, Node next) {
        this.ver = ver;
        this.next = next;
    }
}
