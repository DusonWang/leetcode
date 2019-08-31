package com.leetcode.offer.day21;

/**
 * @author duson
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * <p>
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * <p>
 * 输出:
 * 3
 * 示例 2:
 * <p>
 * 输入:
 * 11
 * <p>
 * 输出:
 * 0
 * <p>
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindNthDigit {

    public int findNthDigit(int n) {
        long i = 1;
        long high = 10;
        long log = 1;
        long low = 0;
        while (n >= high) {
            i++;
            low = high;
            log *= 10;
            high = high + 9 * log * i;
        }
        long num = (n - low) / i;
        long left = (n - low) % i;
        long obj = log == 1 ? num : log + num;
        long rLeft = i - left;
        while (rLeft > 1) {
            obj /= 10;
            rLeft--;
        }
        return (int) obj % 10;
    }

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(299));
    }
}
