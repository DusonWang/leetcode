package com.leetcode.offer.code;

/**
 * @author duson
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 * <p>
 * 示例 :
 * <p>
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * 注意:
 * <p>
 * 1 <= len(start) = len(end) <= 10000。
 * start和end中的字符串仅限于'L', 'R'和'X'。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-adjacent-in-lr-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanTransform {

    public boolean canTransform(String start, String end) {
        int l = start.length();
        int i = 0, j = 0;
        while (i < l && j < l) {
            while (start.charAt(i) == 'X' && i < l - 1) {
                ++i;
            }
            while (end.charAt(j) == 'X' && j < l - 1) {
                ++j;
            }
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            } else if (start.charAt(i) == 'L' && i < j) {
                return false;
            } else if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
