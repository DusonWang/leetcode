package code.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author duson
 * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
 * <p>
 * 示例:
 * <p>
 * 输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * <p>
 * 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRepeatedDnaSequences {

//    public List<String> findRepeatedDnaSequencesBit(String s) {
//        List<String> ans = new ArrayList<>();
//        if (s == null || s.length() < 10) {
//            return ans;
//        }
//        char[] c = s.toCharArray();
//        byte[] code = new byte[26];
//        code['C' - 'A'] = 1;
//        code['G' - 'A'] = 2;
//        code['T' - 'A'] = 3;
//        byte[] seen = new byte[1 << 20];
//        int n = 0;
//        for (int i = 0; i < 10; i++) {
//            n |= code[c[i] - 'A'] << (2 * i);
//        }
//        seen[n] = 1;
//        for (int i = 1; i < c.length - 9; i++) {
//            n = n >>> 2;
//            n |= code[c[i + 9] - 'A'] << 18;
//            if (seen[n] == 0) {
//                seen[n] = 1;
//            } else if (seen[n] == 1) {
//                seen[n] = 2;
//                ans.add(new String(c, i, 10));
//            }
//        }
//        return ans;
//    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return res;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String seq = s.substring(i, i + 10);
            if (set1.contains(seq)) {
                set2.add(seq);
            }
            set1.add(seq);
        }
        res.addAll(set2);
        return res;
    }
}
