package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * ����(���в�ͬ���ʵ�)�ĵ��Ľ���(intersection)��Ԫ�صĸ������Բ���(union)��Ԫ�صĸ����������������ĵ������ƶȡ����磬{1, 5, 3} �� {1, 7, 2, 3} �����ƶ��� 0.4�����У�������Ԫ���� 2 ����������Ԫ���� 5 ��������һϵ�еĳ�ƪ�ĵ���ÿ���ĵ�Ԫ�ظ�����ͬ������һ�� ID ����������ǵ����ƶȷǳ���ϡ�衱��Ҳ����˵��ѡ 2 ���ĵ������ƶȶ��ܽӽ� 0�������һ���㷨����ÿ���ĵ��� ID �������ƶȡ�ֻ��������ƶȴ��� 0 ����ϡ�����Կ��ĵ���Ϊ����������Լٶ�ÿ���ĵ���һ�����в�ͬ�����������ʾ��
 * <p>
 * ����Ϊһ����ά���� docs��docs[i]?��ʾ?id Ϊ i ���ĵ�������һ�����飬����ÿ��Ԫ����һ���ַ���������ÿ�����ƶȴ��� 0 ���ĵ������ʽΪ {id1},{id2}: {similarity}������ id1 Ϊ�����ĵ��н�С�� id��similarity Ϊ���ƶȣ���ȷ��С����� 4 λ��������˳�򷵻�������ɡ�
 * <p>
 * ʾ��:
 * <p>
 * ����:
 * [
 * ? [14, 15, 100, 9, 3],
 * ? [32, 1, 9, 3, 5],
 * ? [15, 29, 2, 6, 8, 7],
 * ? [7, 10]
 * ]
 * ���:
 * [
 * ? "0,1: 0.2500",
 * ? "0,2: 0.1000",
 * ? "2,3: 0.1429"
 * ]
 * ��ʾ��
 * <p>
 * docs.length <= 500
 * docs[i].length <= 500
 * ���ƶȴ��� 0 ���ĵ��������ᳬ�� 1000
 * ͨ������589�ύ����1,918
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sparse-similarity-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ComputeSimilarities {

    public List<String> computeSimilarities(int[][] docs) {
        List<String> ll = new ArrayList<>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        HashMap<String, Integer> hm2 = new LinkedHashMap<>();
        int[][] res = new int[docs.length][docs.length];
        for (int i = 0; i < docs.length; i++) {
            for (int j = 0; j < docs[i].length; j++) {
                if (hm.containsKey(docs[i][j])) {
                    for (int k : hm.get(docs[i][j])) {
                        hm2.put(i + "," + k, 0);
                        res[i][k]++;
                    }
                    hm.get(docs[i][j]).add(i);
                } else {
                    List<Integer> tl = new ArrayList<>();
                    tl.add(i);
                    hm.put(docs[i][j], tl);
                }
            }
        }
        hm2.forEach((s, k) -> {
            int i = Integer.parseInt(s.split(",")[0]);
            int j = Integer.parseInt(s.split(",")[1]);
            ll.add("" + j + "," + i + ": " + String.format("%.4f", (res[i][j] + 0.0) / (docs[i].length + docs[j].length - res[i][j])));
        });
        return ll;
    }
}
