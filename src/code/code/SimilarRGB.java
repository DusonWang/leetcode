package code.code;

/**
 * @author duson
 * RGB 颜色用十六进制来表示的话，每个大写字母都代表了某个从 0 到 f 的 16 进制数。
 * <p>
 * RGB 颜色 "#AABBCC" 可以简写成 "#ABC" 。例如，"#15c" 其实是 "#1155cc" 的简写。
 * <p>
 * 现在，假如我们分别定义两个颜色 "#ABCDEF" 和 "#UVWXYZ"，则他们的相似度可以通过这个表达式 -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2 来计算。
 * <p>
 * 那么给定颜色 "#ABCDEF"，请你返回一个与 #ABCDEF 最相似的 7 个字符代表的颜色，并且它是可以被简写形式表达的。（比如，可以表示成类似 "#XYZ" 的形式）
 * <p>
 * 示例 1：
 * 输入：color = "#09f166"
 * 输出："#11ee66"
 * 解释：
 * 因为相似度计算得出 -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73
 * 这已经是所有可以简写的颜色中最相似的了
 * 注意：
 * <p>
 * color 是一个长度为 7 的字符串
 * color 是一个有效的 RGB 颜色：对于仍和 i > 0，color[i] 都是一个在 0 到 f 范围的 16 进制数
 * 假如答案具有相同的（最大）相似度的话，都是可以被接受的
 * 所有输入、输出都必须使用小写字母，并且输出为 7 个字符
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/similar-rgb-color
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SimilarRGB {

    public String similarRGB(String color) {
        return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) + f(color.substring(5));
    }

    private String f(String comp) {
        int q = Integer.parseInt(comp, 16);
        q = q / 17 + (q % 17 > 8 ? 1 : 0);
        return String.format("%02x", 17 * q);
    }

}
