package code.code;

/**
 * 你是一位施工队的工长，根据设计师的要求准备为一套设计风格独特的房子进行室内装修。
 * <p>
 * 房子的客厅大小为?n?x m，为保持极简的风格，需要使用尽可能少的 正方形 瓷砖来铺盖地面。
 * <p>
 * 假设正方形瓷砖的规格不限，边长都是整数。
 * <p>
 * 请你帮设计师计算一下，最少需要用到多少块方形瓷砖？
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 2, m = 3
 * 输出：3
 * 解释：3 块地砖就可以铺满卧室。
 * 2 块 1x1 地砖
 * 1 块 2x2 地砖
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, m = 8
 * 输出：5
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：n = 11, m = 13
 * 输出：6
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 13
 * 1 <= m?<=?13
 * 通过次数2,251提交次数4,571
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tiling-a-rectangle-with-the-fewest-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TilingRectangle {

    private int ans = Integer.MAX_VALUE;

    public int tilingRectangle(int n, int m) {
        dfs(0, 0, new boolean[n][m], 0);
        return ans;
    }

    private void dfs(int r, int c, boolean[][] rect, int cnt) {
        int n = rect.length;
        int m = rect[0].length;
        if (cnt >= ans) {
            return;
        }

        if (r >= n) {
            ans = cnt;
            return;
        }

        if (c >= m) {
            dfs(r + 1, 0, rect, cnt);
            return;
        }

        if (rect[r][c]) {
            dfs(r, c + 1, rect, cnt);
            return;
        }

        for (int k = Math.min(n - r, m - c); k >= 1 && isAvailable(rect, r, c, k); k--) {
            cover(rect, r, c, k);
            dfs(r, c + 1, rect, cnt + 1);
            uncover(rect, r, c, k);
        }
    }

    private boolean isAvailable(boolean[][] rect, int r, int c, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rect[r + i][c + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void cover(boolean[][] rect, int r, int c, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rect[r + i][c + j] = true;
            }
        }
    }

    private void uncover(boolean[][] rect, int r, int c, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rect[r + i][c + j] = false;
            }
        }
    }
}
