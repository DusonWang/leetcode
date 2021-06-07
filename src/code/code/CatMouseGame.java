package code.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个玩家分别扮演猫（Cat）和老鼠（Mouse）在无向图上进行游戏，他们轮流行动。
 * <p>
 * 该图按下述规则给出：graph[a]是所有结点 b 的列表，使得 ab 是图的一条边。
 * <p>
 * 老鼠从结点 1 开始并率先出发，猫从结点 2 开始且随后出发，在结点 0 处有一个洞。
 * <p>
 * 在每个玩家的回合中，他们必须沿着与他们所在位置相吻合的图的一条边移动。例如，如果老鼠位于结点 1，那么它只能移动到graph[1]中的（任何）结点去。
 * <p>
 * 此外，猫无法移动到洞（结点 0）里。
 * <p>
 * 然后，游戏在出现以下三种情形之一时结束：
 * <p>
 * 如果猫和老鼠占据相同的结点，猫获胜。
 * 如果老鼠躲入洞里，老鼠获胜。
 * 如果某一位置重复出现（即，玩家们的位置和移动顺序都与上一个回合相同），游戏平局。
 * 给定graph，并假设两个玩家都以最佳状态参与游戏，如果老鼠获胜，则返回1；如果猫获胜，则返回 2；如果平局，则返回 0。
 * <p>
 *
 * <p>
 * 示例：
 * <p>
 * 输入：[[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
 * 输出：0
 * 解释：
 * 4---3---1
 * |   |
 * 2---5
 * \ /
 * 0
 *
 * <p>
 * 提示：
 * <p>
 * 3 <= graph.length <= 200
 * 保证 graph[1]非空。
 * 保证graph[2]包含非零元素。
 * 通过次数1,498提交次数3,894
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cat-and-mouse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CatMouseGame {

    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        // status[i][j][k] 表示老鼠在i位置， 猫在j位置，k表示该由谁移动(0表示鼠移动， 1表示猫移动)
        // 结果为0，1，2(1表示鼠胜，2表示猫胜，0表示平局)
        int[][][] status = new int[n][n][2];
        Queue<int[]> queue = new LinkedList<>();
        // status[i][i][k] 表示鼠猫同位置，猫胜
        // status[0][i][k] 表示鼠进洞，鼠胜
        for (int i = 0; i < n; i++) {
            status[i][i][0] = 2;
            status[i][i][1] = 2;
            status[0][i][0] = 1;
            status[0][i][1] = 1;
            queue.offer(new int[]{i, i, 0});
            queue.offer(new int[]{i, i, 1});
            queue.offer(new int[]{0, i, 0});
            queue.offer(new int[]{0, i, 1});
        }
        // BFS 搜索
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int m = node[0];
            int c = node[1];
            int k = node[2];
            if (k == 0) { // 鼠行动
                if (status[m][c][0] == 2) {
                    // 猫胜利 上一步
                    for (int pre : graph[c]) {
                        if (pre != 0 && status[m][pre][1] == 0) {
                            status[m][pre][1] = 2;
                            queue.add(new int[]{m, pre, 1});
                        }
                    }
                } else { // 鼠胜利
                    // 猫上一步
                    for (int pre : graph[c]) {
                        // 猫胜利 或者平局
                        if (pre == 0 || status[m][pre][1] != 0) {
                            continue;
                        }
                        boolean mouseWin = true;
                        for (int next : graph[pre]) {
                            if (next != 0 && status[m][next][0] != 1) {
                                mouseWin = false;
                                break;
                            }
                        }
                        if (mouseWin) {
                            status[m][pre][1] = 1;
                            queue.add(new int[]{m, pre, 1});
                        }
                    }
                }

            } else { // 猫行动
                if (status[m][c][1] == 1) { // 鼠胜利
                    for (int pre : graph[m]) {
                        if (status[pre][c][0] == 0) {
                            status[pre][c][0] = 1;
                            queue.add(new int[]{pre, c, 0});
                        }
                    }
                } else { // 猫胜利，那么当且仅当上次的鼠的所有行动都为猫胜利，鼠才稳输
                    for (int pre : graph[m]) {
                        if (status[pre][c][0] == 0) {
                            boolean catWin = true;
                            for (int next : graph[pre]) {
                                if (status[next][c][1] != 2) {
                                    catWin = false;
                                    break;
                                }
                            }
                            if (catWin) {
                                status[pre][c][0] = 2;
                                queue.add(new int[]{pre, c, 0});
                            }
                        }
                    }
                }
            }
        }
        return status[1][2][0];
    }
}
