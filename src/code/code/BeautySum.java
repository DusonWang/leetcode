package code.code;

/**
 * 一个字符串的 美丽值定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * <p>
 * 比方说，"abaacc"的美丽值为3 - 1 = 2。
 * 给你一个字符串s，请你返回它所有子字符串的美丽值之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * 示例 2：
 * <p>
 * 输入：s = "aabcbaa"
 * 输出：17
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s只包含小写英文字母。
 * 通过次数3,608提交次数7,158
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-beauty-of-all-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BeautySum {

    public int beautySum(String s) {
        int ans = 0;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            int[] count = new int[26];
            for (int j = i; j < len; ++j) {
                char ch = s.charAt(j);
                count[ch - 'a'] += 1;
                int maxValue = Integer.MIN_VALUE;
                int minValue = Integer.MAX_VALUE;
                for (int value : count) {
                    if (value > 0) {
                        if (value > maxValue) {
                            maxValue = value;
                        }
                        if (value < minValue) {
                            minValue = value;
                        }
                    }
                }
                ans += (maxValue - minValue);
            }
        }
        return ans;
    }

}
