package code.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * <p>
 * 给定一幅黑白像素组成的图像, 计算黑色孤独像素的数量。
 * <p>
 * 图像由一个由‘B’和‘W’组成二维字符数组表示, ‘B’和‘W’分别代表黑色像素和白色像素。
 * <p>
 * 黑色孤独像素指的是在同一行和同一列不存在其他黑色像素的黑色像素。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [['W', 'W', 'B'],
 * ['W', 'B', 'W'],
 * ['B', 'W', 'W']]
 * <p>
 * 输出: 3
 * 解析: 全部三个'B'都是黑色孤独像素。
 *  
 * <p>
 * 注意:
 * <p>
 * 输入二维数组行和列的范围是 [1,500]。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lonely-pixel-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLonelyPixel {

    public int findLonelyPixel(char[][] picture) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    rowMap.put(i, rowMap.getOrDefault(i, 0) + 1);
                    colMap.put(j, colMap.getOrDefault(j, 0) + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && rowMap.get(i) == 1 && colMap.get(j) == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public int findLonelyPixel2(char[][] picture) {
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'W') {
                    continue;
                }
                row[i]++;
                col[j]++;
                list.add(new int[]{i, j});
            }
        }
        int result = 0;
        for (int[] arr : list) {
            if (row[arr[0]] == 1 && col[arr[1]] == 1) {
                result++;
            }
        }
        return result;
    }
}
