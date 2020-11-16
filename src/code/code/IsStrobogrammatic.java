package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * <p>
 * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入:  "69"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:  "88"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入:  "962"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsStrobogrammatic {

    public boolean isStrobogrammatic2(String num) {
        int[] dict = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int len = num.length();
        if ((len & 1) == 1 && dict[num.charAt(len / 2) - '0'] == -1) {
            return false;
        }
        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            if (num.charAt(j) - '0' != dict[num.charAt(i) - '0']) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('0', '0');
        map.put('9', '6');
        map.put('6', '9');
        map.put('8', '8');
        final int len = num.length();
        for (int i = 0; i < len; i++) {
            if (map.get(num.charAt(i)) == null || map.get(num.charAt(i)) != num.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsStrobogrammatic strobogrammatic = new IsStrobogrammatic();
        System.out.println(strobogrammatic.isStrobogrammatic("69"));
        System.out.println(strobogrammatic.isStrobogrammatic("88"));
        System.out.println(strobogrammatic.isStrobogrammatic("962"));

    }
}
