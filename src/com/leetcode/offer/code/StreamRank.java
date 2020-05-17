package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author duson
 * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说：
 * <p>
 * 实现 track(int x)?方法，每读入一个数字都会调用该方法；
 * <p>
 * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例:
 * <p>
 * 输入:
 * ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
 * [[], [1], [0], [0]]
 * 输出:
 * [null,0,null,1]
 * 提示：
 * <p>
 * x <= 50000
 * track?和?getRankOfNumber 方法的调用次数均不超过 2000 次
 * 通过次数749提交次数1,252
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rank-from-stream-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StreamRank {

    private final ArrayList<Integer> list;

    public StreamRank() {
        list = new ArrayList<>(50000);
    }

    public void track(int x) {
        int idx = Collections.binarySearch(list, x);
        if (idx < 0) {
            idx = -idx - 1;
        }
        list.add(idx, x);
    }

    public int getRankOfNumber(int x) {
        int idx = Collections.binarySearch(list, x);
        if (idx < 0) {
            idx = -idx - 1;
        }
        while (idx < list.size() && list.get(idx) <= x) {
            ++idx;
        }
        return idx;
    }
}
