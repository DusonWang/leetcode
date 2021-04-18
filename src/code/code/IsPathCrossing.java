package code.code;

import java.util.HashSet;

/**
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * <p>
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 * <p>
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：path = "NES"
 * 输出：false
 * 解释：该路径没有在任何位置相交。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：path = "NESWW"
 * 输出：true
 * 解释：该路径经过原点两次。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= path.length <= 10^4
 * path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
 * 通过次数8,970提交次数16,511
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-crossing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPathCrossing {

    public boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        String first = x + "," + y;
        set.add(first);
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y += 1;
            } else if (c == 'S') {
                y -= 1;
            } else if (c == 'E') {
                x += 1;
            } else if (c == 'W') {
                x -= 1;
            }
            String temp = x + "," + y;
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
        }
        return false;
    }
}
