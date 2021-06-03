package code.code;

import java.util.Arrays;

/**
 * 给定一个由 0 和 1 组成的数组?A，将数组分成 3?个非空的部分，使得所有这些部分表示相同的二进制值。
 * <p>
 * 如果可以做到，请返回任何?[i, j]，其中 i+1 < j，这样一来：
 * <p>
 * A[0], A[1], ..., A[i]?组成第一部分；
 * A[i+1], A[i+2], ..., A[j-1]?作为第二部分；
 * A[j], A[j+1], ..., A[A.length - 1] 是第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回?[-1, -1]。
 * <p>
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0]?表示十进制中的?6，而不会是?3。此外，前导零也是被允许的，所以?[0,1,1] 和?[1,1]?表示相同的值。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,1,0,1]
 * 输出：[0,3]
 * 示例 2：
 * <p>
 * 输出：[1,1,0,1,1]
 * 输出：[-1,-1]
 * ?
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 30000
 * A[i] == 0?或?A[i] == 1
 * ?
 * <p>
 * 通过次数3,005提交次数9,173
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-equal-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeEqualParts {

    public int[] threeEqualParts(int[] aa) {
        int[] res = new int[]{-1, -1};
        int numOf1 = 0;
        for (int a : aa) {
            if (a == 1) {
                numOf1++;
            }
        }
        if (numOf1 == 0) {
            return new int[]{0, 2};
        }
        if (numOf1 % 3 != 0) {
            return res;
        }
        int partLength = numOf1 / 3;
        int index0 = -1;
        int index1 = -1;
        int index2 = -1;
        numOf1 = 0;
        for (int i = 0; i < aa.length; i++) {
            if (aa[i] == 1) {
                numOf1++;
                if (numOf1 == 1) {
                    index0 = i;
                } else if (numOf1 == partLength + 1) {
                    index1 = i;
                } else if (numOf1 == 2 * partLength + 1) {
                    index2 = i;
                }
            }
        }
        while (index2 < aa.length) {
            if (aa[index2] == aa[index0] && aa[index2] == aa[index1]) {
                index2++;
                index1++;
                index0++;
            } else {
                return res;
            }
        }
        return new int[]{index0 - 1, index1};
    }

    public static void main(String[] args) {
        ThreeEqualParts threeEqualParts = new ThreeEqualParts();
        System.out.println(Arrays.toString(threeEqualParts.threeEqualParts(new int[]{1, 0, 1, 0, 1})));
    }
}
