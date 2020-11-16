package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * <p>
 * 给定一幅由黑色像素和白色像素组成的图像， 与一个正整数N, 找到位于某行 R 和某列 C 中且符合下列规则的黑色像素的数量:
 * <p>
 * 行R 和列C都恰好包括N个黑色像素。
 * 列C中所有黑色像素所在的行必须和行R完全相同。
 * 图像由一个由‘B’和‘W’组成二维字符数组表示, ‘B’和‘W’分别代表黑色像素和白色像素。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [['W', 'B', 'W', 'B', 'B', 'W'],
 * ['W', 'B', 'W', 'B', 'B', 'W'],
 * ['W', 'B', 'W', 'B', 'B', 'W'],
 * ['W', 'W', 'B', 'W', 'B', 'W']]
 * <p>
 * N = 3
 * 输出: 6
 * 解析: 所有粗体的'B'都是我们所求的像素(第1列和第3列的所有'B').
 * 0    1    2    3    4    5         列号
 * 0    [['W', 'B', 'W', 'B', 'B', 'W'],
 * 1     ['W', 'B', 'W', 'B', 'B', 'W'],
 * 2     ['W', 'B', 'W', 'B', 'B', 'W'],
 * 3     ['W', 'W', 'B', 'W', 'B', 'W']]
 * 行号
 * <p>
 * 以R = 0行和C = 1列的'B'为例:
 * 规则 1，R = 0行和C = 1列都恰好有N = 3个黑色像素.
 * 规则 2，在C = 1列的黑色像素分别位于0，1和2行。它们都和R = 0行完全相同。
 * <p>
 *  
 * <p>
 * 注意:
 * <p>
 * 输入二维数组行和列的范围是 [1,200]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lonely-pixel-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindBlackPixel2 {

    public int findBlackPixel(char[][] picture, int nn) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }
        int n = picture[0].length;
        int[] cols = new int[n];
        Map<String, Integer> map = new HashMap<>();

        for (char[] chars : picture) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (chars[j] == 'B') {
                    cols[j]++;
                    count++;
                }
                sb.append(chars[j]);
            }
            if (count == nn) {
                String curRow = sb.toString();
                map.put(curRow, map.getOrDefault(curRow, 0) + 1);
            }
        }

        int res = 0;
        for (String row : map.keySet()) {
            if (map.get(row) != nn) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if (row.charAt(i) == 'B' && cols[i] == nn) {
                    res += nn;
                }
            }
        }
        return res;
    }
}
