package code.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有 N 位扣友参加了微软与力扣举办了「以扣会友」线下活动。主办方提供了 2*N 道题目，整型数组 questions 中每个数字对应了每道题目所涉及的知识点类型。
 * 若每位扣友选择不同的一题，请返回被选的 N 道题目至少包含多少种知识点类型。
 * <p>
 * 示例 1：
 * <p>
 * 输入：questions = [2,1,6,2]
 * <p>
 * 输出：1
 * <p>
 * 解释：有 2 位扣友在 4 道题目中选择 2 题。
 * 可选择完成知识点类型为 2 的题目时，此时仅一种知识点类型
 * 因此至少包含 1 种知识点类型。
 * <p>
 * 示例 2：
 * <p>
 * 输入：questions = [1,5,1,3,4,5,2,5,3,3,8,6]
 * <p>
 * 输出：2
 * <p>
 * 解释：有 6 位扣友在 12 道题目中选择题目，需要选择 6 题。
 * 选择完成知识点类型为 3、5 的题目，因此至少包含 2 种知识点类型。
 * <p>
 * 提示：
 * <p>
 * questions.length == 2*n
 * 2 <= questions.length <= 10^5
 * 1 <= questions[i] <= 1000
 * 通过次数724提交次数1,017
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/WqXACV
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HalfQuestions {

    public int halfQuestions(int[] questions) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : questions) {
            if (freq.containsKey(i)) {
                freq.put(i, freq.get(i) + 1);
            } else {
                freq.put(i, 1);
            }
        }
        Integer[] freqs = freq.values().toArray(new Integer[0]);
        Arrays.sort(freqs);
        int n = questions.length / 2;
        for (int i = freqs.length - 1; i >= 0; i--) {
            if (n > 0) {
                n -= freqs[i];
                ans += 1;
            }
        }
        return ans;
    }
}
