package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 对于某些字符串 S，我们将执行一些替换操作，用新的字母组替换原有的字母组（不一定大小相同）。
 * <p>
 * 每个替换操作具有 3 个参数：起始索引 i，源字 x 和目标字 y。规则是如果 x 从原始字符串 S 中的位置 i 开始，那么我们将用 y 替换出现的 x。如果没有，我们什么都不做。
 * <p>
 * 举个例子，如果我们有 S?= “abcd” 并且我们有一些替换操作 i = 2，x = “cd”，y = “ffff”，那么因为 “cd” 从原始字符串 S 中的位置 2 开始，我们将用?“ffff” 替换它。
 * <p>
 * 再来看 S = “abcd” 上的另一个例子，如果我们有替换操作 i = 0，x = “ab”，y = “eee”，以及另一个替换操作 i = 2，x = “ec”，y = “ffff”，那么第二个操作将不执行任何操作，因为原始字符串中?S[2] = 'c'，与 x[0] = 'e' 不匹配。
 * <p>
 * 所有这些操作同时发生。保证在替换时不会有任何重叠：?S = "abc", indexes = [0, 1],?sources = ["ab","bc"] 不是有效的测试用例。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * 输出："eeebffff"
 * 解释：
 * "a" 从 S 中的索引 0 开始，所以它被替换为 "eee"。
 * "cd" 从 S 中的索引 2 开始，所以它被替换为 "ffff"。
 * 示例 2：
 * <p>
 * 输入：S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * 输出："eeecd"
 * 解释：
 * "ab" 从 S 中的索引 0 开始，所以它被替换为 "eee"。
 * "ec" 没有从原始的 S 中的索引 2 开始，所以它没有被替换。
 * ?
 * <p>
 * 提示：
 * <p>
 * 0 <=?indexes.length =?sources.length =?targets.length <= 100
 * 0?<?indexes[i]?< S.length <= 1000
 * 给定输入中的所有字符都是小写字母。
 * ?
 * <p>
 * 通过次数2,495提交次数6,336
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-and-replace-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindReplaceString {


    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);
        for (int i = 0; i < indexes.length; ++i) {
            int ix = indexes[i];
            if (s.startsWith(sources[i], ix)) {
                match[ix] = i;
            }
        }
        StringBuilder ans = new StringBuilder();
        int ix = 0;
        while (ix < n) {
            if (match[ix] >= 0) {
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            } else {
                ans.append(s.charAt(ix++));
            }
        }
        return ans.toString();
    }
}
