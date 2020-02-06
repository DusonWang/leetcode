package com.leetcode.offer.code;

import java.util.List;

/**
 * @author duson
 * 验证原始的序列 org 是否可以从序列集 seqs 中唯一地重建。序列 org 是 1 到 n 整数的排列，其中 1 ≤ n ≤ 104。重建是指在序列集 seqs 中构建最短的公共超序列。（即使得所有  seqs 中的序列都是该最短序列的子序列）。确定是否只可以从 seqs 重建唯一的序列，且该序列就是 org 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * org: [1,2,3], seqs: [[1,2],[1,3]]
 * <p>
 * 输出：
 * false
 * <p>
 * 解释：
 * [1,2,3] 不是可以被重建的唯一的序列，因为 [1,3,2] 也是一个合法的序列。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * org: [1,2,3], seqs: [[1,2]]
 * <p>
 * 输出：
 * false
 * <p>
 * 解释：
 * 可以重建的序列只有 [1,2]。
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入：
 * org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 * <p>
 * 输出：
 * true
 * <p>
 * 解释：
 * 序列 [1,2], [1,3] 和 [2,3] 可以被唯一地重建为原始的序列 [1,2,3]。
 *  
 * <p>
 * 示例 4：
 * <p>
 * 输入：
 * org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 * <p>
 * 输出：
 * true
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sequence-reconstruction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SequenceReconstruction {

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        boolean[] flag = new boolean[org.length];
        int[] idx = new int[org.length + 1];
        for (int i = 0; i < org.length; i++) {
            if (idx[org[i]] != 0) {
                return false;
            } else {
                idx[org[i]] = i;
            }
        }
        boolean finalNumFlag = false;
        for (List<Integer> seq : seqs) {
            int last = -1;
            for (Integer i : seq) {
                if (i > org.length || i < 1) {
                    return false;
                }
                if (last != -1) {
                    if (idx[i] - last == 1) {
                        flag[last] = true;
                    } else if (idx[i] <= last) {
                        return false;
                    }
                }
                last = idx[i];
                if (idx[i] == org.length - 1) {
                    finalNumFlag = true;
                }
            }
        }

        for (int i = 0; i < org.length - 1; i++) {
            if (!flag[i]) {
                return false;
            }
        }
        return finalNumFlag;
    }
}
