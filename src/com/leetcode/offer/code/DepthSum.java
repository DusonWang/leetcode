package com.leetcode.offer.code;

import java.util.List;

/**
 * @author duson
 * <p>
 * 给定一个嵌套的整数列表，请返回该列表按深度加权后所有整数的总和。
 * <p>
 * 每个元素要么是整数，要么是列表。同时，列表中元素同样也可以是整数或者是另一个列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: 10
 * 解释: 因为列表中有四个深度为 2 的 1 ，和一个深度为 1 的 2。
 * 示例 2:
 * <p>
 * 输入: [1,[4,[6]]]
 * 输出: 27
 * 解释: 一个深度为 1 的 1，一个深度为 2 的 4，一个深度为 3 的 6。所以，1 + 4*2 + 6*3 = 27。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nested-list-weight-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DepthSum {

    public static class NestedInteger {

        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {

        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }


    public int depthSum(List<NestedInteger> nestedList) {
        return deep(nestedList, 1);
    }

    private int deep(List<NestedInteger> nestedList, int deep) {
        int sum = 0;
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                sum += deep * nest.getInteger();
            } else {
                sum += deep(nest.getList(), deep + 1);
            }
        }
        return sum;
    }
}
