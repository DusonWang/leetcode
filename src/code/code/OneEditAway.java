package code.code;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * <p>
 * 示例?1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * 示例?2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * 通过次数5,902提交次数18,716
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author duson
 */
public class OneEditAway {

    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        int i = 0, j = len1 - 1, k = len2 - 1;
        while (i < len1 && i < len2 && first.charAt(i) == second.charAt(i)) {
            ++i;
        }
        while (j >= 0 && k >= 0 && first.charAt(j) == second.charAt(k)) {
            --j;
            --k;
        }
        return j - i < 1 && k - i < 1;
    }

}
