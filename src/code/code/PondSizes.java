package code.code;

import java.util.*;

/**
 * @author duson
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 * <p>
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 * 通过次数2,563提交次数4,379
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pond-sizes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PondSizes {

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int m = land.length;
        int n = land[0].length;
        if (n <= 0) {
            return null;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                if (land[i][j] == 0) {
                    land[i][j] = 1;
                    cnt++;
                    q.add(i * n + j);
                }
                while (!q.isEmpty()) {
                    int cur = q.remove();
                    int row = cur / n;
                    int col = cur % n;
                    for (int k = 0; k < 8; k++) {
                        int rowX = row + direct[k][0];
                        int colY = col + direct[k][1];
                        if (rowX >= 0 && rowX < m && colY >= 0 && colY < n && land[rowX][colY] == 0) {
                            q.add(rowX * n + colY);
                            land[rowX][colY] = 1;
                            cnt++;
                        }
                    }
                }
                if (cnt > 0) {
                    list.add(cnt);
                }
            }
        }
        int sz = list.size();
        int[] arr = new int[sz];
        for (int i = 0; i < sz; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        return arr;
    }

    public int[] pondSizes2(int[][] land) {
        if (land == null || land.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    int count = dfs(land, i, j);
                    list.add(count);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int dfs(int[][] land, int i, int j) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = -1;
        int count = 1;
        count += dfs(land, i + 1, j);
        count += dfs(land, i - 1, j);
        count += dfs(land, i, j + 1);
        count += dfs(land, i, j - 1);
        count += dfs(land, i + 1, j + 1);
        count += dfs(land, i - 1, j + 1);
        count += dfs(land, i + 1, j - 1);
        count += dfs(land, i - 1, j - 1);
        return count;
    }
}
