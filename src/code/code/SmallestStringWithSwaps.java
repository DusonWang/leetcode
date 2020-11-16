package code.code;

import java.util.*;

/**
 * ����һ���ַ���?s���Լ����ַ����е�һЩ�������ԡ�����?pairs������?pairs[i] =?[a, b]?��ʾ�ַ����е�������������Ŵ� 0 ��ʼ����
 * <p>
 * ����� �����ν��� ��?pairs?������һ�����������ַ���
 * <p>
 * �����ھ������ɴν�����s?���Ա�ɵİ��ֵ�����С���ַ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1:
 * <p>
 * ���룺s = "dcab", pairs = [[0,3],[1,2]]
 * �����"bacd"
 * ���ͣ�
 * ���� s[0] �� s[3], s = "bcad"
 * ���� s[1] �� s[2], s = "bacd"
 * ʾ�� 2��
 * <p>
 * ���룺s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * �����"abcd"
 * ���ͣ�
 * ���� s[0] �� s[3], s = "bcad"
 * ���� s[0] �� s[2], s = "acbd"
 * ���� s[1] �� s[2], s = "abcd"
 * ʾ�� 3��
 * <p>
 * ���룺s = "cba", pairs = [[0,1],[1,2]]
 * �����"abc"
 * ���ͣ�
 * ���� s[0] �� s[1], s = "bca"
 * ���� s[1] �� s[2], s = "bac"
 * ���� s[0] �� s[1], s = "abc"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] <?s.length
 * s?��ֻ����СдӢ����ĸ
 * ͨ������2,758�ύ����8,852
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/smallest-string-with-swaps
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SmallestStringWithSwaps {

    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    private void union(int[] parent, int A, int B) {
        int parentA = find(parent, A);
        int parentB = find(parent, B);
        parent[parentB] = parentA;
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(parent, pair.get(0), pair.get(1));
        }

        char[] result = s.toCharArray();
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            if (!groups.containsKey(root)) {
                groups.put(root, new ArrayList<>());
            }
            groups.get(root).add(i);
        }
        for (Integer key : groups.keySet()) {
            char[] tmp = new char[groups.get(key).size()];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = s.charAt(groups.get(key).get(i));
            }
            Arrays.sort(tmp);
            for (int i = 0; i < tmp.length; i++) {
                result[groups.get(key).get(i)] = tmp[i];
            }
        }
        return new String(result);
    }

}
