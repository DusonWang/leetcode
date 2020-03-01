package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
 * <p>
 * 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
 * <p>
 * 如果无法得到答案，请返回一个空字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [8,1,9]
 * 输出："981"
 * 示例 2：
 * <p>
 * 输入：digits = [8,6,7,1,0]
 * 输出："8760"
 * 示例 3：
 * <p>
 * 输入：digits = [1]
 * 输出：""
 * 示例 4：
 * <p>
 * 输入：digits = [0,0,0,0,0,0]
 * 输出："0"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 10^4
 * 0 <= digits[i] <= 9
 * 返回的结果不应包含不必要的前导零。
 * 通过次数1,581提交次数5,206
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-multiple-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestMultipleOfThree {

    public String largestMultipleOfThree(int[] digits) {
        int[] m1 = {1, 4, 7, 2, 5, 8};
        int[] m2 = {2, 5, 8, 1, 4, 7};
        int sum = 0;
        int[] ds = new int[10];
        for (int d : digits) {
            ++ds[d];
            sum += d;
        }
        while (sum % 3 != 0) {
            for (int i : sum % 3 == 1 ? m1 : m2) {
                if (ds[i] > 0) {
                    --ds[i];
                    sum -= i;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; --i) {
            for (int j = 0; j < ds[i]; j++) {
                sb.append((char) ('0' + i));
            }
        }
        return sb.length() > 0 && sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
