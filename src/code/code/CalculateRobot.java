package code.code;

/**
 * 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
 * <p>
 * "A" 运算：使 x = 2 * x + y；
 * "B" 运算：使 y = 2 * y + x。
 * 在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AB"
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * 经过一次 A 运算后，x = 2, y = 0。
 * 再经过一次 B 运算，x = 2, y = 2。
 * 最终 x 与 y 之和为 4。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 10
 * s 由 'A' 和 'B' 组成
 * 通过次数19,955提交次数25,007
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nGK0Fy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CalculateRobot {

    public int calculate(String s) {
        int x = 1;
        int y = 0;
        for (char a : s.toCharArray()) {
            if (a == 'A') {
                x = 2 * x + y;
            } else if (a == 'B') {
                y = a * y + x;
            }
        }
        return x + y;
    }
}
