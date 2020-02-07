package com.leetcode.offer.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author duson
 * 房间（用格栅表示）中有一个扫地机器人。格栅中的每一个格子有空和障碍物两种可能。
 * <p>
 * 扫地机器人提供4个API，可以向前进，向左转或者向右转。每次转弯90度。
 * <p>
 * 当扫地机器人试图进入障碍物格子时，它的碰撞传感器会探测出障碍物，使它停留在原地。
 * <p>
 * 请利用提供的4个API编写让机器人清理整个房间的算法。
 * <p>
 * interface Robot {
 *   // 若下一个方格为空，则返回true，并移动至该方格
 *   // 若下一个方格为障碍物，则返回false，并停留在原地
 *   boolean move();
 * <p>
 * // 在调用turnLeft/turnRight后机器人会停留在原位置
 *   // 每次转弯90度
 *   void turnLeft();
 *   void turnRight();
 * <p>
 * // 清理所在方格
 * void clean();
 * }
 * 示例:
 * <p>
 * 输入:
 * room = [
 * [1,1,1,1,1,0,1,1],
 * [1,1,1,1,1,0,1,1],
 * [1,0,1,1,1,1,1,1],
 * [0,0,0,1,0,0,0,0],
 * [1,1,1,1,1,1,1,1]
 * ],
 * row = 1,
 * col = 3
 * <p>
 * 解析:
 * 房间格栅用0或1填充。0表示障碍物，1表示可以通过。
 * 机器人从row=1，col=3的初始位置出发。在左上角的一行以下，三列以右。
 * 注意:
 * <p>
 * 输入只用于初始化房间和机器人的位置。你需要“盲解”这个问题。换而言之，你必须在对房间和机器人位置一无所知的情况下，只使用4个给出的API解决问题。 
 * 扫地机器人的初始位置一定是空地。
 * 扫地机器人的初始方向向上。
 * 所有可抵达的格子都是相连的，亦即所有标记为1的格子机器人都可以抵达。
 * 可以假定格栅的四周都被墙包围。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/robot-room-cleaner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CleanRoom {

    static class Robot {
        public boolean move() {
            return false;
        }

        public void turnLeft() {
        }

        public void turnRight() {
        }

        public void clean() {
        }
    }

    private int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        dfs(robot, new HashMap<>(), 0, 0, 0);
    }

    private void dfs(Robot robot, Map<Integer, Set<Integer>> map, int x, int y, int cur) {
        if (!map.containsKey(x)) {
            map.put(x, new HashSet<>());
        }
        Set<Integer> set = map.get(x);
        if (set.contains(y)) {
            reverse(robot);
            return;
        }
        robot.clean();
        set.add(y);
        for (int i = 0; i < 4; i++) {
            int newCur = (cur + i) % 4;
            int newX = dir[newCur][0] + x;
            int newY = dir[newCur][1] + y;
            if (robot.move()) {
                dfs(robot, map, newX, newY, newCur);
            }
            robot.turnRight();
        }
        reverse(robot);
    }

    private void reverse(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
