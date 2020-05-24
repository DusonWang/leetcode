package com.leetcode.offer.code;

import java.util.*;

/**
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * <p>
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * 示例 2:
 * <p>
 * 输入:
 * big = [1,2,3]
 * small = [4]
 * 输出: []
 * 提示：
 * <p>
 * big.length?<= 100000
 * 1 <= small.length?<= 100000
 * 通过次数1,217提交次数2,865
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-supersequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestSeq {

    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> goalMap = new HashMap<>(small.length);
        for (int each : small) {
            goalMap.put(each, 0);
        }
        LinkedList<Integer> containList = new LinkedList<>();
        int end = 0;
        int containNum = 0;
        List<Integer> resultList = new ArrayList<>();
        int len = Integer.MAX_VALUE;
        while (end < big.length) {
            while (containNum < small.length && end < big.length) {
                if (goalMap.containsKey(big[end])) {
                    int num = goalMap.get(big[end]);
                    if (num == 0) {
                        containNum++;
                    }
                    goalMap.put(big[end], num + 1);
                    containList.add(end);
                }
                end++;
            }
            while (!containList.isEmpty() && containNum == small.length) {
                int start = containList.pollFirst();
                int num = goalMap.get(big[start]);
                if (num == 1) {
                    containNum--;
                    if (end - start < len) {
                        resultList.clear();
                        resultList.add(start);
                        resultList.add(end - 1);
                        len = end - start;
                    }
                }
                goalMap.put(big[start], num - 1);
            }
        }
        if (resultList.size() == 0) {
            return new int[0];
        } else {
            int[] result = new int[2];
            result[0] = resultList.get(0);
            result[1] = resultList.get(1);
            return result;
        }
    }
}
