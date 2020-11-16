package code.code;

/**
 * @author duson
 * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 * <p>
 * 两数乘积等于  num + 1 或 num + 2
 * 以绝对差进行度量，两数大小最接近
 * 你可以按任意顺序返回这两个整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 8
 * 输出：[3,3]
 * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
 * 示例 2：
 * <p>
 * 输入：num = 123
 * 输出：[5,25]
 * 示例 3：
 * <p>
 * 输入：num = 999
 * 输出：[40,25]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 10^9
 * 通过次数2,429提交次数5,165
 * 在真实的面试中遇到过这道题？
 */
public class ClosestDivisors {

    public int[] closestDivisors(int num) {
        int sum1 = num + 1;
        int sum2 = num + 2;
        int[] res1 = getDivisors(sum1);
        int[] res2 = getDivisors(sum2);
        return Math.abs(res1[0] - res1[1]) < Math.abs(res2[0] - res2[1]) ? res1 : res2;
    }

    private int[] getDivisors(int sum) {
        int num1 = (int) Math.sqrt(sum);
        while (true) {
            if (sum % num1 == 0) {
                int num2 = sum / num1;
                return new int[]{num1, num2};
            } else {
                num1--;
            }
        }
    }
}
