package com.leetcode.offer.code;

/**
 * @author duson
 * 现在给定一个只由字符 'D' 和 'I' 组成的 秘密签名。'D' 表示两个数字间的递减关系，'I' 表示两个数字间的递增关系。并且 秘密签名 是由一个特定的整数数组生成的，该数组唯一地包含 1 到 n 中所有不同的数字（秘密签名的长度加 1 等于 n）。例如，秘密签名 "DI" 可以由数组 [2,1,3] 或 [3,1,2] 生成，但是不能由数组 [3,2,4] 或 [2,1,3,4] 生成，因为它们都不是合法的能代表 "DI" 秘密签名 的特定串。
 * <p>
 * 现在你的任务是找到具有最小字典序的 [1, 2, ... n] 的排列，使其能代表输入的 秘密签名。
 * <p>
 * 示例 1：
 * <p>
 * 输入： "I"
 * 输出： [1,2]
 * 解释： [1,2] 是唯一合法的可以生成秘密签名 "I" 的特定串，数字 1 和 2 构成递增关系。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入： "DI"
 * 输出： [2,1,3]
 * 解释： [2,1,3] 和 [3,1,2] 可以生成秘密签名 "DI"，
 * 但是由于我们要找字典序最小的排列，因此你需要输出 [2,1,3]。
 *  
 * <p>
 * 注：
 * <p>
 * 输出字符串只会包含字符 'D' 和 'I'。
 * 输入字符串的长度是一个正整数且不会超过 10,000。
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPermutation {

    public int[] findPermutation(String s) {
        int len = s.length();
        int[] res = new int[len + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        int i = 1;
        while (i <= len) {
            int j = i;
            while (i <= len && s.charAt(i - 1) == 'D') {
                i++;
            }
            reverse(res, j - 1, i);
            i++;
        }
        return res;
    }

    private void reverse(int[] a, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            int temp = a[i + start];
            a[i + start] = a[end - i - 1];
            a[end - i - 1] = temp;
        }
    }
}
