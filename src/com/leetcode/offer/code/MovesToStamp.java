package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 你想要用小写字母组成一个目标字符串?target。?
 * <p>
 * 开始的时候，序列由?target.length?个?'?'?记号组成。而你有一个小写字母印章?stamp。
 * <p>
 * 在每个回合，你可以将印章放在序列上，并将序列中的每个字母替换为印章上的相应字母。你最多可以进行?10 * target.length? 个回合。
 * <p>
 * 举个例子，如果初始序列为 "?????"，而你的印章 stamp?是?"abc"，那么在第一回合，你可以得到?"abc??"、"?abc?"、"??abc"。（请注意，印章必须完全包含在序列的边界内才能盖下去。）
 * <p>
 * 如果可以印出序列，那么返回一个数组，该数组由每个回合中被印下的最左边字母的索引组成。如果不能印出序列，就返回一个空数组。
 * <p>
 * 例如，如果序列是 "ababc"，印章是 "abc"，那么我们就可以返回与操作?"?????" -> "abc??" -> "ababc" 相对应的答案 [0, 2]；
 * <p>
 * 另外，如果可以印出序列，那么需要保证可以在 10 * target.length?个回合内完成。任何超过此数字的答案将不被接受。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：stamp = "abc", target = "ababc"
 * 输出：[0,2]
 * （[1,0,2] 以及其他一些可能的结果也将作为答案被接受）
 * 示例 2：
 * <p>
 * 输入：stamp = "abca", target = "aabcaca"
 * 输出：[3,0,1]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= stamp.length <= target.length <= 1000
 * stamp 和?target?只包含小写字母。
 * 通过次数769提交次数2,291
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stamping-the-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovesToStamp {

    public int[] movesToStamp(String stamp, String target) {
        List<Integer> result = new ArrayList<>();
        char[] targetArray = target.toCharArray();
        if (!dfs(targetArray, result, stamp, targetArray.length)) {
            return new int[0];
        }
        int[] arrayResult = new int[result.size()];
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = result.get(arrayResult.length - 1 - i);
        }
        return arrayResult;
    }

    private boolean dfs(char[] array, List<Integer> result, String stamp, int left) {
        if (left == 0) {
            return true;
        }
        for (int i = 0; i < array.length - stamp.length() + 1; i++) {
            int remove = isEqual(array, i, stamp);
            if (remove > 0) {
                result.add(i);
                for (int j = 0; j < stamp.length(); j++) {
                    array[i + j] = '#';
                }
                return dfs(array, result, stamp, left - remove);
            }
        }
        return false;
    }

    private int isEqual(char[] array, int start, String stamp) {
        int remove = 0;
        for (int i = 0; i < stamp.length(); i++) {
            if (array[i + start] == '#') {
                continue;
            }
            if (array[i + start] == stamp.charAt(i)) {
                remove++;
                continue;
            }
            return -1;
        }
        return remove;
    }
}
