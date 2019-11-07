package com.leetcode.offer.code;

/**
 * @author duson
 * 有 A 和 B 两种类型的汤。一开始每种类型的汤有 N 毫升。有四种分配操作：
 * <p>
 * 提供 100ml 的汤A 和 0ml 的汤B。
 * 提供 75ml 的汤A 和 25ml 的汤B。
 * 提供 50ml 的汤A 和 50ml 的汤B。
 * 提供 25ml 的汤A 和 75ml 的汤B。
 * 当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为0.25的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
 * <p>
 * 注意不存在先分配100 ml汤B的操作。
 * <p>
 * 需要返回的值： 汤A先分配完的概率 + 汤A和汤B同时分配完的概率 / 2。
 * <p>
 * 示例:
 * 输入: N = 50
 * 输出: 0.625
 * 解释:
 * 如果我们选择前两个操作，A将首先变为空。对于第三个操作，A和B会同时变为空。对于第四个操作，B将首先变为空。
 * 所以A变为空的总概率加上A和B同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
 * 注释:
 * <p>
 * 0 <= N <= 10^9。
 * 返回值在 10^-6 的范围将被认为是正确的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/soup-servings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SoupServings {

    public double soupServings(int n) {
        if (n >= 5000) {
            return 1;
        }
        n = (int) Math.ceil(n / 25.0);
        double[][] arr = new double[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                arr[i][j] = -1.0;
            }
        }
        return soupServingshelp(n, n, arr);
    }

    private double soupServingshelp(int m, int n, double[][] hm) {
        if (m <= 0 && n <= 0) {
            return 0.5;
        }
        if (m <= 0) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        if (hm[m][n] != -1) {
            return hm[m][n];
        }
        double res = 0.25 * (soupServingshelp(m - 4, n, hm) + soupServingshelp(m - 3, n - 1, hm) + soupServingshelp(m - 2, n - 2, hm) + soupServingshelp(m - 1, n - 3, hm));
        return hm[m][n] = res;
    }
}
