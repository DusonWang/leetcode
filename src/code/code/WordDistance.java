package code.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * 请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 word1 和 word2，并返回列表中这两个单词之间的最短距离。您的方法将被以不同的参数调用 多次。
 * <p>
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
 * <p>
 * 输入: word1 = “coding”, word2 = “practice”
 * 输出: 3
 * 输入: word1 = "makes", word2 = "coding"
 * 输出: 1
 * 注意:
 * 你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-word-distance-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordDistance {

    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            } else {
                map.get(words[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
        while (l1 < list1.size() && l2 < list2.size()) {
            minDiff = Math.min(minDiff, Math.abs(list1.get(l1) - list2.get(l2)));
            if (list1.get(l1) < list2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        WordDistance wordDistance = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        System.out.println(wordDistance.shortest("coding", "practice"));
        System.out.println(wordDistance.shortest("makes", "coding"));

    }
}
