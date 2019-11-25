package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 我们定制了一款特殊的力扣键盘，所有的键都排列在一行上。
 * <p>
 * 我们可以按从左到右的顺序，用一个长度为 26 的字符串 keyboard （索引从 0 开始，到 25 结束）来表示该键盘的键位布局。
 * <p>
 * 现在需要测试这个键盘是否能够有效工作，那么我们就需要个机械手来测试这个键盘。
 * <p>
 * 最初的时候，机械手位于左边起第一个键（也就是索引为 0 的键）的上方。当机械手移动到某一字符所在的键位时，就会在终端上输出该字符。
 * <p>
 * 机械手从索引 i 移动到索引 j 所需要的时间是 |i - j|。
 * <p>
 * 当前测试需要你使用机械手输出指定的单词 word，请你编写一个函数来计算机械手输出该单词所需的时间。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
 * 输出：4
 * 解释：
 * 机械手从 0 号键移动到 2 号键来输出 'c'，又移动到 1 号键来输出 'b'，接着移动到 0 号键来输出 'a'。
 * 总用时 = 2 + 1 + 1 = 4.
 * 示例 2：
 * <p>
 * 输入：keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
 * 输出：73
 *  
 * <p>
 * 提示：
 * <p>
 * keyboard.length == 26
 * keyboard 按某种特定顺序排列，并包含每个小写英文字母一次。
 * 1 <= word.length <= 10^4
 * word[i] 是一个小写英文字母
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-row-keyboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CalculateTime {

    public int calculateTime(String keyboard, String word) {
        char[] ch = word.toCharArray();
        char[] ch1 = keyboard.toCharArray();
        int sum = 0;
        int start = 0;
        for (char c : ch) {
            for (int j = 0; j < ch1.length; j++) {
                if (c == ch1[j]) {
                    sum += Math.abs(start - j);
                    start = j;
                    break;
                }
            }
        }
        return sum;
    }
}
