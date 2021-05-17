package code.code;

import java.util.Arrays;

/**
 * 列表的 异或和（XOR sum）指对所有元素进行按位 XOR 运算的结果。如果列表中仅有一个元素，那么其 异或和 就等于该元素。
 * <p>
 * 例如，[1,2,3,4] 的 异或和 等于 1 XOR 2 XOR 3 XOR 4 = 4 ，而 [3] 的 异或和 等于 3 。
 * 给你两个下标 从 0 开始 计数的数组 arr1 和 arr2 ，两数组均由非负整数组成。
 * <p>
 * 根据每个?(i, j) 数对，构造一个由 arr1[i] AND arr2[j]（按位 AND 运算）结果组成的列表。其中 0 <= i < arr1.length 且 0 <= j < arr2.length 。
 * <p>
 * 返回上述列表的 异或和 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,2,3], arr2 = [6,5]
 * 输出：0
 * 解释：列表 = [1 AND 6, 1 AND 5, 2 AND 6, 2 AND 5, 3 AND 6, 3 AND 5] = [0,1,2,0,2,1] ，
 * 异或和 = 0 XOR 1 XOR 2 XOR 0 XOR 2 XOR 1 = 0 。
 * 示例 2：
 * <p>
 * 输入：arr1 = [12], arr2 = [4]
 * 输出：4
 * 解释：列表 = [12 AND 4] = [4] ，异或和 = 4 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 105
 * 0 <= arr1[i], arr2[j] <= 109
 * 通过次数3,269提交次数6,577
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-xor-sum-of-all-pairs-bitwise-and
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetXORSum {

    public int getXORSum(int[] arr1, int[] arr2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i : arr1) {
            sum1 ^= i;
        }
        for (int i : arr2) {
            sum2 ^= i;
        }
        return sum1 & sum2;
    }

    public static void main(String[] args) {
        GetXORSum getXORSum = new GetXORSum();
        System.out.println(getXORSum.getXORSum(new int[]{1, 2, 3}, new int[]{6, 5}));
    }
}
