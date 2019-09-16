package com.leetcode.offer.day30;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 请你设计一个日志系统，可以流式接收日志以及它的时间戳。
 * <p>
 * 该日志会被打印出来，需要满足一个条件：当且仅当日志内容 在过去的 10 秒钟内没有被打印过。
 * <p>
 * 给你一条日志的内容和它的时间戳（粒度为秒级），如果这条日志在给定的时间戳应该被打印出来，则返回 true，否则请返回 false。
 * <p>
 * 要注意的是，可能会有多条日志在同一时间被系统接收。
 * <p>
 * 示例：
 * <p>
 * Logger logger = new Logger();
 * <p>
 * // 日志内容 "foo" 在时刻 1 到达系统
 * logger.shouldPrintMessage(1, "foo"); returns true;
 * <p>
 * // 日志内容 "bar" 在时刻 2 到达系统
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * <p>
 * // 日志内容 "foo" 在时刻 3 到达系统
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * <p>
 * // 日志内容 "bar" 在时刻 8 到达系统
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * <p>
 * // 日志内容 "foo" 在时刻 10 到达系统
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * <p>
 * // 日志内容 "foo" 在时刻 11 到达系统
 * logger.shouldPrintMessage(11,"foo"); returns true;
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/logger-rate-limiter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Logger {

    private Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        map = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            if (timestamp - map.get(message) < 10) {
                return false;
            }
        }
        map.put(message, timestamp);
        return true;
    }
}
