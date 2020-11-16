package code.code;

/**
 * @author duson
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 * <p>
 * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
 * <p>
 * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4]
 * 输出："23:41"
 * 示例 2：
 * <p>
 * 输入：[5,5,5,5]
 * 输出：""
 *  
 * <p>
 * 提示：
 * <p>
 * A.length == 4
 * 0 <= A[i] <= 9
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-time-for-given-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestTimeFromDigits {

    public String largestTimeFromDigits(int[] a) {
        String ans = "";
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    String h = "" + a[i] + a[j], m = "" + a[k] + a[6 - i - j - k], t = h + ":" + m;
                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && ans.compareTo(t) < 0) {
                        ans = t;
                    }
                }
            }
        }
        return ans;
    }
}
