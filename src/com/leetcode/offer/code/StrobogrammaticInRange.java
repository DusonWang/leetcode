package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author duson
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * <p>
 * 写一个函数来计算范围在 [low, high] 之间中心对称数的个数。
 * <p>
 * 示例:
 * <p>
 * 输入: low = "50", high = "100"
 * 输出: 3
 * 解释: 69，88 和 96 是三个在该范围内的中心对称数
 * 注意:
 * 由于范围可能很大，所以 low 和 high 都用字符串表示。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrobogrammaticInRange {

    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        for (int len = low.length(); len <= high.length(); len++) {
            List<String> ls = helper(len);
            for (String s : ls) {
                if ((s.length() == low.length() && s.compareTo(low) < 0)
                        || (s.length() == high.length() && s.compareTo(high) > 0)) {
                    continue;
                }
                if (len == 1 || s.charAt(0) != '0') {
                    count++;
                }
            }
        }
        return count;
    }

    private List<String> helper(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            return Collections.singletonList("");
        }
        if (n <= 1) {
            return Arrays.asList("1", "0", "8");
        }

        List<String> res = helper(n - 2);
        for (String tmp : res) {
            list.add("1" + tmp + "1");
            list.add("6" + tmp + "9");
            list.add("9" + tmp + "6");
            list.add("8" + tmp + "8");
            list.add("0" + tmp + "0");
        }
        return list;
    }

    private List<String> findHelper(int cur, int max) {
        if (cur == 0) {
            return new ArrayList<>(Collections.singletonList(""));
        }
        if (cur == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        List<String> res = new ArrayList<>();
        List<String> base = findHelper(cur - 2, max);
        for (String s : base) {
            if (cur != max) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("8" + s + "8");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
        }
        return res;
    }
}
