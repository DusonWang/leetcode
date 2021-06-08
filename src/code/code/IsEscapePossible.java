package code.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 在一个 106 x 106 的网格中，每个网格上方格的坐标为(x, y) 。
 * <p>
 * 现在从源方格source = [sx, sy]开始出发，意图赶往目标方格target = [tx, ty] 。数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 * <p>
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表blocked上。同时，不允许走出网格。
 * <p>
 * 只有在可以通过一系列的移动从源方格source 到达目标方格target 时才返回true。否则，返回 false。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * 输出：false
 * 解释：
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * 无法向北或者向东移动是因为方格禁止通行。
 * 无法向南或者向西移动是因为不能走出网格。
 * 示例 2：
 * <p>
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * 输出：true
 * 解释：
 * 因为没有方格被封锁，所以一定可以到达目标方格。
 *
 * <p>
 * 提示：
 * <p>
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= xi, yi < 106
 * source.length == target.length == 2
 * 0 <= sx, sy, tx, ty < 106
 * source != target
 * 题目数据保证 source 和 target 不在封锁列表内
 * 通过次数2,932提交次数9,862
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/escape-a-large-maze
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsEscapePossible {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        return bfs(blocked, source, target)
                && bfs(blocked, target, source);
    }

    private boolean bfs(int[][] blocked, int[] source, int[] target) {
        Set<Integer> visited = new HashSet<>();
        for (int[] block : blocked) {
            visited.add(1000000 * block[0] + block[1]);
        }
        visited.add(1000000 * source[0] + source[1]);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size >= blocked.length) {
                return true;
            }
            while (--size >= 0) {
                int[] p = queue.poll();
                for (int[] d : DIRECTIONS) {
                    int x = p[0] + d[0];
                    int y = p[1] + d[1];
                    if (x < 0 || x >= 1000000 || y < 0 || y >= 1000000) {
                        continue;
                    }
                    if (x == target[0] && y == target[1]) {
                        return true;
                    }
                    if (visited.add(1000000 * x + y)) {
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return false;
    }
}
