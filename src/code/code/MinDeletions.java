package code.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 * <p>
 * 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 * <p>
 * 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：0
 * 解释：s 已经是优质字符串。
 * 示例 2：
 * <p>
 * 输入：s = "aaabbbcc"
 * 输出：2
 * 解释：可以删除两个 'b' , 得到优质字符串 "aaabcc" 。
 * 另一种方式是删除一个 'b' 和一个 'c' ，得到优质字符串 "aaabbc" 。
 * 示例 3：
 * <p>
 * 输入：s = "ceabaacb"
 * 输出：2
 * 解释：可以删除两个 'c' 得到优质字符串 "eabaab" 。
 * 注意，只需要关注结果字符串中仍然存在的字符。（即，频次为 0 的字符会忽略不计。）
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅含小写英文字母
 * 通过次数5,765提交次数11,448
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-deletions-to-make-character-frequencies-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDeletions {

    public int minDeletions(String s) {
        char[] array = s.toCharArray();
        int[] count = new int[26];
        for (char a : array) {
            count[a - 'a']++;
        }
        int ans = 0;
        Arrays.sort(count);
        for (int i = 24; i >= 0; i--) {
            if (count[i] != 0) {
                while (count[i] >= count[i + 1] && count[i] != 0) {
                    count[i]--;
                    ans++;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        MinDeletions minDeletions = new MinDeletions();
//        System.out.println(minDeletions.minDeletions("aab"));
//        System.out.println(minDeletions.minDeletions("aaabbbcc"));
//        System.out.println(minDeletions.minDeletions("ceabaacb"));
        System.out.println(minDeletions.minDeletions("abcabc"));

    }
}
