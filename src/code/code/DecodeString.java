package code.code;

import java.util.Stack;

/**
 * @author duson
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeString {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> stackMulti = new Stack<>();
        Stack<String> stackRes = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stackMulti.push(multi);
                stackRes.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curMulti = stackMulti.pop();
                for (int i = 0; i < curMulti; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stackRes.pop() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        //System.out.println(decodeString.decodeString("13[a]2[bc]"));
        System.out.println(decodeString.decodeString("3[a2[c]]"));
        //System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));


    }
}
