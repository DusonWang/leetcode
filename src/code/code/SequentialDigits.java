package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * <p>
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * 示例 2：
 * <p>
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 *  
 * <p>
 * 提示：
 * <p>
 * 10 <= low <= high <= 10^9
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sequential-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SequentialDigits {
    private final char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public List<Integer> sequentialDigits(int l, int h) {
        List<Integer> res = new ArrayList<>();
        int len = 2;
        int st = 10;
        while (st < (int) 1e9) {
            for (int from = 0; from <= digits.length - len; from++) {
                int s = Integer.parseInt(new String(Arrays.copyOfRange(digits, from, from + len)));
                if (l <= s && s <= h) {
                    res.add(s);
                }
            }
            len++;
            st *= 10;
        }
        return res;
    }
}
