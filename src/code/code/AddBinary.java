package code.code;

/**
 * @author duson
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        final int aLen = a.length() - 1;
        final int bLen = b.length() - 1;
        int ca = 0;
        for (int i = aLen, j = bLen; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2);
            ca = sum / 2;
        }
        sb.append(ca == 1 ? ca : "");
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        int shift = 0;
        int maxLen = a.length() > b.length() ? a.length() : b.length();
        char[] result = new char[maxLen + 1];

        for (int i = 0; i < maxLen; i++) {
            int sum = shift;
            if (i < a.length()) {
                int val = a.charAt(a.length() - 1 - i) - '0';
                sum += val;
            }
            if (i < b.length()) {
                int val = b.charAt(b.length() - 1 - i) - '0';
                sum += val;
            }
            int v = sum % 2;
            shift = sum / 2;

            result[maxLen - i] = (char) (v + '0');
        }
        if (shift > 0) {
            result[0] = (char) (shift + '0');
        }
        return result[0] == 0 ? new String(result, 1, result.length - 1) : new String(result);
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
    }
}
