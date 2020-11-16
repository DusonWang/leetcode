package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * <p>
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/height-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int len = heights.length;
        int[] copy = Arrays.copyOf(heights, len);
        Arrays.sort(copy);
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (heights[i] != copy[i]) {
                count++;
            }
        }
        return count;
    }
}
