package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * ����ʵ��һ���ܹ�֧���������ַ��������ļ�����?TweetCounts��
 * <p>
 * 1. recordTweet(string tweetName, int time)
 * <p>
 * ��¼���ķ���������û�?tweetName?��?time���� ��?Ϊ��λ��ʱ�̷�����һ�����ġ�
 * 2. getTweetCountsPerFrequency(string freq, string tweetName, int startTime, int endTime)
 * <p>
 * ���شӿ�ʼʱ��?startTime���� �� Ϊ��λ��������ʱ��?endTime���� �� Ϊ��λ���ڣ�ÿ ��?minute��ʱ?hour ���� ��?day?��ȡ����?freq����ָ���û�?tweetName?����������������
 * freq?��ֵʼ��Ϊ ��?minute��ʱ hour?����?�� day?֮һ����ʾ��ȡָ���û�?tweetName?�������Ĵ�����ʱ������
 * ��һ��ʱ����ʼ�մ� startTime ��ʼ�����ʱ����Ϊ?[startTime, startTime + delta*1>, ?[startTime + delta*1, startTime + delta*2>, [startTime + delta*2, startTime + delta*3>, ... , [startTime + delta*i,?min(startTime + delta*(i+1), endTime + 1)>������ i �� delta��ȡ���� freq�����ǷǸ�������
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺
 * ["TweetCounts","recordTweet","recordTweet","recordTweet","getTweetCountsPerFrequency","getTweetCountsPerFrequency","recordTweet","getTweetCountsPerFrequency"]
 * [[],["tweet3",0],["tweet3",60],["tweet3",10],["minute","tweet3",0,59],["minute","tweet3",0,60],["tweet3",120],["hour","tweet3",0,210]]
 * <p>
 * �����
 * [null,null,null,null,[2],[2,1],null,[4]]
 * <p>
 * ���ͣ�
 * TweetCounts tweetCounts = new TweetCounts();
 * tweetCounts.recordTweet("tweet3", 0);
 * tweetCounts.recordTweet("tweet3", 60);
 * tweetCounts.recordTweet("tweet3", 10);                             //?"tweet3"?�������ĵ�ʱ��ֱ���?0,?10?��?60 ��
 * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59); //?����?[2]��ͳ��Ƶ����ÿ���ӣ�60 �룩�����ֻ��һ����Чʱ���� [0,60>?-?>?2?�����ġ�
 * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); //?����?[2,1]��ͳ��Ƶ����ÿ���ӣ�60 �룩�������������Чʱ����?1)?[0,60>?-?>?2?�����ģ���?2)?[60,61>?-?>?1?�����ġ�
 * tweetCounts.recordTweet("tweet3", 120);                            // "tweet3"?�������ĵ�ʱ��ֱ��� 0, 10, 60 �� 120 ��
 * tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  //?����?[4]��ͳ��Ƶ����ÿСʱ��3600 �룩�����ֻ��һ����Чʱ���� [0,211>?-?>?4?�����ġ�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * ͬʱ����?recordTweet?��?getTweetCountsPerFrequency������� 10000 �β�����
 * 0 <= time, startTime, endTime <=?10^9
 * 0 <= endTime - startTime <= 10^4
 * ͨ������1,801�ύ����6,933
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/tweet-counts-per-frequency
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class TweetCounts {

    private final HashMap<String, TreeSet<Integer>> hm;

    public TweetCounts() {
        hm = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        hm.putIfAbsent(tweetName, new TreeSet<>());
        hm.get(tweetName).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int interval = 60;
        if ("hour".equals(freq)) {
            interval = 3600;
        } else if ("day".equals(freq)) {
            interval = 86400;
        }
        List<Integer> res = new ArrayList<>();
        if (hm.containsKey(tweetName)) {
            TreeSet<Integer> set = hm.get(tweetName);
            for (int i = startTime; i <= endTime; i += interval) {
                res.add(set.subSet(i, Math.min(i + interval, endTime + 1)).size());
            }
        } else {
            for (int i = startTime; i <= endTime; i += interval) {
                res.add(0);
            }
        }
        return res;
    }
}
