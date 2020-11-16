package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAnagrams {

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] record = new int[128];
        for (char c : p.toCharArray()) {
            record[c]++;
        }
        char[] arr = s.toCharArray();
        int l = 0, r = 0;
        final int pLen = p.length();
        final int sLen = s.length();
        while (r < sLen) {
            if (record[arr[r]] > 0) {
                record[arr[r]]--;
                r++;
                if ((r - l) == pLen) {
                    list.add(l);
                }
            } else {
                record[arr[l]]++;
                l++;
            }
        }
        return list;
    }

    public List<Integer> findAnagrams(String s, String p) {
        final List<Integer> result = new ArrayList<>();
        final int pLen = p.length();
        final int sLen = s.length();
        final int[] pArray = new int[26];
        for (int i = 0; i < pLen; i++) {
            pArray[p.charAt(i) - 'a']++;
        }
        int start = 0, end = 0;
        final int[] bArray = new int[26];
        while (end < sLen) {
            int tmp = s.charAt(end++) - 'a';
            bArray[tmp]++;
            while (bArray[tmp] > pArray[tmp]) {
                bArray[s.charAt(start++) - 'a']--;
            }
            if (end - start == pLen) {
                result.add(start);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams2("cbaebabacd", "abc"));
    }
}
