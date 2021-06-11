package code.code;

/**
 * 一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World"，"HELLO"，"hello world hello world"都是句子。每个单词都 只包含大写和小写英文字母。
 * <p>
 * 如果两个句子sentence1 和sentence2，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的。比方说，sentence1 = "Hello my name is Jane" 且sentence2 = "Hello Jane"，我们可以往 sentence2中"Hello" 和"Jane"之间插入"my name is"得到 sentence1。
 * <p>
 * 给你两个句子sentence1 和sentence2，如果sentence1 和sentence2 是相似的，请你返回true，否则返回false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
 * 输出：true
 * 解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
 * 示例 2：
 * <p>
 * 输入：sentence1 = "of", sentence2 = "A lot of words"
 * 输出：false
 * 解释：没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
 * 示例 3：
 * <p>
 * 输入：sentence1 = "Eating right now", sentence2 = "Eating"
 * 输出：true
 * 解释：可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
 * 示例 4：
 * <p>
 * 输入：sentence1 = "Luky", sentence2 = "Lucccky"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence1.length, sentence2.length <= 100
 * sentence1和sentence2都只包含大小写英文字母和空格。
 * sentence1和sentence2中的单词都只由单个空格隔开。
 * 通过次数4,850提交次数9,044
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sentence-similarity-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AreSentencesSimilar3 {

    public boolean areSentencesSimilar(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        int i = 0;
        int n1 = words1.length;
        int n2 = words2.length;
        if (n1 > n2) {
            return areSentencesSimilar(s2, s1);
        }
        while (i < n1 && words1[i].equals(words2[i])) {
            ++i;
        }
        while (i < n1 && words1[i].equals(words2[n2 - n1 + i])) {
            ++i;
        }
        return i == n1;
    }

}
