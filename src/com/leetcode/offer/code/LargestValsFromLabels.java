package com.leetcode.offer.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 我们有一个项的集合，其中第?i?项的值为?values[i]，标签为?labels[i]。
 * <p>
 * 我们从这些项中选出一个子集?S，这样一来：
 * <p>
 * |S| <= num_wanted
 * 对于任意的标签 L，子集 S 中标签为 L?的项的数目总满足?<= use_limit。
 * 返回子集?S?的最大可能的?和。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 * 示例 2：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 * 输出：12
 * 解释：选出的子集是第一项，第二项和第三项。
 * 示例 3：
 * <p>
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
 * 输出：16
 * 解释：选出的子集是第一项和第四项。
 * 示例 4：
 * <p>
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
 * 输出：24
 * 解释：选出的子集是第一项，第二项和第四项。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= values.length == labels.length <= 20000
 * 0 <= values[i], labels[i]?<= 20000
 * 1 <= num_wanted, use_limit?<= values.length
 * 通过次数1,998提交次数3,927
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-values-from-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author duson
 */
public class LargestValsFromLabels {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int len = values.length;
        int[][] items = new int[len][2];
        for (int i = 0; i < len; ++i) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }
        Arrays.sort(items, Comparator.comparingInt(i -> -i[0]));
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] item : items) {
            int labelCount = map.getOrDefault(item[1], 0);
            if (labelCount < useLimit) {
                res += item[0];
                if (--numWanted == 0) {
                    break;
                }
                map.put(item[1], labelCount + 1);
            }
        }
        return res;
    }
}
