package com.leetcode.offer.day3;

import java.util.*;

/**
 * @author duson
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations {

    private final String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        list.add("");
        final int len = digits.length();
        for (int i = 0; i < len; i++) {
            int x = digits.charAt(i) - '0';
            while (list.peek() != null && list.peek().length() == i) {
                String t = list.remove();
                for (char s : mapping[x].toCharArray()) {
                    list.add(t + s);
                }
            }
        }
        return list;
    }

    public List<String> letterCombinations2(String digits) {
        List<String> arr1 = new ArrayList<>(16);
        List<String> arr2 = new ArrayList<>(16);
        // List<String> result;
        if (digits == null || digits.length() == 0) {
            return arr1;
        }
        arr1.add("");
        for (int i = 0; i < digits.length(); i++) {
            String tmpChar = mapping[digits.charAt(i) - '0'];
            for (String s : arr1) {
                for (int k = 0; k < tmpChar.length(); k++) {
                    String str = s + tmpChar.charAt(k);
                    arr2.add(str);
                }
            }
            arr1 = arr2;
            arr2 = new ArrayList<>(16);
        }
        return arr1;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("234"));
    }
}
