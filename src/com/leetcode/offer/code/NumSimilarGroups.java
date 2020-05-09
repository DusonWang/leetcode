package com.leetcode.offer.code;

/**
 * @author duson
 * 如果我们交换字符串?X 中的两个不同位置的字母，使得它和字符串?Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 * <p>
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)；?"rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 * <p>
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 * <p>
 * 我们给出了一个不包含重复的字符串列表 A。列表中的每个字符串都是 A 中其它所有字符串的一个字母异位词。请问 A 中有多少个相似字符串组？
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：["tars","rats","arts","star"]
 * 输出：2
 * ?
 * <p>
 * 提示：
 * <p>
 * A.length <= 2000
 * A[i].length <= 1000
 * A.length * A[i].length <= 20000
 * A 中的所有单词都只包含小写字母。
 * A 中的所有单词都具有相同的长度，且是彼此的字母异位词。
 * 此问题的判断限制时间已经延长。
 * ?
 * <p>
 * 备注：
 * <p>
 * ????? 字母异位词[anagram]，一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。
 * <p>
 * 通过次数2,256提交次数6,854
 * 在真实的面试中遇到过这道题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/similar-string-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSimilarGroups {

    private int[] par;

    public int findpar(int vtx) {
        if (par[vtx] == vtx) {
            return vtx;
        }
        return par[vtx] = findpar(par[vtx]);
    }

    public int isSame(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++count > 2) {
                return 0;
            }
        }
        return 1;
    }

    public int numSimilarGroups(String[] a) {
        int n = a.length;
        par = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            par[i] = i;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int p1 = findpar(i);
                int p2 = findpar(j);
                if (p1 != p2 && isSame(a[i], a[j]) == 1) {
                    n--;
                    par[p2] = p1;
                }
            }
        }
        return n;
    }
}
