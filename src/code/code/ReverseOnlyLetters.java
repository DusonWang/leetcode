package code.code;

/**
 * @author duson
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * <p>
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * <p>
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *  
 * <p>
 * 提示：
 * <p>
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right
                    && !(arr[left] >= 'a' && arr[left] <= 'z')
                    && !(arr[left] >= 'A' && arr[left] <= 'Z')) {
                ++left;
            }
            while (left < right
                    && !(arr[right] >= 'a' && arr[right] <= 'z')
                    && !(arr[right] >= 'A' && arr[right] <= 'Z')) {
                --right;
            }
            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                ++left;
                --right;
            }
        }
        return new String(arr);
    }
}
