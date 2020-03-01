package com.leetcode.offer.code;

/**
 * @author duson
 * 你在进行一个简化版的吃豆人游戏。你从 (0, 0) 点开始出发，你的目的地是 (target[0], target[1]) 。地图上有一些阻碍者，第 i 个阻碍者从 (ghosts[i][0], ghosts[i][1]) 出发。
 * <p>
 * 每一回合，你和阻碍者们*可以*同时向东，西，南，北四个方向移动，每次可以移动到距离原位置1个单位的新位置。
 * <p>
 * 如果你可以在任何阻碍者抓住你之前到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
 * <p>
 * 当且仅当你有可能成功逃脱时，输出 True。
 * <p>
 * 示例 1:
 * 输入：
 * ghosts = [[1, 0], [0, 3]]
 * target = [0, 1]
 * 输出：true
 * 解释：
 * 你可以直接一步到达目的地(0,1)，在(1, 0)或者(0, 3)位置的阻碍者都不可能抓住你。
 * 示例 2:
 * 输入：
 * ghosts = [[1, 0]]
 * target = [2, 0]
 * 输出：false
 * 解释：
 * 你需要走到位于(2, 0)的目的地，但是在(1, 0)的阻碍者位于你和目的地之间。
 * 示例 3:
 * 输入：
 * ghosts = [[2, 0]]
 * target = [1, 0]
 * 输出：false
 * 解释：
 * 阻碍者可以和你同时达到目的地。
 * 说明：
 * <p>
 * 所有的点的坐标值的绝对值 <= 10000。
 * 阻碍者的数量不会超过 100。
 * 通过次数1,908提交次数3,279
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/escape-the-ghosts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EscapeGhosts {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = new int[]{0, 0};
        int dis = Math.abs(source[0] - target[0]) + Math.abs(source[1] - target[1]);
        for (int[] ghost : ghosts) {
            if (Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= dis) {
                return false;
            }
        }
        return true;
    }
}
