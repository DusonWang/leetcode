package code.code;

/**
 * 给你一个二进制字符串 s ，现需要将其转化为一个 交替字符串 。请你计算并返回转化所需的 最小 字符交换次数，如果无法完成转化，返回 -1 。
 * <p>
 * 交替字符串 是指：相邻字符之间不存在相等情况的字符串。例如，字符串 "010" 和 "1010" 属于交替字符串，但 "0100" 不是。
 * <p>
 * 任意两个字符都可以进行交换，不必相邻 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "111000"
 * 输出：1
 * 解释：交换位置 1 和 4："111000" -> "101010" ，字符串变为交替字符串。
 * 示例 2：
 * <p>
 * 输入：s = "010"
 * 输出：0
 * 解释：字符串已经是交替字符串了，不需要交换。
 * 示例 3：
 * <p>
 * 输入：s = "1110"
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 的值为 '0' 或 '1'
 * 通过次数3,841提交次数10,044
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSwaps2 {
    public int minSwaps2(String s) {
        int o0 = 0;
        int o1 = 0;
        int e0 = 0;
        int e1 = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '0') {
                if ((i & 1) == 0) {
                    e0++;
                } else {
                    o0++;
                }
            } else {
                if ((i & 1) == 0) {
                    e1++;
                } else {
                    o1++;
                }
            }
        }
        if (Math.abs(o0 + e0 - o1 - e1) > 1) {
            return -1;
        }
        if (o0 == e1 && o1 == e0) {
            return Math.min(o0, o1);
        }
        return o0 == e1 ? o0 : o1;
    }

    public int minSwaps(String s) {
        int cntOne = 0;
        int cntZero = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                ++cntZero;
            } else {
                ++cntOne;
            }
        }
        if (Math.abs(cntOne - cntZero) > 1) {
            return -1;
        }
        if (cntZero > cntOne) {
            return countSwaps(s, '0');
        }
        if (cntZero < cntOne) {
            return countSwaps(s, '1');
        }
        return Math.min(countSwaps(s, '0'), countSwaps(s, '1'));
    }

    private int countSwaps(String s, char start) {
        int cntWrongPos = 0;
        for (char c : s.toCharArray()) {
            if (c != start) {
                ++cntWrongPos;
            }
            start = (char) ('1' - start + '0');
        }
        return cntWrongPos / 2;
    }
}
