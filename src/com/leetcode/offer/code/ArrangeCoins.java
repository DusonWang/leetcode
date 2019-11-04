package com.leetcode.offer.code;

/**
 * @author duson
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * <p>
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * <p>
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * <p>
 * 示例 1:
 * <p>
 * n = 5
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 * <p>
 * n = 8
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第四行不完整，所以返回3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrangeCoins {

    public int arrangeCoins2(int n) {
        if (n <= 1) {
            return n;
        }
        long start = 1, end = n;
        long mid;
        while (start < end) {
            mid = start + ((end - start) >> 1);
            if (mid * (mid + 1) / 2 <= n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int) (start - 1);
    }

    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }

    public static void main(String[] args) {
        ArrangeCoins arrangeCoins = new ArrangeCoins();
        System.out.println(arrangeCoins.arrangeCoins(5));
        System.out.println(arrangeCoins.arrangeCoins(9));
        System.out.println(arrangeCoins.arrangeCoins(1));

    }
}
