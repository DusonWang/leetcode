package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * <p>
 * 输入: 701
 * 输出: "ZY"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertToTitle {

    public String convertToTitle(int n) {
        String a = "@ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % 26 == 0) {
                sb.append("Z");
                n = n / 26 - 1;
            } else {
                sb.append(a.charAt(n % 26));
                n = n / 26;
            }
        }
        return sb.reverse().toString();
    }

    public String convertToTitle2(int n) {
        String res = "";
        int temp;
        while (n != 0) {
            n--;
            temp = n % 26;
            res = (char) (temp + 'A') + res;
            n = n / 26;
        }
        return res;

    }
}
