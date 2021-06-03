package code.code;

/**
 * 给你两个正整数 n 和 k，二进制字符串? Sn 的形成规则如下：
 * <p>
 * S1?= "0"
 * 当 i > 1 时，Si?=?Si-1?+ "1" + reverse(invert(Si-1))
 * 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）。
 * <p>
 * 例如，符合上述描述的序列的前 4 个字符串依次是：
 * <p>
 * S1?= "0"
 * S2?= "011"
 * S3?= "0111001"
 * S4 = "011100110110001"
 * 请你返回? Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 1
 * 输出："0"
 * 解释：S3 为 "0111001"，其第 1 位为 "0" 。
 * 示例 2：
 * <p>
 * 输入：n = 4, k = 11
 * 输出："1"
 * 解释：S4 为 "011100110110001"，其第 11 位为 "1" 。
 * 示例 3：
 * <p>
 * 输入：n = 1, k = 1
 * 输出："0"
 * 示例 4：
 * <p>
 * 输入：n = 2, k = 3
 * 输出："1"
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= 2n - 1
 * 通过次数6,869提交次数12,533
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-kth-bit-in-nth-binary-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthBit {

    public char findKthBit3(int n, int k) {
        return (char)((k / (k & -k) >> 1 & 1) ^ (k & 1 ^ 1) + '0');
    }

    public char findKthBit2(int n, int k) {
        int count = 0;
        int l = (1 << n) - 1;
        while (k > 1) {
            if (k == l / 2 + 1) {
                return count % 2 == 0 ? '1' : '0';
            }
            if (k > l / 2) {
                k = l + 1 - k;
                count++;
            }
            l /= 2;
        }
        return count % 2 == 0 ? '0' : '1';
    }

    public char findKthBit(int n, int k) {
        if (k == 1) {
            return '0';
        }
        int mid = 1 << (n - 1);
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            k = mid * 2 - k;
            return invert(findKthBit(n - 1, k));
        }
    }

    public char invert(char bit) {
        return (char) ('0' + '1' - bit);
    }

    public static void main(String[] args) {
        FindKthBit findKthBit = new FindKthBit();
        System.out.println(findKthBit.findKthBit(3, 1));
        System.out.println(findKthBit.findKthBit(4, 11));

    }
}
