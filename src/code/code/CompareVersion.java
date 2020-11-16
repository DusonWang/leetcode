package code.code;

/**
 * @author duson
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 * <p>
 *  . 字符不代表小数点，而是用于分隔数字序列。
 * <p>
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * <p>
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 * 示例 2:
 * <p>
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 * 示例 4：
 * <p>
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 * 示例 5：
 * <p>
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 *  
 * <p>
 * 提示：
 * <p>
 * 版本字符串由以点 （.） 分隔的数字字符串组成。这个数字字符串可能有前导零。
 * 版本字符串不以点开始或结束，并且其中不会有两个连续的点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        char[] chars1 = version1.toCharArray();
        char[] chars2 = version2.toCharArray();
        int i = 0, j = 0;
        int v1 = 0, v2 = 0;
        int len1 = chars1.length, len2 = chars2.length;
        while (i < len1 || j < len2) {
            while (i < len1 && chars1[i] != '.') {
                v1 = 10 * v1 + chars1[i++] - '0';
            }
            while (j < len2 && chars2[j] != '.') {
                v2 = 10 * v2 + chars2[j++] - '0';
            }
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            i++;
            j++;
            v1 = 0;
            v2 = 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
        System.out.println(compareVersion.compareVersion("1.01", "1.001"));
        System.out.println(compareVersion.compareVersion("1.0.1", "1"));
        System.out.println(compareVersion.compareVersion("0.1", "1.0"));
        System.out.println(compareVersion.compareVersion("7.5.2.4", "7.5.3"));

    }
}
