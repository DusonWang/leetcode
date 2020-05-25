package com.leetcode.offer.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
 * <p>
 * 在结果列表中，选择字典序最小的名字作为真实名字。
 * <p>
 * 示例：
 * <p>
 * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 * 输出：["John(27)","Chris(36)"]
 * 提示：
 * <p>
 * names.length <= 100000
 * 通过次数1,272提交次数3,504
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baby-names-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TrulyMostPopular {

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, String> nameMap = new HashMap<>();
        for (String synonym : synonyms) {
            String[] temp = synonym.replace("(", "").replace(")", "").split(",");
            String last1 = getLast(temp[1], nameMap);
            String last0 = getLast(temp[0], nameMap);
            if (last0.compareTo(last1) > 0) {
                nameMap.put(last0, last1);
            } else if (last0.compareTo(last1) < 0) {
                nameMap.put(last1, last0);
            }
        }
        Map<String, Integer> resCount = new HashMap<>();
        for (String nameInfo : names) {
            String name = nameInfo.split("\\(")[0];
            int count = Integer.parseInt(nameInfo.split("\\(")[1].replace(")", ""));
            String last = getLast(name, nameMap);
            resCount.putIfAbsent(last, 0);
            resCount.put(last, resCount.get(last) + count);
        }
        String[] res = new String[resCount.size()];
        int index = 0;
        for (String key : resCount.keySet()) {
            res[index++] = key + "(" + resCount.get(key) + ")";
        }
        return res;
    }

    private String getLast(String name, Map<String, String> nameMap) {
        String temp = name;
        while (nameMap.get(temp) != null) {
            temp = nameMap.get(temp);
        }
        return temp;
    }
}
