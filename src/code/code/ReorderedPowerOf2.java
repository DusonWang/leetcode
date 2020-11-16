package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * <p>
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：10
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：16
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：24
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：46
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderedPowerOf2 {

    public boolean reorderedPowerOf2(int n) {
        int[] nCount = count(n);
        for (int i = 0; i <= 30; i++) {
            if (Arrays.equals(nCount, count(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private int[] count(int n) {
        int[] ans = new int[10];
        while (n > 0) {
            ans[n % 10]++;
            n /= 10;
        }
        return ans;
    }
}
