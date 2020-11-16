package code.code;

/**
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 * <p>
 * 输入：num = 1
 * 输出：[2, -1]
 * 提示:
 * <p>
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 * 通过次数945提交次数2,282
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closed-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author duson
 */
public class FindClosedNumbers {

    public int[] findClosedNumbers(int num) {
        int little = num - 1;
        int bigger = num + 1;
        int binNums = Integer.bitCount(num);
        while (Integer.bitCount(little) != binNums && little > 0) {
            little--;
        }
        while (Integer.bitCount(bigger) != binNums && bigger > 0) {
            bigger++;
        }
        return new int[]{bigger > 0 ? bigger : -1, little > 0 ? little : -1};
    }
}
