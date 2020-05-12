package com.leetcode.offer.code;

/**
 * @author duson
 * 在无限的平面上，机器人最初位于?(0, 0)?处，面朝北方。机器人可以接受下列三条指令之一：
 * <p>
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令?instructions，并一直重复它们。
 * <p>
 * 只有在平面中存在环使得机器人永远无法离开时，返回?true。否则，返回 false。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入："GGLLGG"
 * 输出：true
 * 解释：
 * 机器人从 (0,0) 移动到 (0,2)，转 180 度，然后回到 (0,0)。
 * 重复这些指令，机器人将保持在以原点为中心，2 为半径的环中进行移动。
 * 示例 2：
 * <p>
 * 输入："GG"
 * 输出：false
 * 解释：
 * 机器人无限向北移动。
 * 示例 3：
 * <p>
 * 输入："GL"
 * 输出：true
 * 解释：
 * 机器人按 (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ... 进行移动。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= instructions.length <= 100
 * instructions[i] 在?{'G', 'L', 'R'}?中
 * 通过次数3,490提交次数7,977
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/robot-bounded-in-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsRobotBounded {

    public boolean isRobotBounded(String instructions) {
        int[] currCor = new int[2];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ind = 0;
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                ind = (ind + 3) % 4;
                continue;
            } else if (instructions.charAt(i) == 'R') {
                ind = (ind + 1) % 4;
                continue;
            }
            currCor[0] += dir[ind][0];
            currCor[1] += dir[ind][1];
        }
        return (currCor[0] == 0 && currCor[1] == 0) || ind > 0;
    }
}
