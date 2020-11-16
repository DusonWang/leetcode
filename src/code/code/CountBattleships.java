package code.code;

/**
 * @author duson
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
 * <p>
 * 给你一个有效的甲板，仅由战舰或者空位组成。
 * 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 * 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
 * 示例 :
 * <p>
 * X..X
 * ...X
 * ...X
 * 在上面的甲板中有2艘战舰。
 * <p>
 * 无效样例 :
 * <p>
 * ...X
 * XXXX
 * ...X
 * 你不会收到这样的无效甲板 - 因为战舰之间至少会有一个空位将它们分开。
 * <p>
 * 进阶:
 * <p>
 * 你可以用一次扫描算法，只使用O(1)额外空间，并且不修改甲板的值来解决这个问题吗？
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 是
 * <p>
 * 否
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/battleships-in-a-board
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountBattleships {

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && !(i > 0 && board[i - 1][j] == 'X' || j > 0 && board[i][j - 1] == 'X')) {
                    count++;
                }
            }
        }
        return count;
    }
}
