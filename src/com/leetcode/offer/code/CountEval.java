package com.leetcode.offer.code;

/**
 * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "1^0|0|1", result = 0
 * <p>
 * 输出: 2
 * 解释:?两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * 示例 2:
 * <p>
 * 输入: s = "0&0&0&1^1|0", result = 1
 * <p>
 * 输出: 10
 * 提示：
 * <p>
 * 运算符的数量不超过 19 个
 * 通过次数691提交次数1,455
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boolean-evaluation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountEval {

    public int countEval(String s, int result) {
        int n = s.length();
        int[][][] cache = new int[n][n][];
        char[] chars = s.toCharArray();
        int[] res = backtrack(chars, 0, chars.length - 1, cache);
        return result == 0 ? res[0] : res[1];
    }

    private int[] backtrack(char[] chars, int left, int right, int[][][] cache) {
        if (left >= right) {
            int[] arr = new int[2];
            arr[chars[left] - '0'] = 1;
            return arr;
        }
        if (cache[left][right] != null) {
            return cache[left][right];
        }
        int[] res = new int[2];
        for (int i = left; i <= right; i++) {
            if (chars[i] == '0' || chars[i] == '1') {
                continue;
            }
            int[] l = backtrack(chars, left, i - 1, cache);
            int[] r = backtrack(chars, i + 1, right, cache);
            switch (chars[i]) {
                case '&':
                    // 结果为0 三种情况：0 0，0 1，1 0
                    // 结果为1 一种情况：1 1
                    res[0] += (l[0] * r[0]) + (l[0] * r[1]) + (l[1] * r[0]);
                    res[1] += l[1] * r[1];
                    break;
                case '|':
                    // 结果为0 一种情况：0 0
                    // 结果为1 三种情况：1 1，0 1，1 0
                    res[0] += l[0] * r[0];
                    res[1] += (l[1] * r[1]) + (l[0] * r[1]) + (l[1] * r[0]);
                    break;
                case '^':
                    // 结果为0 二种情况：0 0，1 1
                    // 结果为1 两种情况：0 1，1 0
                    res[0] += (l[0] * r[0]) + (l[1] * r[1]);
                    res[1] += (l[0] * r[1]) + (l[1] * r[0]);
                    break;
                default:
                    break;
            }
        }
        return cache[left][right] = res;
    }
}
