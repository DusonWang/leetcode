package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 注意:
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母'a'到'z'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        final int[] cs = new int[26];
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            cs[chars[i] - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int preIndex = -1;
        int maxIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = cs[chars[i] - 'a'];
            if (index > maxIndex) {
                maxIndex = index;
            }
            if (i == maxIndex) {
                result.add(maxIndex - preIndex);
                preIndex = maxIndex;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
