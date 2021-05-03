package code.code;

/**
 * 当一个字符串 s?包含的每一种字母的大写和小写形式 同时?出现在 s?中，就称这个字符串?s?是 美好 字符串。比方说，"abABB"?是美好字符串，因为?'A' 和?'a'?同时出现了，且?'B' 和?'b'?也同时出现了。然而，"abA"?不是美好字符串因为?'b'?出现了，而?'B'?没有出现。
 * <p>
 * 给你一个字符串?s?，请你返回?s?最长的?美好子字符串?。如果有多个答案，请你返回?最早?出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "YazaAay"
 * 输出："aAa"
 * 解释："aAa" 是一个美好字符串，因为这个子串中仅含一种字母，其小写形式 'a' 和大写形式 'A' 也同时出现了。
 * "aAa" 是最长的美好子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "Bb"
 * 输出："Bb"
 * 解释："Bb" 是美好字符串，因为 'B' 和 'b' 都出现了。整个字符串也是原字符串的子字符串。
 * 示例 3：
 * <p>
 * 输入：s = "c"
 * 输出：""
 * 解释：没有美好子字符串。
 * 示例 4：
 * <p>
 * 输入：s = "dDzeE"
 * 输出："dD"
 * 解释："dD" 和 "eE" 都是最长美好子字符串。
 * 由于有多个美好子字符串，返回 "dD" ，因为它出现得最早。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s?只包含大写和小写英文字母。
 * 通过次数2,714提交次数4,438
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-nice-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }
        int length = s.length();
        String ans = "";
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i + len - 1 < length; i++) {
                String substring = s.substring(i, i + len);
                if (substring.length() > ans.length() && check(substring)) {
                    ans = substring;
                }
            }
        }
        return ans;

    }

    private boolean check(String str) {
        int[] aa = new int[26];
        int[] AA = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c - 'A' < 26) {
                AA[c - 'A'] = 1;
            } else {
                aa[c - 'a'] = 1;
            }
        }
        for (int j = 0; j < aa.length; j++) {
            if ((aa[j] > 0 && AA[j] == 0) || (aa[j] == 0 && AA[j] > 0)) {
                return false;
            }
        }
        return true;
    }
}
