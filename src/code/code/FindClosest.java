package code.code;

/**
 * @author duson
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 * <p>
 * words.length <= 100000
 * 通过次数2,838提交次数4,195
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-closest-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindClosest {

    public int findClosest(String[] words, String word1, String word2) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                left = i;
                ans = Math.min(ans, Math.abs(right - left));
            } else if (words[i].equals(word2)) {
                right = i;
                ans = Math.min(ans, Math.abs(right - left));
            }
            if (ans == 1) {
                return 1;
            }
        }
        return ans;
    }
}
