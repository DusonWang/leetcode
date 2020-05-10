package com.leetcode.offer.code;

/**
 * 我们从一块字母板上的位置?(0, 0)?出发，该坐标对应的字符为?board[0][0]。
 * <p>
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
 * <p>
 * <p>
 * <p>
 * 我们可以按下面的指令规则行动：
 * <p>
 * 如果方格存在，'U'?意味着将我们的位置上移一行；
 * 如果方格存在，'D'?意味着将我们的位置下移一行；
 * 如果方格存在，'L'?意味着将我们的位置左移一列；
 * 如果方格存在，'R'?意味着将我们的位置右移一列；
 * '!'?会把在我们当前位置 (r, c) 的字符?board[r][c]?添加到答案中。
 * （注意，字母板上只存在有字母的位置。）
 * <p>
 * 返回指令序列，用最小的行动次数让答案和目标?target?相同。你可以返回任何达成目标的路径。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * 示例 2：
 * <p>
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= target.length <= 100
 * target?仅含有小写英文字母。
 * 通过次数3,206提交次数8,007
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/alphabet-board-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        for (int x = 0, y = 0, i = 0; i < target.length(); i++) {
            int temp = target.charAt(i) - 'a';
            if (i > 0 && target.charAt(i) == target.charAt(i - 1)) {
                ans.append("!");
            } else {
                int nx = temp / 5;
                int ny = temp % 5;
                if (ny < y) {
                    for (int z = 0; z < y - ny; z++) {
                        ans.append("L");
                    }
                }
                if (nx < x) {
                    for (int z = 0; z < x - nx; z++) {
                        ans.append("U");
                    }
                }
                if (nx > x) {
                    for (int z = 0; z < nx - x; z++) {
                        ans.append("D");
                    }
                }
                if (ny > y) {
                    for (int z = 0; z < ny - y; z++) {
                        ans.append("R");
                    }
                }
                ans.append("!");
                x = nx;
                y = ny;
            }
        }
        return ans.toString();
    }
}
