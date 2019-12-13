package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * <p>
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * 示例 2：
 * <p>
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 * <p>
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * 示例 4：
 * <p>
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * A[i] 为 0 或 1
 * 在真实的面试中遇到过这道题？
 * <p>
 * 是
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrefixesDivBy5 {

    public List<Boolean> prefixesDivBy5(int[] a) {
        List<Boolean> res = new ArrayList<>();
        int tail = 0;
        for (int i : a) {
            tail = tail * 2 + i;
            tail = (tail > 9) ? tail - 10 : tail;
            if (tail == 0 || tail == 5) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
