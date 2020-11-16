package code.code;

/**
 * @author duson
 * 给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。
 * <p>
 * “最近的”定义为两个整数差的绝对值最小。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "123"
 * 输出: "121"
 * 注意:
 * <p>
 * n 是由字符串表示的正整数，其长度不超过18。
 * 如果有多个结果，返回最小的那个。
 * 通过次数1,368提交次数9,884
 * 在真实的面试中遇到过这道题？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-closest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NearestPalindromic {

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        if (num == 0) {
            return "1";
        }
        if (num == 11) {
            return "9";
        }
        if (num <= 10 || Math.log10(num) % 1 == 0) {
            return num - 1 + "";
        }

        long exp = n.length() - (n.length() - 1) / 2 - 1;
        long offset = (long) Math.pow(10, exp);
        return min(num, palindrome(n), palindrome(num + offset + ""), palindrome(num - offset + ""));
    }

    private String min(long target, long s1, long s2, long s3) {
        long[] array = {s1, s2, s3};
        long[] distance = new long[3];
        for (int i = 0; i < array.length; i++) {
            distance[i] = Math.abs(target - array[i]);
            if (distance[i] == 0) {
                distance[i] = Long.MAX_VALUE;
            }
        }
        int minIndex = distance[0] > distance[1] ? 1 : 0;
        return array[distance[2] > distance[minIndex] ? minIndex : 2] + "";
    }

    private long palindrome(String n) {
        char[] c = n.toCharArray();
        for (int i = 0; i < c.length / 2; i++) {
            c[c.length - i - 1] = c[i];
        }
        return new Long(new String(c));
    }
}
