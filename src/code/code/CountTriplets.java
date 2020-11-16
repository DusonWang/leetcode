package code.code;

/**
 * @author duson
 * <p>
 * 给定一个整数数组 A，找出索引为 (i, j, k) 的三元组，使得：
 * <p>
 * 0 <= i < A.length
 * 0 <= j < A.length
 * 0 <= k < A.length
 * A[i] & A[j] & A[k] == 0，其中 & 表示按位与（AND）操作符。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[2,1,3]
 * 输出：12
 * 解释：我们可以选出如下 i, j, k 三元组：
 * (i=0, j=0, k=1) : 2 & 2 & 1
 * (i=0, j=1, k=0) : 2 & 1 & 2
 * (i=0, j=1, k=1) : 2 & 1 & 1
 * (i=0, j=1, k=2) : 2 & 1 & 3
 * (i=0, j=2, k=1) : 2 & 3 & 1
 * (i=1, j=0, k=0) : 1 & 2 & 2
 * (i=1, j=0, k=1) : 1 & 2 & 1
 * (i=1, j=0, k=2) : 1 & 2 & 3
 * (i=1, j=1, k=0) : 1 & 1 & 2
 * (i=1, j=2, k=0) : 1 & 3 & 2
 * (i=2, j=0, k=1) : 3 & 2 & 1
 * (i=2, j=1, k=0) : 3 & 1 & 2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 1000
 * 0 <= A[i] < 2^16
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triples-with-bitwise-and-equal-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountTriplets {

    public int countTriplets(int[] a) {
        int ans = 0;
        int[] map = new int[1 << 16];
        for (int value : a) {
            for (int i : a) {
                map[value & i]++;
            }
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                continue;
            }
            for (int value : a) {
                if ((value & i) == 0) {
                    ans += map[i];
                }
            }
        }
        return ans;
    }

    /**
     * 给你一个整数数组 arr 。
     * <p>
     * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
     * <p>
     * a 和 b 定义如下：
     * <p>
     * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
     * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
     * 注意：^ 表示 按位异或 操作。
     * <p>
     * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [2,3,1,6,7]
     * 输出：4
     * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
     * 示例 2：
     * <p>
     * 输入：arr = [1,1,1,1,1]
     * 输出：10
     * 示例 3：
     * <p>
     * 输入：arr = [2,3]
     * 输出：0
     * 示例 4：
     * <p>
     * 输入：arr = [1,3,5,7,9]
     * 输出：3
     * 示例 5：
     * <p>
     * 输入：arr = [7,11,12,9,5,2,7,17,22]
     * 输出：8
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 300
     * 1 <= arr[i] <= 10^8
     * 通过次数3,495提交次数5,615
     * 在真实的面试中遇到过这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int countTriplets2(int[] arr) {
        int result = 0;
        int[] curXor = new int[arr.length];
        curXor[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            curXor[i] = arr[i] ^ curXor[i - 1];
        }
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                for (int k = j; k < arr.length; ++k) {
                    int a = curXor[j - 1] ^ (i == 0 ? 0 : curXor[i - 1]);
                    int b = curXor[k] ^ curXor[j - 1];
                    if (a == b) {
                        ++result;
                    }
                }
            }
        }
        return result;
    }

    public int countTriplets3(int[] arr) {
        int resule = 0;
        for (int i = 0; i < arr.length; i++) {
            int param = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                param ^= arr[j];
                if (param == 0) {
                    resule += j - i;
                }
            }
        }
        return resule;
    }
}
