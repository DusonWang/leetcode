package code.code;

/**
 * @author duson
 * 给你两个长度相等的整数数组，返回下面表达式的最大值：
 * <p>
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 * <p>
 * 其中下标 i，j 满足 0 <= i, j < arr1.length。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * 输出：13
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * 输出：20
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= arr1.length == arr2.length <= 40000
 * -10^6 <= arr1[i], arr2[i] <= 10^6
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-of-absolute-value-expression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAbsValExpr {

    public int maxAbsValExpr(int[] x, int[] y) {
        int res = 0;
        int n = x.length;
        int[] pp = {-1, 1};
        for (int p : pp) {
            for (int q : pp) {
                int closest = p * x[0] + q * y[0];
                for (int i = 1; i < n; ++i) {
                    int cur = p * x[i] + q * y[i] + i;
                    res = Math.max(res, cur - closest);
                    closest = Math.min(closest, cur);
                }
            }
        }
        return res;
    }
}
