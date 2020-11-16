package code.code;

/**
 * @author duson
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }



    /*
     * 进阶问题
     * 返回最低位二进制1在那个位置上
     * */
    public int trailingZeroesIndex(int n) {
        if (n < 1) {
            return -1;
        }
        int res = 0;
        while (n != 0) {
            n >>>= 1;
            res += n;
        }
        return res;
    }
}
