package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 *
 * 请你设计一个算法，可以将一个 字符串列表 编码成为一个 字符串。这个编码后的字符串是可以通过网络进行高效传送的，并且可以在接收端被解码回原来的字符串列表。
 *
 * 1 号机（发送方）有如下函数：
 *
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 * 2 号机（接收方）有如下函数：
 *
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 * 1 号机（发送方）执行：
 *
 * string encoded_string = encode(strs);
 * 2 号机（接收方）执行：
 *
 * vector<string> strs2 = decode(encoded_string);
 * 此时，2 号机（接收方）的 strs2 需要和 1 号机（发送方）的 strs 相同。
 *
 * 请你来实现这个 encode 和 decode 方法。
 *
 * 注意：
 *
 * 因为字符串可能会包含 256 个合法 ascii 字符中的任何字符，所以您的算法必须要能够处理任何可能会出现的字符。
 * 请勿使用 “类成员”、“全局变量” 或 “静态变量” 来存储这些状态，您的编码和解码算法应该是非状态依赖的。
 * 请不要依赖任何方法库，例如 eval 又或者是 serialize 之类的方法。本题的宗旨是需要您自己实现 “编码” 和 “解码” 算法。
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/encode-and-decode-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec4 {

//    // Encodes a list of strings to a single string.
//    private List<String> ss;
//    public String encode(List<String> strs) {
//        this.ss = strs;
//        return "";
//    }
//
//    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//        return ss;
//    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String item : strs) {
            int length = item.length();
            sb.append(length).append("/").append(item);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int pos = s.indexOf('/', i);
            int itemSize = Integer.parseInt(s.substring(i, pos));
            int start = pos + 1;
            int end = pos + itemSize + 1;
            if (end <= s.length()) {
                String item = s.substring(start, end);
                result.add(item);
            }
            i = end;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        Codec4 codec4 = new Codec4();
        System.out.println(codec4.encode(list));
        System.out.println(codec4.decode(codec4.encode(list)));
    }
}
