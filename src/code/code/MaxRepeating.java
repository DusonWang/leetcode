package code.code;

/**
 * 给你一个字符串?sequence?，如果字符串 word?连续重复?k?次形成的字符串是?sequence?的一个子字符串，那么单词?word 的 重复值为 k 。单词 word?的 最大重复值?是单词?word?在?sequence?中最大的重复值。如果?word?不是?sequence?的子串，那么重复值?k?为 0 。
 * <p>
 * 给你一个字符串 sequence?和 word?，请你返回 最大重复值?k 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * 示例 2：
 * <p>
 * 输入：sequence = "ababc", word = "ba"
 * 输出：1
 * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 * 示例 3：
 * <p>
 * 输入：sequence = "ababc", word = "ac"
 * 输出：0
 * 解释："ac" 不是 "ababc" 的子字符串。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence 和?word?都只包含小写英文字母。
 * 通过次数4,792提交次数11,117
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-repeating-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxRepeating {

    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            count++;
            sb.append(word);
        }
        return count;
    }

    public static void main(String[] args) {
        MaxRepeating maxRepeating = new MaxRepeating();
        System.out.println(maxRepeating.maxRepeating("ababc","ab"));
        System.out.println(maxRepeating.maxRepeating("ababc","ba"));
        System.out.println(maxRepeating.maxRepeating("ababc","ac"));

        System.out.println(maxRepeating.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));

    }
}
