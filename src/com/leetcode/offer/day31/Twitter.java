package com.leetcode.offer.day31;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author duson
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * <p>
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 * <p>
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 * <p>
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 * <p>
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Twitter {

    static class TwitterInfo {
        int id;
        Long time;

        TwitterInfo(int id, Long time) {
            this.id = id;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> relationMap;

    private Map<Integer, List<TwitterInfo>> twitterMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        relationMap = new HashMap<>();
        twitterMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (twitterMap.containsKey(userId)) {
            TwitterInfo twitterInfo = new TwitterInfo(tweetId, System.nanoTime());
            List<TwitterInfo> list = twitterMap.get(userId);
            boolean flag = false;
            for (TwitterInfo t : list) {
                if (t.id == tweetId) {
                    t.time = System.nanoTime();
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(twitterInfo);
            }
        } else {
            List<TwitterInfo> tweetIdList = new ArrayList<>();
            TwitterInfo twitterInfo = new TwitterInfo(tweetId, System.nanoTime());
            tweetIdList.add(twitterInfo);
            twitterMap.put(userId, tweetIdList);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> allUserId = new HashSet<>();
        if (relationMap.containsKey(userId)) {
            allUserId.addAll(relationMap.get(userId));
        }
        allUserId.add(userId);
        List<TwitterInfo> tweetIdList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (Integer id : allUserId) {
            List<TwitterInfo> list = twitterMap.get(id);
            if (list != null && list.size() > 0) {
                for (TwitterInfo t : list) {
                    if (!set.contains(t.id)) {
                        set.add(t.id);
                        tweetIdList.add(t);
                    }
                }
            }
        }
        tweetIdList.sort(new Comparator<TwitterInfo>() {
            @Override
            public int compare(TwitterInfo o1, TwitterInfo o2) {
                return o2.time.compareTo(o1.time);
            }
        });
        List<Integer> list = tweetIdList.stream().map(tmp -> tmp.id).collect(Collectors.toList());
        return list.subList(0, Math.min(list.size(), 10));
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (relationMap.containsKey(followerId)) {
            relationMap.get(followerId).add(followeeId);
        } else {
            Set<Integer> followeeIdSet = new HashSet<>();
            followeeIdSet.add(followeeId);
            relationMap.put(followerId, followeeIdSet);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (relationMap.containsKey(followerId)) {
            relationMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        //["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
        //[[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
        //[null,null,[],null,null,[6,5],null,[5]]
        //[null,null,[5],null,null,[6,5],null,[5]] hope

//        twitter.postTweet(1, 5);
//        System.out.println(twitter.getNewsFeed(1));
//        twitter.follow(1, 2);
//        twitter.postTweet(2, 6);
//        System.out.println(twitter.getNewsFeed(1));
//        twitter.unfollow(1, 2);
//        System.out.println(twitter.getNewsFeed(1));

        //["Twitter","postTweet","postTweet","getNewsFeed"]
        //[[],[1,5],[1,3],[1]]
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        System.out.println(twitter.getNewsFeed(1));
    }
}
