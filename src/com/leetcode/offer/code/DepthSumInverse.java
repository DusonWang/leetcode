package com.leetcode.offer.code;

import java.util.List;

/**
 * @author duson
 * 给一个嵌套整数序列，请你返回每个数字在序列中的加权和，它们的权重由它们的深度决定。
 * <p>
 * 序列中的每一个元素要么是一个整数，要么是一个序列（这个序列中的每个元素也同样是整数或序列）。
 * <p>
 * 与 前一个问题 不同的是，前一题的权重按照从根到叶逐一增加，而本题的权重从叶到根逐一增加。
 * <p>
 * 也就是说，在本题中，叶子的权重为1，而根拥有最大的权重。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: 8
 * 解释: 四个 1 在深度为 1 的位置， 一个 2 在深度为 2 的位置。
 * 示例 2:
 * <p>
 * 输入: [1,[4,[6]]]
 * 输出: 17
 * 解释: 一个 1 在深度为 3 的位置， 一个 4 在深度为 2 的位置，一个 6 在深度为 1 的位置。 1*3 + 4*2 + 6*1 = 17。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nested-list-weight-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DepthSumInverse {

    static class NestedInteger {

        public NestedInteger() {
        }

        public boolean isInteger() {
            return false;
        }

        public Integer getInteger() {
            return null;
        }

        public void setInteger(int value) {
        }

        public List<NestedInteger> getList() {
            return null;
        }

        public void add(NestedInteger ni) {
        }

    }

    private int maxLevel = 0;
    private int sum = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        countLevels(nestedList, 0);
        sum(nestedList, maxLevel);
        return sum;
    }

    private void countLevels(List<NestedInteger> nestedList, int level) {
        if (!nestedList.isEmpty()) {
            level++;
        }
        boolean isNested = false;
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger()) {
                isNested = true;
                countLevels(ni.getList(), level);
            }
        }
        if (!isNested) {
            if (level > maxLevel) {
                maxLevel = level;
            }
        }
    }

    public void sum(List<NestedInteger> nestedList, int weightedValue) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += weightedValue * ni.getInteger();
            } else {
                sum(ni.getList(), weightedValue - 1);
            }
        }
    }
}
