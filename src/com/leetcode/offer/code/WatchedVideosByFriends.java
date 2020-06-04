package com.leetcode.offer.code;

import java.util.*;

/**
 * ��?n ���ˣ�ÿ���˶���һ��? 0?��?n-1?��Ψһ?id?��
 * <p>
 * �������� watchedVideos? ��?friends?������?watchedVideos[i]? ��?friends[i]?�ֱ��ʾ?id = i?���˹ۿ�������Ƶ�б�����ĺ����б�
 * <p>
 * Level?1?����Ƶ������������ѹۿ�������Ƶ��level?2?����Ƶ������������ѵĺ��ѹۿ�������Ƶ���Դ����ơ�һ��ģ�Level Ϊ k?����Ƶ�������д����������̾���Ϊ?k?�ĺ��ѹۿ�������Ƶ��
 * <p>
 * �������?id? ��һ��?level?ֵ�������ҳ�����ָ�� level ����Ƶ���������ǰ��ۿ�Ƶ�����򷵻ء������Ƶ����ͬ����Ƶ���뽫���ǰ���ĸ˳���С�������С�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
 * �����["B","C"]
 * ���ͣ�
 * ��� id Ϊ 0����ɫ����������Ѱ�������ɫ����
 * id Ϊ 1 -> watchedVideos = ["C"]?
 * id Ϊ 2 -> watchedVideos = ["B","C"]?
 * �����ѹۿ�����Ƶ��Ƶ��Ϊ��
 * B -> 1?
 * C -> 2
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
 * �����["D"]
 * ���ͣ�
 * ��� id Ϊ 0����ɫ���������ѵ�����ֻ��һ���ˣ����� id Ϊ 3����ɫ����
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * n == watchedVideos.length ==?friends.length
 * 2 <= n?<= 100
 * 1 <=?watchedVideos[i].length <= 100
 * 1 <=?watchedVideos[i][j].length <= 8
 * 0 <= friends[i].length < n
 * 0 <= friends[i][j]?< n
 * 0 <= id < n
 * 1 <= level < n
 * ���?friends[i] ����?j?����ô?friends[j] ����?i
 * ͨ������3,148�ύ����8,765
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/get-watched-videos-by-your-friends
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class WatchedVideosByFriends {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[friends.length];
        queue.offer(id);
        visited[id] = true;
        int currLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currLevel == level) {
                break;
            }
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                int[] neighbors = friends[curr];
                for (int each : neighbors) {
                    if (visited[each]) {
                        continue;
                    }
                    queue.offer(each);
                    visited[each] = true;
                }
            }
            currLevel += 1;
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (String each : watchedVideos.get(index)) {
                map.put(each, map.getOrDefault(each, 0) + 1);
            }
        }
        List<String> result = new LinkedList<>(map.keySet());
        result.sort((s1, s2) -> {
            int n1 = map.get(s1);
            int n2 = map.get(s2);
            if (n1 == n2) {
                return s1.compareTo(s2);
            }
            return n1 - n2;
        });
        return result;
    }
}
