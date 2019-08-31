package com.leetcode.offer.day23;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * <p>
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s.toCharArray(), ans, 0);
        return ans;
    }

    private void dfs(char[] arr, List<String> e, int index) {
        if (index == arr.length) {
            e.add(String.valueOf(arr));
            return;
        }
        dfs(arr, e, index + 1);
        if (arr[index] < '0' || arr[index] > '9') {
            arr[index] ^= 32;
            dfs(arr, e, index + 1);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        System.out.println(letterCasePermutation.letterCasePermutation("a1b2"));
    }
}
