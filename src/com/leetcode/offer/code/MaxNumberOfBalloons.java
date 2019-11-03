package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        int ans = 10000;
        String began = "balloon";
        int[] arr = new int[26];
        for (char c : text.toCharArray()) {
            arr[c - 'a']++;
        }
        arr['l' - 'a'] = arr['l' - 'a'] / 2;
        arr['o' - 'a'] = arr['o' - 'a'] / 2;

        int[] arrNew = new int[7];
        for (int i = 0; i < arrNew.length; i++) {
            arrNew[i] = arr[began.charAt(i) - 'a'];
            ans = Math.min(ans, arrNew[i]);
        }
        return ans;
    }
}
