package com.leetcode.offer.code;

/**
 * @author duson
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k​​​​​​​ 个更新的操作。
 * <p>
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 * <p>
 * 请你返回 k 次操作后的数组。
 * <p>
 * 示例:
 * <p>
 * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * 输出: [-2,0,3,5,3]
 * 解释:
 * <p>
 * 初始状态:
 * [0,0,0,0,0]
 * <p>
 * 进行了操作 [1,3,2] 后的状态:
 * [0,2,2,2,0]
 * <p>
 * 进行了操作 [2,4,3] 后的状态:
 * [0,2,5,5,3]
 * <p>
 * 进行了操作 [0,2,-2] 后的状态:
 * [-2,0,3,5,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-addition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetModifiedArray {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            for (int j = start; j <= end; j++) {
                res[j] += inc;
            }
        }
        return res;
    }

    public int[] getModifiedArray2(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];
            res[start] += value;
            if (end < length - 1) {
                res[end + 1] -= value;
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}
