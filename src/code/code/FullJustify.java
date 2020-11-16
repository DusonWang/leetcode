package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * <p>
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 * "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FullJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        if (words == null || words.length == 0) {
            return ret;
        }
        int length = 0;
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            if (length + words[i].length() <= maxWidth) {
                length += (words[i].length() + 1);
            } else {
                String line = getLine(words, start, i - 1, length, maxWidth);
                ret.add(line);
                start = i;
                length = words[i].length() + 1;
            }
        }
        String line = lastLine(words, start, maxWidth);
        ret.add(line);
        return ret;
    }

    private String lastLine(String[] words, int start, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        while (start < words.length - 1) {
            sb.append(words[start]);
            sb.append(' ');
            start++;
        }
        sb.append(words[words.length - 1]);
        while (sb.length() < maxWidth) {
            sb.append(' ');
        }
        return sb.toString();
    }

    private String getLine(String[] words, int start, int end, int length, int maxWidth) {
        int nums = end - start;
        int space = maxWidth - length + nums + 1;
        int avg = nums > 0 ? space / nums : 0;
        int more = nums > 0 ? space % nums : space;
        final StringBuilder sb = new StringBuilder();
        for (; start < end; start++) {
            sb.append(words[start]);
            for (int i = 0; i < avg; i++) {
                sb.append(' ');
            }
            if (more > 0) {
                sb.append(' ');
            }
            more--;
        }
        sb.append(words[end]);
        while (more > 0) {
            sb.append(' ');
            more--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        //String[] words = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        FullJustify fullJustify = new FullJustify();
        List<String> list = fullJustify.fullJustify(words, 16);
        for (String tmp : list) {
            System.out.println(tmp);
        }
    }
}
