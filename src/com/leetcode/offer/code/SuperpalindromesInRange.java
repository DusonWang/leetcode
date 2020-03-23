package com.leetcode.offer.code;

/**
 * @author duson
 * 如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
 * <p>
 * 现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：L = "4", R = "1000"
 * 输出：4
 * 解释：
 * 4，9，121，以及 484 是超级回文数。
 * 注意 676 不是一个超级回文数： 26 * 26 = 676，但是 26 不是回文数。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= len(L) <= 18
 * 1 <= len(R) <= 18
 * L 和 R 是表示 [1, 10^18) 范围的整数的字符串。
 * int(L) <= int(R)
 *  
 * <p>
 * 通过次数893提交次数4,073
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-palindromes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SuperpalindromesInRange {

    public int superpalindromesInRange(String l, String r) {
        int low = (int)Math.ceil(Math.sqrt(Long.parseLong(l)));
        int high = (int)Math.floor(Math.sqrt(Long.parseLong(r)));
        int ret = (3 >= low && 3 <= high) ? 1 : 0;
        ret += dfs(low, high, "");
        ret += dfs(low, high, "0");
        ret += dfs(low, high, "1");
        ret += dfs(low, high, "2");
        return ret;
    }

    private int dfs(int low, int high, String s) {
        if (s.length() > Integer.toString(high).length()) {
            return 0;
        }
        int count = 0;
        if (!s.isEmpty() && s.charAt(0) != '0') {
            long num = Long.parseLong(s);
            if (num > high) {
                return 0;
            }
            if (num >= low && isP(num * num)) {
                count++;
            }
        }
        for (char c = '0'; c <= '2'; c++) {
            count += dfs(low, high, c + s + c);
        }
        return count;
    }

    private boolean isP(long num) {
        String s = Long.toString(num);
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
