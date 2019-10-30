package com.leetcode.offer.day52;

/**
 * @author duson
 * 写一个 bash 脚本以统计一个文本文件 words.txt 中每个单词出现的频率。
 * <p>
 * 为了简单起见，你可以假设：
 * <p>
 * words.txt只包括小写字母和 ' ' 。
 * 每个单词只由小写字母组成。
 * 单词间由一个或多个空格字符分隔。
 * 示例:
 * <p>
 * 假设 words.txt 内容如下：
 * <p>
 * the day is sunny the the
 * the sunny is is
 * 你的脚本应当输出（以词频降序排列）：
 * <p>
 * the 4
 * is 3
 * sunny 2
 * day 1
 * 说明:
 * <p>
 * 不要担心词频相同的单词的排序问题，每个单词出现的频率都是唯一的。
 * 你可以使用一行 Unix pipes 实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordFrequency {

    //cat words.txt | xargs -n 1 | sort | uniq -c | sort -nr | awk '{print $2" "$1}'

}
