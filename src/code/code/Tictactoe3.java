package code.code;

/**
 * @author duson
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 示例 1：
 * <p>
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * 示例 2：
 * <p>
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 * 示例 3：
 * <p>
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * 提示：
 * <p>
 * 1 <= board.length == board[i].length <= 100
 * 输入一定遵循井字棋规则
 * 通过次数783提交次数1,608
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tic-tac-toe-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Tictactoe3 {

    public String tictactoe(String[] board) {
        int n = board.length;
        boolean hasEmpty = false;
        int[] rowX = new int[n];
        int[] colX = new int[n];
        int[] rowO = new int[n];
        int[] colO = new int[n];
        int leftX = 0, rightX = 0, leftO = 0, rightO = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') {
                    rowX[i]++;
                    colX[j]++;
                    if (i == j) {
                        leftX++;
                    }
                    if (i + j == n - 1) {
                        rightX++;
                    }
                } else if (c == 'O') {
                    rowO[i]++;
                    colO[j]++;
                    if (i == j) {
                        leftO++;
                    }
                    if (i + j == n - 1) {
                        rightO++;
                    }
                } else {
                    hasEmpty = true;
                }
            }
        }
        if (leftX == n || rightX == n) {
            return "X";
        }
        if (leftO == n || rightO == n) {
            return "O";
        }
        for (int i = 0; i < n; i++) {
            if (rowX[i] == n || colX[i] == n) {
                return "X";
            }
            if (rowO[i] == n || colO[i] == n) {
                return "O";
            }
        }
        return hasEmpty ? "Pending" : "Draw";
    }
}
