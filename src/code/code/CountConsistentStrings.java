package code.code;

/**
 * 给你一个由不同字符组成的字符串?allowed?和一个字符串数组?words?。如果一个字符串的每一个字符都在 allowed?中，就称这个字符串是 一致字符串 。
 * <p>
 * 请你返回?words?数组中?一致字符串 的数目。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 * <p>
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 * <p>
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed?中的字符 互不相同?。
 * words[i] 和?allowed?只包含小写英文字母。
 * 通过次数12,492提交次数15,098
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-the-number-of-consistent-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] arr = new boolean[26];
        int sum = 0;
        for (int i = 0; i < allowed.length(); i++) {
            arr[allowed.charAt(i) - 'a'] = true;
        }
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (!arr[word.charAt(j) - 'a']) {
                    sum++;
                    break;
                }
            }
        }
        return words.length - sum;
    }
}
