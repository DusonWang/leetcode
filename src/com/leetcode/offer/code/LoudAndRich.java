package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 在一组 N 个人（编号为?0, 1, 2, ..., N-1）中，每个人都有不同数目的钱，以及不同程度的安静（quietness）。
 * <p>
 * 为了方便起见，我们将编号为?x?的人简称为 "person?x?"。
 * <p>
 * 如果能够肯定 person?x?比 person?y?更有钱的话，我们会说?richer[i] = [x, y]?。注意?richer?可能只是有效观察的一个子集。
 * <p>
 * 另外，如果 person?x?的安静程度为?q?，我们会说?quiet[x] = q?。
 * <p>
 * 现在，返回答案?answer?，其中?answer[x] = y?的前提是，在所有拥有的钱不少于?person?x?的人中，person?y?是最安静的人（也就是安静值?quiet[y]?最小的人）。
 * <p>
 * 示例：
 * <p>
 * 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * 输出：[5,5,2,5,4,5,6,7]
 * 解释：
 * answer[0] = 5，
 * person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
 * 唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
 * 但是目前还不清楚他是否比 person 0 更有钱。
 * <p>
 * answer[7] = 7，
 * 在所有拥有的钱肯定不少于 person 7 的人中(这可能包括 person 3，4，5，6 以及 7)，
 * 最安静(有较低安静值 quiet[x])的人是 person 7。
 * <p>
 * 其他的答案也可以用类似的推理来解释。
 * 提示：
 * <p>
 * 1 <= quiet.length = N <= 500
 * 0 <= quiet[i] < N，所有?quiet[i]?都不相同。
 * 0 <= richer.length <= N * (N-1) / 2
 * 0 <= richer[i][j] < N
 * richer[i][0] != richer[i][1]
 * richer[i]?都是不同的。
 * 对?richer?的观察在逻辑上是一致的。
 * 通过次数1,780提交次数4,069
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/loud-and-rich
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LoudAndRich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int m = quiet.length;
        int[] answers = new int[m];
        for (int i = 0; i < m; i++) {
            answers[i] = -1;
        }
        List<Integer>[] graph = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : richer) {
            graph[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < m; i++) {
            dfs(graph, quiet, i, answers);
        }
        return answers;
    }

    private int dfs(List<Integer>[] graph, int[] quiet, int node, int[] answers) {
        if (answers[node] == -1) {
            answers[node] = node;
            for (int richer : graph[node]) {
                int child = dfs(graph, quiet, richer, answers);
                if (quiet[child] < quiet[answers[node]]) {
                    answers[node] = child;
                }
            }
        }
        return answers[node];
    }
}
