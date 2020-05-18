package com.leetcode.offer.code;

import java.util.*;

/**
 * @author duson
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0);
            map.put(num, ++cnt);
        }

        ArrayList[] lists = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer cnt = entry.getValue();
            if (lists[cnt] == null) {
                lists[cnt] = new ArrayList<>();
            }
            lists[cnt].add(entry.getKey());
        }

        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        for (int i = nums.length; i > 0; i--) {
            List<Integer> list = lists[i];
            if (list == null) {
                continue;
            }
            ans.addAll(list);
            cnt += list.size();
            if (cnt >= k) {
                break;
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        final int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        List<Integer> list1 = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            if (i < len) {
                list1.add(list.get(i).getKey());
            }
        }
        return list1;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println(topKFrequent.topKFrequent(new int[]{-1, -1}, 1));
    }

}
