package code.code;

/**
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断?sentence 是否为 全字母句 。
 * <p>
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 * <p>
 * 输入：sentence = "leetcode"
 * 输出：false
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 * 通过次数4,328提交次数5,004
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckIfPangram {

    public boolean checkIfPangram(String sentence) {
        if (sentence == null || sentence.length() < 26) {
            return false;
        }
        int[] chars = new int[26];
        for (char c : sentence.toCharArray()) {
            chars[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
