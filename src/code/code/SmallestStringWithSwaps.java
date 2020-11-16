package code.code;

import java.util.*;

/**
 * 给你一个字符串?s，以及该字符串中的一些「索引对」数组?pairs，其中?pairs[i] =?[a, b]?表示字符串中的两个索引（编号从 0 开始）。
 * <p>
 * 你可以 任意多次交换 在?pairs?中任意一对索引处的字符。
 * <p>
 * 返回在经过若干次交换后，s?可以变成的按字典序最小的字符串。
 * <p>
 * ?
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 * <p>
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] <?s.length
 * s?中只含有小写英文字母
 * 通过次数2,758提交次数8,852
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestStringWithSwaps {

    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    private void union(int[] parent, int A, int B) {
        int parentA = find(parent, A);
        int parentB = find(parent, B);
        parent[parentB] = parentA;
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(parent, pair.get(0), pair.get(1));
        }

        char[] result = s.toCharArray();
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            if (!groups.containsKey(root)) {
                groups.put(root, new ArrayList<>());
            }
            groups.get(root).add(i);
        }
        for (Integer key : groups.keySet()) {
            char[] tmp = new char[groups.get(key).size()];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = s.charAt(groups.get(key).get(i));
            }
            Arrays.sort(tmp);
            for (int i = 0; i < tmp.length; i++) {
                result[groups.get(key).get(i)] = tmp[i];
            }
        }
        return new String(result);
    }

}
