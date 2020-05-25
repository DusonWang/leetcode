package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 * 提示：
 * <p>
 * 0 <= len(big) <= 1000
 * 0 <= len(smalls[i]) <= 1000
 * smalls的总字符数不会超过 100000。
 * 你可以认为smalls中没有重复字符串。
 * 所有出现的字符均为英文小写字母。
 * 通过次数1,351提交次数3,098
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multi-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MultiSearch {

    private static class Node {
        Node[] childes = new Node[26];
        boolean isLeaf = false;
        int id = 0;
    }

    private Node root;

    public int[][] multiSearch(String big, String[] smalls) {
        root = new Node();
        int n = smalls.length;
        List<Integer>[] res = new List[n];
        for (int i = 0; i < n; i++) {
            res[i] = new ArrayList<>();
        }
        for (int i = 0; i < smalls.length; i++) {
            addWord(smalls[i], i);
        }
        outer:
        for (int i = 0; i < big.length(); i++) {
            Node node = root;
            for (int j = i; j < big.length(); j++) {
                char c = big.charAt(j);
                if (node.childes[c - 'a'] == null) {
                    continue outer;
                }
                node = node.childes[c - 'a'];
                if (node.isLeaf) {
                    res[node.id].add(i);
                }
            }
        }
        int[][] resArray = new int[n][];
        for (int i = 0; i < n; i++) {
            resArray[i] = new int[res[i].size()];
            for (int j = 0; j < resArray[i].length; j++) {
                resArray[i][j] = res[i].get(j);
            }
        }
        return resArray;
    }

    private void addWord(String word, int id) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.childes[c - 'a'] == null) {
                node.childes[c - 'a'] = new Node();
            }
            node = node.childes[c - 'a'];
        }
        node.isLeaf = true;
        node.id = id;
    }
}
