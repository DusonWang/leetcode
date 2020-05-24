package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 两个(具有不同单词的)文档的交集(intersection)中元素的个数除以并集(union)中元素的个数，就是这两个文档的相似度。例如，{1, 5, 3} 和 {1, 7, 2, 3} 的相似度是 0.4，其中，交集的元素有 2 个，并集的元素有 5 个。给定一系列的长篇文档，每个文档元素各不相同，并与一个 ID 相关联。它们的相似度非常“稀疏”，也就是说任选 2 个文档，相似度都很接近 0。请设计一个算法返回每对文档的 ID 及其相似度。只需输出相似度大于 0 的组合。请忽略空文档。为简单起见，可以假定每个文档由一个含有不同整数的数组表示。
 * <p>
 * 输入为一个二维数组 docs，docs[i]?表示?id 为 i 的文档。返回一个数组，其中每个元素是一个字符串，代表每对相似度大于 0 的文档，其格式为 {id1},{id2}: {similarity}，其中 id1 为两个文档中较小的 id，similarity 为相似度，精确到小数点后 4 位。以任意顺序返回数组均可。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ? [14, 15, 100, 9, 3],
 * ? [32, 1, 9, 3, 5],
 * ? [15, 29, 2, 6, 8, 7],
 * ? [7, 10]
 * ]
 * 输出:
 * [
 * ? "0,1: 0.2500",
 * ? "0,2: 0.1000",
 * ? "2,3: 0.1429"
 * ]
 * 提示：
 * <p>
 * docs.length <= 500
 * docs[i].length <= 500
 * 相似度大于 0 的文档对数不会超过 1000
 * 通过次数589提交次数1,918
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-similarity-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
