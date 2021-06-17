package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。
 * <p>
 * 「超赞子字符串」需满足满足下述两个条件：
 * <p>
 * 该字符串是 s 的一个非空子字符串
 * 进行任意次数的字符交换后，该字符串可以变成一个回文字符串
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3242415"
 * 输出：5
 * 解释："24241" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "24142"
 * 示例 2：
 * <p>
 * 输入：s = "12345678"
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = "213123"
 * 输出：6
 * 解释："213123" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "231132"
 * 示例 4：
 * <p>
 * 输入：s = "00"
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 仅由数字组成
 * 通过次数2,132提交次数5,801
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-longest-awesome-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestAwesome {

    public int longestAwesome(String s) {
        Map<Integer, Integer> bitXor = new HashMap<>();
        bitXor.put(0, -1);
        int currXor = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            currXor ^= (1 << (s.charAt(i) - '0'));
            Integer value = bitXor.get(currXor);
            if (value != null) {
                maxLength = Math.max(maxLength, i - value);
            }
            for (int j = 0; j <= 9; j++) {
                int oddLength = currXor ^ (1 << j);
                Integer tmp = bitXor.get(oddLength);
                if (tmp != null) {
                    maxLength = Math.max(maxLength, i - tmp);
                }
            }
            bitXor.putIfAbsent(currXor, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestAwesome longestAwesome = new LongestAwesome();
        System.out.println(longestAwesome.longestAwesome("3242415"));
        System.out.println(longestAwesome.longestAwesome("12345678"));
        System.out.println(longestAwesome.longestAwesome("213123"));
        System.out.println(longestAwesome.longestAwesome("00"));
    }
}
