package com.leetcode.offer.code;

/**
 * @author duson
 * 给一个字符串 s 和一个字符串列表 dict ，你需要将在字符串列表中出现过的 s 的子串添加加粗闭合标签 <b> 和 </b> 。如果两个子串有重叠部分，你需要把它们一起用一个闭合标签包围起来。同理，如果两个子字符串连续被加粗，那么你也需要把它们合起来用一个加粗标签包围。
 * <p>
 * 样例 1：
 * <p>
 * 输入：
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * 输出：
 * "<b>abc</b>xyz<b>123</b>"
 *  
 * <p>
 * 样例 2：
 * <p>
 * 输入：
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * 输出：
 * "<b>aaabbc</b>c"
 *  
 * <p>
 * 注意：
 * <p>
 * 给定的 dict 中不会有重复的字符串，且字符串数目不会超过 100 。
 * 输入中的所有字符串长度都在范围 [1, 1000] 内。
 *  
 * <p>
 * 通过次数1,043提交次数2,415
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-bold-tag-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBoldTag {

    public String addBoldTag(String s, String[] dict) {
        if (dict == null || dict.length == 0 || s == null || s.length() == 0) {
            return s;
        }
        int l = 0, r = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    r = Math.max(r, i + word.length());
                }
            }
            if (i == r) {
                sb.append("<b>").append(s, l, r).append("</b>");
            }
            if (i >= r) {
                sb.append(s.charAt(i));
                l = i + 1;
            }
        }
        if (r >= s.length()) {
            sb.append("<b>").append(s.substring(l)).append("</b>");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddBoldTag addBoldTag = new AddBoldTag();
        System.out.println(addBoldTag.addBoldTag("abcxyz123", new String[]{"abc", "xyz"}));
    }
}
