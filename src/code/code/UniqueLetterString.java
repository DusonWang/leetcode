package code.code;

/**
 * @author duson
 * 如果一个字符在字符串 S 中有且仅有出现一次，那么我们称其为独特字符。
 * <p>
 * 例如，在字符串 S = "LETTER" 中，"L" 和 "R" 可以被称为独特字符。
 * <p>
 * 我们再定义 UNIQ(S) 作为字符串 S 中独特字符的个数。
 * <p>
 * 那么，在 S = "LETTER" 中， UNIQ("LETTER") =  2。
 * <p>
 * 对于给定字符串 S，计算其所有非空子串的独特字符的个数（即 UNIQ(substring)）之和。
 * <p>
 * 如果在 S 的不同位置上出现两个甚至多个相同的子串，那么我们认为这些子串是不同的。
 * <p>
 * 考虑到答案可能会非常大，规定返回格式为：结果 mod 10 ^ 9 + 7。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "ABC"
 * 输出: 10
 * 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
 * 其中，每一个子串都由独特字符构成。
 * 所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
 * 示例 2:
 * <p>
 * 输入: "ABA"
 * 输出: 8
 * 解释: 除了子串 UNIQ('ABA') = 1，其余与示例1相同。
 *  
 * <p>
 * 说明: 0 <= S.length <= 10000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-letter-string/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniqueLetterString {

    public int uniqueLetterString(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i){
            res += unique(s, i);
        }
        return res;
    }

    private int unique(String s, int index){
        int l = index - 1;
        int r = index + 1;
        while (l >= 0 && s.charAt(l) != s.charAt(index)) {
            l--;
        }
        while (r < s.length() && s.charAt(r) != s.charAt(index)) {
            r++;
        }
        return (index - l) * (r - index);
    }
}
