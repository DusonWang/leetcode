package code.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * ����һ����ά����?grid��?"."?����һ���շ��䣬?"#"?����һ��ǽ��?"@"?����㣬��"a",?"b", ...������Կ�ף���"A",?"B", ...����������
 * <p>
 * ���Ǵ���㿪ʼ������һ���ƶ���ָ���ĸ���������֮һ����һ����λ�ռ䡣���ǲ����������������ߣ�Ҳ�޷�����һ��ǽ�����;��һ��Կ�ף����ǾͰ������������������������ж�Ӧ��Կ�ף������޷�ͨ������
 * <p>
 * ���� K ΪԿ��/���ĸ�����������?1 <= K <= 6����ĸ���е�ǰ K ����ĸ�������ж����Լ���Ӧ��һ��Сд��һ����д��ĸ������֮��ÿ������Ψһ��Ӧ��Կ�ף�ÿ��Կ��Ҳ��Ψһ��Ӧ���������⣬����Կ�׺�������ĸ��Ϊ��Сд������ĸ˳�����С�
 * <p>
 * ���ػ�ȡ����Կ������Ҫ���ƶ������ٴ���������޷���ȡ����Կ�ף�����?-1?��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺["@.a.#"],
 * ["###.#"],
 * ["b.A.B"]
 * �����8
 * ʾ�� 2��
 * <p>
 * ���룺["@..aA"]
 * ["..B#."]
 * ["....b"]
 * �����6
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= grid.length?<= 30
 * 1 <= grid[0].length?<= 30
 * grid[i][j]?ֻ����?'.',?'#',?'@',?'a'-'f'?�Լ�?'A'-'F'
 * Կ�׵���Ŀ��Χ��?[1, 6]��ÿ��Կ�׶���Ӧһ����ͬ����ĸ�����ô�һ����Ӧ������
 * ͨ������2,587�ύ����5,808
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shortest-path-to-get-all-keys
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ShortestPathAllKeys {

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int si = -1;
        int sj = -1;
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    si = i;
                    sj = j;
                }
                if (isKey(c)) {
                    k++;
                }
            }
        }
        Node start = new Node(si, sj, 0);
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(si + " " + sj + " " + 0);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur == null) {
                    continue;
                }
                if (cur.key == (1 << k) - 1) {
                    return level;
                }
                for (int[] d : dirs) {
                    int x = cur.i + d[0];
                    int y = cur.j + d[1];
                    int key = cur.key;
                    if (!isValid(grid, x, y, m, n)) {
                        continue;
                    }
                    char c = grid[x].charAt(y);
                    if (isKey(c)) {
                        key |= (1 << (c - 'a'));
                    }
                    if (isLock(c) && (key >> (c - 'A') & 1) == 0) {
                        continue;
                    }
                    if (visited.add(x + " " + y + " " + key)) {
                        q.offer(new Node(x, y, key));
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private boolean isLock(char c) {
        return c >= 'A' && c <= 'F';
    }

    private boolean isKey(char c) {
        return c >= 'a' && c <= 'f';
    }

    private boolean isValid(String[] grid, int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n && grid[i].charAt(j) != '#';
    }

    static class Node {
        private int i, j, key;

        public Node(int i, int j, int key) {
            this.i = i;
            this.j = j;
            this.key = key;
        }
    }
}
