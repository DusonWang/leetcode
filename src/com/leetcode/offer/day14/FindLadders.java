package com.leetcode.offer.day14;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author duson
 * <p>
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLadders {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) {
            return res;
        }
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return res;
        }
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Map<String, List<String>> map = new HashMap<>();
        bfs(map, beginSet, endSet, dict, false);

        List<String> tempList = new ArrayList<>();
        tempList.add(beginWord);
        dfs(map, res, tempList, beginWord, endWord);
        return res;
    }

    private void bfs(Map<String, List<String>> map, Set<String> beginSet, Set<String> endSet, Set<String> dict, boolean reverse) {
        if (beginSet.size() == 0) {
            return;
        }
        boolean findMin = false;
        dict.removeAll(beginSet);
        HashSet<String> nextSet = new HashSet<>();
        for (String word : beginSet) {
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char temp = arr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (temp == ch) {
                        continue;
                    }
                    arr[i] = ch;
                    String nextWord = new String(arr);
                    if (dict.contains(nextWord)) {
                        if (endSet.contains(nextWord)) {
                            findMin = true;
                        } else {
                            nextSet.add(nextWord);
                        }
                        String key = reverse ? nextWord : word;
                        String value = reverse ? word : nextWord;
                        if (!map.containsKey(key)) {
                            map.put(key, new ArrayList<>());
                        }
                        map.get(key).add(value);
                    }
                }
                arr[i] = temp;
            }
        }
        if (!findMin) {
            if (nextSet.size() > endSet.size()) {
                bfs(map, endSet, nextSet, dict, !reverse);
            } else {
                bfs(map, nextSet, endSet, dict, reverse);
            }
        }
    }

    private void dfs(Map<String, List<String>> map, List<List<String>> res, List<String> tempList, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        if (!map.containsKey(beginWord)) {
            return;
        }
        for (String word : map.get(beginWord)) {
            tempList.add(word);
            dfs(map, res, tempList, word, endWord);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
        List<String> list = new ArrayList<>(16);
        list.add("ted");
        list.add("tex");
        list.add("red");
        list.add("tax");
        list.add("tad");
        list.add("den");
        list.add("rex");
        list.add("pee");
        System.out.println(findLadders.findLadders("red", "tax", list));

        list = new ArrayList<>(16);
        list.add("hot");
        list.add("cog");
        list.add("dog");
        list.add("tot");
        list.add("hog");
        list.add("hop");
        list.add("pot");
        list.add("dot");
        System.out.println(findLadders.findLadders("hot", "dog", list));
    }
}
