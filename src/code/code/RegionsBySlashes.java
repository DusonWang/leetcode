package code.code;

/**
 * @author duson
 * <p>
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 * <p>
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 * <p>
 * 返回区域的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 *   " /",
 *   "/ "
 * ]
 * 输出：2
 * 解释：2x2 网格如下：
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * [
 *   " /",
 *   "  "
 * ]
 * 输出：1
 * 解释：2x2 网格如下：
 * <p>
 * 示例 3：
 * <p>
 * 输入：
 * [
 *   "\\/",
 *   "/\\"
 * ]
 * 输出：4
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
 * 2x2 网格如下：
 * <p>
 * 示例 4：
 * <p>
 * 输入：
 * [
 *   "/\\",
 *   "\\/"
 * ]
 * 输出：5
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
 * 2x2 网格如下：
 * <p>
 * 示例 5：
 * <p>
 * 输入：
 * [
 *   "//",
 *   "/ "
 * ]
 * 输出：3
 * 解释：2x2 网格如下：
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length == grid[0].length <= 30
 * grid[i][j] 是 '/'、'\'、或 ' '。
 * 通过次数1,594提交次数2,461
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RegionsBySlashes {

    static class DSU {
        int[] root;
        int count;

        public DSU(int n) {
            root = new int[(n + 1) * (n + 1)];
            count = 1;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    int num = i * (n + 1) + j; // 2d -> 1d
                    if (i == 0 || j == 0 || i == n || j == n) {
                        root[num] = 0;
                    } else {
                        root[num] = num;
                    }
                }
            }
        }

        public int find(int x) {
            if (x != root[x]) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) {
                count++;
                return;
            }
            root[rootY] = rootX;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    int x = i * (n + 1) + j + 1;
                    int y = (i + 1) * (n + 1) + j;
                    dsu.union(x, y);
                } else if (c == '\\') {
                    int x = i * (n + 1) + j;
                    int y = (i + 1) * (n + 1) + j + 1;
                    dsu.union(x, y);
                }
            }
        }
        return dsu.count;
    }
}
