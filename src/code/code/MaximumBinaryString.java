package code.code;

import java.util.Arrays;

/**
 * 给你一个二进制字符串?binary?，它仅有?0?或者?1?组成。你可以使用下面的操作任意次对它进行修改：
 * <p>
 * 操作 1 ：如果二进制串包含子字符串?"00"?，你可以用?"10"?将其替换。
 * 比方说，?"00010" -> "10010"
 * 操作 2 ：如果二进制串包含子字符串?"10"?，你可以用?"01"?将其替换。
 * 比方说，?"00010" -> "00001"
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串?。如果二进制字符串 x?对应的十进制数字大于二进制字符串 y?对应的十进制数字，那么我们称二进制字符串?x?大于二进制字符串?y?。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：binary = "000110"
 * 输出："111011"
 * 解释：一个可行的转换为：
 * "000110" -> "000101"
 * "000101" -> "100101"
 * "100101" -> "110101"
 * "110101" -> "110011"
 * "110011" -> "111011"
 * 示例 2：
 * <p>
 * 输入：binary = "01"
 * 输出："01"
 * 解释："01" 没办法进行任何转换。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= binary.length <= 105
 * binary 仅包含?'0' 和?'1' 。
 * 通过次数2,427提交次数5,130
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-string-after-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumBinaryString {

    public String maximumBinaryString(String binary) {
        int zeros = 0;
        int ones = 0;
        int len = binary.length();
        char[] chars = binary.toCharArray();
        while (ones < len && chars[ones] == '1') {
            ones++;
        }
        for (char c : chars) {
            if (c == '0') {
                zeros++;
            }
        }
        if (zeros == 0) {
            return binary;
        }
        char[] ar = new char[len];
        Arrays.fill(ar, '1');
        ar[ones + zeros - 1] = '0';
        return String.valueOf(ar);
    }

    public static void main(String[] args) {
        MaximumBinaryString maximumBinaryString = new MaximumBinaryString();
        System.out.println(maximumBinaryString.maximumBinaryString("0110"));
    }
}
