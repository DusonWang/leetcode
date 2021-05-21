package code.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 给定一个二维网格?grid。?"."?代表一个空房间，?"#"?代表一堵墙，?"@"?是起点，（"a",?"b", ...）代表钥匙，（"A",?"B", ...）代表锁。
 * <p>
 * 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
 * <p>
 * 假设 K 为钥匙/锁的个数，且满足?1 <= K <= 6，字母表中的前 K 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
 * <p>
 * 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回?-1?。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：["@.a.#"],
 * ["###.#"],
 * ["b.A.B"]
 * 输出：8
 * 示例 2：
 * <p>
 * 输入：["@..aA"]
 * ["..B#."]
 * ["....b"]
 * 输出：6
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length?<= 30
 * 1 <= grid[0].length?<= 30
 * grid[i][j]?只含有?'.',?'#',?'@',?'a'-'f'?以及?'A'-'F'
 * 钥匙的数目范围是?[1, 6]，每个钥匙都对应一个不同的字母，正好打开一个对应的锁。
 * 通过次数2,587提交次数5,808
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-to-get-all-keys
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
