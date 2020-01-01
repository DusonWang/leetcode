package com.leetcode.offer.code;

import java.util.List;

/**
 * @author duson
 * 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
 * <p>
 * 列表中的每个元素只可能是整数或整数嵌套列表
 * <p>
 * 提示：你可以假定这些字符串都是格式良好的：
 * <p>
 * 字符串非空
 * 字符串不包含空格
 * 字符串只包含数字0-9, [, - ,, ]
 *  
 * <p>
 * 示例 1：
 * <p>
 * 给定 s = "324",
 * <p>
 * 你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 给定 s = "[123,[456,[789]]]",
 * <p>
 * 返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 * <p>
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 * i.  一个 integer 包含值 456
 * ii. 一个包含一个元素的嵌套列表
 * a. 一个 integer 包含值 789
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/mini-parser
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MiniParser {

    public class NestedInteger {
        // Constructor initializes an empty nested list.
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
            return 0;
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

    public NestedInteger deserialize(String s) {
        NestedInteger ret = new NestedInteger();
        if (s == null || s.length() == 0) {
            return ret;
        }
        if (s.charAt(0) != '[') {
            ret.setInteger(Integer.parseInt(s));
        } else if (s.length() > 2) {
            int start = 1, count = 0;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (count == 0 && (c == ',' || i == s.length() - 1)) {
                    ret.add(deserialize(s.substring(start, i)));
                    start = i + 1;
                } else if (c == '[') {
                    count++;
                } else if (c == ']') {
                    count--;
                }
            }
        }
        return ret;
    }
}
