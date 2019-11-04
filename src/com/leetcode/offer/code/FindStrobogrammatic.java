package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * <p>
 * 找到所有长度为 n 的中心对称数。
 * <p>
 * 示例 :
 * <p>
 * 输入:  n = 2
 * 输出: ["11","69","88","96"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindStrobogrammatic {

    public List<String> findStrobogrammatic2(int n) {
        List<String> res = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        helper(n, 0, new char[n], map, res);
        if (n == 1) {
            res.add("0");
        }
        return res;
    }

    private void helper(int n, int index, char[] word,
                        Map<Character, Character> map, List<String> res) {
        if (index == (n + 1) / 2) {
            res.add(new String(word));
            return;
        }
        for (Character cur : map.keySet()) {
            if (index == 0 && cur == '0') {
                continue;
            }
            if (index == n - index - 1 && (cur == '6' || cur == '9')) {
                continue;
            }
            word[index] = cur;
            word[n - index - 1] = map.get(cur);
            helper(n, index + 1, word, map, res);
        }
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> list = helper(n);
        List<String> newList = new ArrayList<>();
        for (String str : list) {
            if (n == 1 || str.charAt(0) != '0') {
                newList.add(str);
            }
        }
        return newList;
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

    public static void main(String[] args) {
        FindStrobogrammatic findStrobogrammatic = new FindStrobogrammatic();
        System.out.println(findStrobogrammatic.findStrobogrammatic(3));
        System.out.println(findStrobogrammatic.findStrobogrammatic(1));

    }
}
