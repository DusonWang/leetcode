package code.code;

import java.util.List;

/**
 * @author duson
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * <p>
 * 请返回所有可行解 s 中最长长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 * 示例 2：
 * <p>
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * 示例 3：
 * <p>
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] 中只含有小写英文字母
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxLength2 {

    private int max = 0;

    public int maxLength(List<String> arr) {
        int[] sign = new int[26];
        dfs(arr, 0, sign);
        return max;
    }

    public void dfs(List<String> arr, int index, int[] sign) {
        int sum = 0;
        for (int s : sign) {
            if (s > 1) {
                return;
            }
            sum += s == 0 ? 0 : 1;
        }
        max = Math.max(max, sum);
        if (index == arr.size()) {
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            String str = arr.get(i);
            for (int j = 0; j < str.length(); j++) {
                sign[str.charAt(j) - 'a']++;
            }
            dfs(arr, i + 1, sign);
            for (int j = 0; j < str.length(); j++) {
                sign[str.charAt(j) - 'a']--;
            }
        }
    }
}
