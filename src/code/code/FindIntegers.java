package code.code;

/**
 * @author duson
 * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: 5
 * 解释:
 * 下面是带有相应二进制表示的非负整数<= 5：
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * 其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
 * 说明: 1 <= n <= 109
 * <p>
 * 通过次数1,408提交次数4,749
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindIntegers {

    public int findIntegers(int num) {
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        int i = 30, sum = 0, prevBit = 0;
        while (i >= 0) {
            if ((num & (1 << i)) != 0) {
                sum += f[i];
                if (prevBit == 1) {
                    sum--;
                    break;
                }
                prevBit = 1;
            } else {
                prevBit = 0;
            }
            i--;
        }
        return sum + 1;
    }
}
