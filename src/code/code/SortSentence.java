package code.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一个 句子?指的是一个序列的单词用单个空格连接起来，且开头和结尾没有任何空格。每个单词都只包含小写或大写英文字母。
 * <p>
 * 我们可以给一个句子添加 从 1 开始的单词位置索引 ，并且将句子中所有单词?打乱顺序?。
 * <p>
 * 比方说，句子?"This is a sentence"?可以被打乱顺序得到?"sentence4 a3 is2 This1"?或者?"is2 sentence4 This1 a3"?。
 * 给你一个 打乱顺序?的句子?s?，它包含的单词不超过?9?个，请你重新构造并得到原本顺序的句子。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "is2 sentence4 This1 a3"
 * 输出："This is a sentence"
 * 解释：将 s 中的单词按照初始位置排序，得到 "This1 is2 a3 sentence4" ，然后删除数字。
 * 示例 2：
 * <p>
 * 输入：s = "Myself2 Me1 I4 and3"
 * 输出："Me Myself and I"
 * 解释：将 s 中的单词按照初始位置排序，得到 "Me1 Myself2 and3 I4" ，然后删除数字。
 * ?
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 200
 * s?只包含小写和大写英文字母、空格以及从?1?到?9?的数字。
 * s?中单词数目为?1?到?9?个。
 * s?中的单词由单个空格分隔。
 * s?不包含任何前导或者后缀空格。
 * 通过次数2,348提交次数2,914
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorting-the-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortSentence {

    public String sortSentence(String s) {
        String[] a = s.split(" ");
        Arrays.sort(a, Comparator.comparingInt(o -> o.charAt(o.length() - 1)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i], 0, a[i].length() - 1);
            if (i < a.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
