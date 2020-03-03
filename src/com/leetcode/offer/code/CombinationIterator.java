package com.leetcode.offer.code;

import java.util.PriorityQueue;

/**
 * @author duson
 * 请你设计一个迭代器类，包括以下内容：
 * <p>
 * 一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
 * 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
 * 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。
 *  
 * <p>
 * 示例：
 * <p>
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator
 * <p>
 * iterator.next(); // 返回 "ab"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "ac"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "bc"
 * iterator.hasNext(); // 返回 false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= combinationLength <= characters.length <= 15
 * 每组测试数据最多包含 10^4 次函数调用。
 * 题目保证每次调用函数 next 时都存在下一个字母组合。
 * 通过次数1,068提交次数1,877
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/iterator-for-combination
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationIterator {

    private PriorityQueue<String> pq = new PriorityQueue<>();

    public CombinationIterator(String s, int k) {
        generateSub(s, k, 0, new StringBuilder());
    }

    private void generateSub(String s, int len, int start, StringBuilder result) {
        if (len == 0) {
            pq.add(result.toString());
            return;
        }
        for (int i = start; i <= s.length() - len; i++) {
            result.append(s.charAt(i));
            generateSub(s, len - 1, i + 1, result);
            result.deleteCharAt(result.length() - 1);
        }
    }

    public String next() {
        return pq.poll();
    }

    public boolean hasNext() {
        return !pq.isEmpty();
    }
}
