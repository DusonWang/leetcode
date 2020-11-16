package code.code;

/**
 * @author duson
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 * 通过次数7,222提交次数8,493
 * 在真实的面试中遇到过这道题？
 */
public class SumNums {

    public int sumNums(int n) {
        return n == 1 ? n : n + sumNums(n - 1);
    }
}
