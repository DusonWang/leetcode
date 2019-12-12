package com.leetcode.offer.code;

/**
 * @author duson
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * <p>
 * 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distant-barcodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RearrangeBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length == 0) {
            return barcodes;
        }
        int maxfre = 0, n = barcodes.length;
        int[] res = new int[n];
        int[] fre = new int[10001];

        for (int code : barcodes) {
            fre[code]++;
            if (fre[code] > fre[maxfre]) {
                maxfre = code;
            }
        }

        int idx = 0;
        for (int i = 0; i < fre.length; i++) {
            int curr = i == 0 ? maxfre : i;
            while (fre[curr] > 0) {
                if (idx >= n) {
                    idx = 1;
                }
                res[idx] = curr;
                idx += 2;
                fre[curr]--;
            }
        }
        return res;
    }
}
