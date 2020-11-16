package code.code;

/**
 * @author duson
 * 给定一个正整数 n，你可以做如下操作：
 * <p>
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 8
 * <p>
 * 输出:
 * 3
 * <p>
 * 解释:
 * 8 -> 4 -> 2 -> 1
 * 示例 2:
 * <p>
 * 输入:
 * 7
 * <p>
 * 输出:
 * 4
 * <p>
 * 解释:
 * 7 -> 8 -> 4 -> 2 -> 1
 * 或
 * 7 -> 6 -> 3 -> 2 -> 1
 * <p
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerReplacement {

    public int integerReplacement(int n) {
        int count = 0;
        long m = n;
        while (m != 1) {
            if (m % 2 == 0) {
                m >>= 1;
            } else if (m == 3) {
                return count + 2;
            } else if ((m & 2) == 2) {
                m += 1;
            } else {
                m -= 1;
            }
            count++;
        }
        return count;
    }
}
