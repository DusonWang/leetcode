package code.code;

import java.util.*;

/**
 * @author duson
 * 为搜索引擎设计一个搜索自动补全系统。用户会输入一条语句（最少包含一个字母，以特殊字符 '#' 结尾）。除 '#' 以外用户输入的每个字符，返回历史中热度前三并以当前输入部分为前缀的句子。下面是详细规则：
 * <p>
 * 一条句子的热度定义为历史上用户输入这个句子的总次数。
 * 返回前三的句子需要按照热度从高到低排序（第一个是最热门的）。如果有多条热度相同的句子，请按照 ASCII 码的顺序输出（ASCII 码越小排名越前）。
 * 如果满足条件的句子个数少于 3，将它们全部输出。
 * 如果输入了特殊字符，意味着句子结束了，请返回一个空集合。
 * 你的工作是实现以下功能：
 * <p>
 * 构造函数：
 * <p>
 * AutocompleteSystem(String[] sentences, int[] times): 这是构造函数，输入的是历史数据。 Sentences 是之前输入过的所有句子，Times 是每条句子输入的次数，你的系统需要记录这些历史信息。
 * <p>
 * 现在，用户输入一条新的句子，下面的函数会提供用户输入的下一个字符：
 * <p>
 * List<String> input(char c): 其中 c 是用户输入的下一个字符。字符只会是小写英文字母（'a' 到 'z' ），空格（' '）和特殊字符（'#'）。输出历史热度前三的具有相同前缀的句子。
 * <p>
 *  
 * <p>
 * 样例 ：
 * 操作 ： AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
 * 系统记录下所有的句子和出现的次数：
 * "i love you" : 5 次
 * "island" : 3 次
 * "ironman" : 2 次
 * "i love leetcode" : 2 次
 * 现在，用户开始新的键入：
 * <p>
 * <p>
 * 输入 ： input('i')
 * 输出 ： ["i love you", "island","i love leetcode"]
 * 解释 ：
 * 有四个句子含有前缀 "i"。其中 "ironman" 和 "i love leetcode" 有相同的热度，由于 ' ' 的 ASCII 码是 32 而 'r' 的 ASCII 码是 114，所以 "i love leetcode" 在 "ironman" 前面。同时我们只输出前三的句子，所以 "ironman" 被舍弃。
 * <p>
 * 输入 ： input(' ')
 * 输出 ： ["i love you","i love leetcode"]
 * 解释:
 * 只有两个句子含有前缀 "i "。
 * <p>
 * 输入 ： input('a')
 * 输出 ： []
 * 解释 ：
 * 没有句子有前缀 "i a"。
 * <p>
 * 输入 ： input('#')
 * 输出 ： []
 * 解释 ：
 * <p>
 * 用户输入结束，"i a" 被存到系统中，后面的输入被认为是下一次搜索。
 * <p>
 *  
 * <p>
 * 注释 ：
 * <p>
 * 输入的句子以字母开头，以 '#' 结尾，两个字母之间最多只会出现一个空格。
 * 即将搜索的句子总数不会超过 100。每条句子的长度（包括已经搜索的和即将搜索的）也不会超过 100。
 * 即使只有一个字母，输出的时候请使用双引号而不是单引号。
 * 请记住清零 AutocompleteSystem 类中的变量，因为静态变量、类变量会在多组测试数据中保存之前结果。详情请看这里。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-search-autocomplete-system
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AutocompleteSystem {

    private Trie trie;

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        int n = sentences.length;
        for (int i = 0; i < n; ++i) {
            trie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        return trie.searchChar(c);
    }

    static class Trie {
        private TrieNode root;
        private TrieNode current;
        private PriorityQueue<TrieNode> pq;
        private StringBuilder sb;

        public Trie() {
            root = new TrieNode();
            current = root;
            Comparator<TrieNode> comparator = (node1, node2) -> {
                if (node1.times != node2.times) {
                    return node1.times - node2.times;
                }
                return node2.sentence.compareTo(node1.sentence);
            };
            pq = new PriorityQueue<>(4, comparator);
            sb = new StringBuilder();
        }

        private void insert(String sentence, int times) {
            int n = sentence.length();
            for (int i = 0; i < n; ++i) {
                insertNewChar(sentence.charAt(i));
            }
            current.sentence = sentence;
            current.times += times;
            current = root;
        }

        private boolean insertNewChar(char c) {
            int charNo = c == ' ' ? 26 : c - 'a';
            if (current.children[charNo] != null) {
                current = current.children[charNo];
                return false;
            }
            current.children[charNo] = new TrieNode();
            current = current.children[charNo];
            return true;
        }

        private List<String> searchChar(char c) {
            List<String> result = new ArrayList<>();
            if (c == '#') {
                current.sentence = sb.toString();
                ++current.times;
                current = root;
                sb.delete(0, sb.length());
                return result;
            }

            sb.append(c);

            if (insertNewChar(c)) {
                return result;
            }

            searchSentence(current);
            while (pq.peek() != null) {
                result.add(0, pq.poll().sentence);
            }
            return result;
        }

        private void searchSentence(TrieNode node) {
            if (node.sentence != null) {
                pq.offer(node);
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
            for (TrieNode child : node.children) {
                if (child != null) {
                    searchSentence(child);
                }
            }
        }

        static class TrieNode {
            public TrieNode[] children;
            public String sentence;
            public int times;

            public TrieNode() {
                times = 0;
                children = new TrieNode[27];
                sentence = null;
            }
        }
    }
}
