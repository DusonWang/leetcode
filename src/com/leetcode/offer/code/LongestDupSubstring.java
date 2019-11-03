package com.leetcode.offer.code;

/**
 * @author duson
 * 给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。
 * <p>
 * 返回任何具有最长可能长度的重复子串。（如果 S 不含重复子串，那么答案为 ""。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："banana"
 * 输出："ana"
 * 示例 2：
 * <p>
 * 输入："abcd"
 * 输出：""
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= S.length <= 10^5
 * S 由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-duplicate-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestDupSubstring {

//    public String longestDupSubstring(String s) {
//        int lo = 1;
//        int hi = s.length() - 1;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            int startIndex = search(s, mid);
//            if (startIndex == -1) {
//                hi = mid - 1;
//            } else {
//                lo = mid + 1;
//            }
//        }
//        int startIndex = search(s, hi);
//        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + hi);
//    }
//
//    public int search(String s, int len) {
//        long h = 0;
//        long al = 1;
//        int a = 26;
//        int mod = 1 << 30;
//        for (int i = 0; i < len; i++) {
//            h = (h * a % mod + s.charAt(i)) % mod;
//            al = al * a % mod;
//        }
//        HashMap<Long, List<Integer>> visited = new HashMap<>();
//        visited.put(h, new ArrayList<>());
//        visited.get(h).add(0);
//        for (int i = 1; i < s.length() - len + 1; i++) {
//            h = ((h * a % mod - s.charAt(i - 1) * al % mod + mod) % mod + s.charAt(i + len - 1)) % mod;
//            if (visited.containsKey(h)) {
//                for (int start : visited.get(h)) {
//                    if (s.substring(start, start + len).equals(s.substring(i, i + len))) {
//                        return i;
//                    }
//                }
//            } else {
//                visited.put(h, new ArrayList<>());
//            }
//            visited.get(h).add(i);
//        }
//        return -1;
//    }
}
