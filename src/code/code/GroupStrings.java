package code.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * <p>
 * 给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
 * <p>
 * "abc" -> "bcd" -> ... -> "xyz"
 * 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。
 * <p>
 * 示例：
 * <p>
 * 输入: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
 * 输出:
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-shifted-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = encode(s);
            List<String> values = map.computeIfAbsent(key, k -> new ArrayList<>());
            values.add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String encode(String s) {
        char[] buf = s.toCharArray();
        int diff = buf[0] - 'a';
        for (int i = 0; i < buf.length; i++) {
            buf[i] -= diff;
            if (buf[i] < 'a') {
                buf[i] += 26;
            }
        }
        return new String(buf);
    }

    public static void main(String[] args) {
        String[] str = new String[]{"abc", "xyz"};
        GroupStrings g = new GroupStrings();
        System.out.println(g.groupStrings(str));
    }
}
