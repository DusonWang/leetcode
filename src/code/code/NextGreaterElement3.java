package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12
 * 输出: 21
 * 示例 2:
 * <p>
 * 输入: 21
 * 输出: -1
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreaterElement3 {

    public int nextGreaterElement(int n) {
        char[] cArr = String.valueOf(n).toCharArray();
        int i = cArr.length - 1;
        while (i > 0 && cArr[i] <= cArr[i - 1]) {
            i--;
        }
        if (i <= 0) {
            return -1;
        }
        int j = cArr.length - 1;
        while (j >= i && cArr[j] <= cArr[i - 1]) {
            j--;
        }
        char tmp = cArr[j];
        cArr[j] = cArr[i - 1];
        cArr[i - 1] = tmp;
        Arrays.sort(cArr, i, cArr.length);
        try {
            return Integer.parseInt(String.valueOf(cArr));
        } catch (Exception e) {
        }
        return -1;
    }
}
