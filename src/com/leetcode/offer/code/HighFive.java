package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * 给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
 * <p>
 * 对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。平均分请采用整数除法计算。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * 输出：[[1,87],[2,88]]
 * 解释：
 * id = 1 的学生平均分为 87。
 * id = 2 的学生平均分为 88.6。但由于整数除法的缘故，平均分会被转换为 88。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * 学生的 ID 在 1 到 1000 之间
 * 学生的分数在 1 到 100 之间
 * 每个学生至少有五个分数
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/high-five
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HighFive {

    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            if (!map.containsKey(item[0])) {
                Integer tmp = item[0];
                List<Integer> arr = new ArrayList<>();
                arr.add(item[1]);
                map.put(tmp, arr);
            } else {
                map.get(item[0]).add(item[1]);
            }
        }
        int[][] result = new int[map.size()][2];
        map.forEach((key, value) -> {
            result[key - 1][0] = key;
            Integer[] array = new Integer[value.size()];
            value.toArray(array);
            Arrays.sort(array, Collections.reverseOrder());
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += array[j];
            }
            int average = sum / 5;
            result[key - 1][1] = average;
        });
        return result;
    }
}
