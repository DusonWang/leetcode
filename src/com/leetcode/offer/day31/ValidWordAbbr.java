package com.leetcode.offer.day31;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author duson
 * 一个单词的缩写需要遵循 <起始字母><中间字母数><结尾字母> 这样的格式。
 * <p>
 * 以下是一些单词缩写的范例：
 * <p>
 * a) it                      --> it    (没有缩写)
 * <p>
 * 1
 * ↓
 * b) d|o|g                   --> d1g
 * <p>
 * 1    1  1
 * 1---5----0----5--8
 * ↓   ↓    ↓    ↓  ↓
 * c) i|nternationalizatio|n  --> i18n
 * <p>
 * 1
 * 1---5----0
 *      ↓   ↓    ↓
 * d) l|ocalizatio|n          --> l10n
 * 假设你有一个字典和一个单词，请你判断该单词的缩写在这本字典中是否唯一。若单词的缩写在字典中没有任何 其他 单词与其缩写相同，则被称为单词的唯一缩写。
 * <p>
 * 示例：
 * <p>
 * 给定 dictionary = [ "deer", "door", "cake", "card" ]
 * <p>
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-word-abbreviation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidWordAbbr {

    private final Map<String, Set<String>> abbrDict = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) {
            String abbr = toAbbr(s);
            Set<String> words = abbrDict.containsKey(abbr) ? abbrDict.get(abbr) : new HashSet<>();
            words.add(s);
            abbrDict.put(abbr, words);
        }
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        Set<String> words = abbrDict.get(abbr);
        return words == null || (words.size() == 1 && words.contains(word));
    }

    private String toAbbr(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }

    public static void main(String[] args) {
        //["ValidWordAbbr","isUnique"]
        //[[["hello"]],["hello"]]
        ValidWordAbbr wordAbbr = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(wordAbbr.isUnique("dear"));
        System.out.println(wordAbbr.isUnique("cart"));
        System.out.println(wordAbbr.isUnique("cane"));
        System.out.println(wordAbbr.isUnique("make"));

    }
}
