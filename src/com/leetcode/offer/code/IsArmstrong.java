package com.leetcode.offer.code;

/**
 * @author duson
 * 假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
 * <p>
 * 给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：153
 * 输出：true
 * 示例：
 * 153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
 * 示例 2：
 * <p>
 * 输入：123
 * 输出：false
 * 解释：
 * 123 是一个 3 位数，且 123 != 1^3 + 2^3 + 3^3 = 36。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/armstrong-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsArmstrong {

    public boolean isArmstrong(int n) {
        int k = (n + "").length();
        int count = n;
        int nums = 0;
        int nn = 0;
        while (nn < k) {
            nums += Math.pow(count % 10, k);
            count = count / 10;
            nn++;
        }
        return nums == n;
    }
}
