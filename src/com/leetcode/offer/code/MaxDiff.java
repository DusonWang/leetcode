package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个整数?num?。你可以对它进行如下步骤恰好 两次?：
 * <p>
 * 选择一个数字?x (0?<= x <= 9).
 * 选择另一个数字?y (0?<= y <= 9)?。数字?y?可以等于?x?。
 * 将 num?中所有出现 x?的数位都用 y?替换。
 * 得到的新的整数 不能?有前导 0 ，得到的新整数也 不能?是 0?。
 * 令两次对 num?的操作得到的结果分别为?a?和?b?。
 * <p>
 * 请你返回?a 和?b?的 最大差值 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 555
 * 输出：888
 * 解释：第一次选择 x = 5 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 5 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 999 和 b = 111 ，最大差值为 888
 * 示例 2：
 * <p>
 * 输入：num = 9
 * 输出：8
 * 解释：第一次选择 x = 9 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 9 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 9 和 b = 1 ，最大差值为 8
 * 示例 3：
 * <p>
 * 输入：num = 123456
 * 输出：820000
 * 示例 4：
 * <p>
 * 输入：num = 10000
 * 输出：80000
 * 示例 5：
 * <p>
 * 输入：num = 9288
 * 输出：8700
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 10^8
 * 通过次数1,968提交次数5,091
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-difference-you-can-get-from-changing-an-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDiff {

    public int maxDiff(int num) {
        int max = num, min = num;
        for (char x = '0'; x <= '9'; x++) {
            String t = String.valueOf(num);
            for (char y = '0'; y <= '9'; y++) {
                String cur = t.replace(x, y);
                if (cur.charAt(0) != '0') {
                    int v = Integer.parseInt(cur);
                    max = Math.max(max, v);
                    min = Math.min(min, v);
                }
            }
        }
        return Math.abs(min - max);
    }
}
