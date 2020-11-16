package code.code;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 5
 * <p>
 * 输出: 9
 * 通过次数2,459提交次数4,711
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetKthMagicNumber {

    public int getKthMagicNumber(int k) {
        int p3 = 0, p5 = 0, p7 = 0;
        int[] arr = new int[k];
        arr[0] = 1;
        for (int i = 1; i < k; i++) {
            arr[i] = Math.min(arr[p3] * 3, Math.min(arr[p5] * 5, arr[p7] * 7));
            if (arr[i] == arr[p3] * 3) {
                p3++;
            }
            if (arr[i] == arr[p5] * 5) {
                p5++;
            }
            if (arr[i] == arr[p7] * 7) {
                p7++;
            }
        }
        return arr[k - 1];
    }
}
