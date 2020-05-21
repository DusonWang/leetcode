package com.leetcode.offer.code;

/**
 * @author duson
 * 请实现整数数字的乘法、减法和除法运算，运算结果均为整数数字，程序中只允许使用加法运算符和逻辑运算符，允许程序中出现正负常数，不允许使用位运算。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * Operations() 构造函数
 * minus(a, b) 减法，返回a - b
 * multiply(a, b) 乘法，返回a * b
 * divide(a, b) 除法，返回a / b
 * 示例：
 * <p>
 * Operations operations = new Operations();
 * operations.minus(1, 2); //返回-1
 * operations.multiply(3, 4); //返回12
 * operations.divide(5, -2); //返回-2
 * 提示：
 * <p>
 * 你可以假设函数输入一定是有效的，例如不会出现除法分母为0的情况
 * 单个用例的函数调用次数不会超过1000次
 * 通过次数397提交次数883
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/operations-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Operations {

    public Operations() {

    }

    public int minus(int a, int b) {
        b = -b;
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public int multiply(int a, int b) {
        int ans = 0;
        boolean flag = (a > 0) == (b <= 0);
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans + a;
            }
            a <<= 1;
            b >>= 1;
        }
        return flag ? -ans : ans;
    }

    public int divide(int dividend, int divisor) {
        boolean s = (dividend ^ divisor) >= 0;
        long d1 = dividend;
        long d2 = divisor;
        d1 = d1 > 0 ? d1 : -d1;
        d2 = d2 > 0 ? d2 : -d2;
        if (d1 < d2) {
            return 0;
        }
        long d = 0x40_00_00_00_00L, c = 0L, res = 0L;
        while (d != 0) {
            c = (c << 1) | ((d & d1) == 0 ? 0 : 1);
            if (c >= d2) {
                res = (res << 1) | 1;
                c -= d2;
            } else {
                res = res << 1;
            }
            d = d >> 1;
        }
        return s ? res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res : (int) -res;
    }
}
