package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���ϳ��ַ���big��һ�������϶��ַ���������smalls�����һ������������smalls�е�ÿһ���϶��ַ�������big�������������smalls�е��ַ�����big����ֵ�����λ��positions������positions[i]Ϊsmalls[i]���ֵ�����λ�á�
 * <p>
 * ʾ����
 * <p>
 * ���룺
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * ����� [[1,4],[8],[],[3],[1,4,7,10],[5]]
 * ��ʾ��
 * <p>
 * 0 <= len(big) <= 1000
 * 0 <= len(smalls[i]) <= 1000
 * smalls�����ַ������ᳬ�� 100000��
 * �������Ϊsmalls��û���ظ��ַ�����
 * ���г��ֵ��ַ���ΪӢ��Сд��ĸ��
 * ͨ������1,351�ύ����3,098
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/multi-search-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
