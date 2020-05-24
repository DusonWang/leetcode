package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一些区域列表?regions ，每个列表的第一个区域都包含这个列表内所有其他区域。
 * <p>
 * 很自然地，如果区域?X 包含区域?Y ，那么区域?X ?比区域?Y 大。
 * <p>
 * 给定两个区域?region1?和?region2 ，找到同时包含这两个区域的?最小?区域。
 * <p>
 * 如果区域列表中?r1?包含?r2?和?r3 ，那么数据保证?r2 不会包含?r3?。
 * <p>
 * 数据同样保证最小公共区域一定存在。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * regions = [["Earth","North America","South America"],
 * ["North America","United States","Canada"],
 * ["United States","New York","Boston"],
 * ["Canada","Ontario","Quebec"],
 * ["South America","Brazil"]],
 * region1 = "Quebec",
 * region2 = "New York"
 * 输出："North America"
 * ?
 * <p>
 * 提示：
 * <p>
 * 2 <= regions.length <= 10^4
 * region1 != region2
 * 所有字符串只包含英文字母和空格，且最多只有?20 个字母。
 * 通过次数1,053提交次数2,038
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-common-region
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSmallestRegion {

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        if (null == regions || regions.size() == 0) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        for (List<String> regionList : regions) {
            String parentRegion = regionList.get(0);
            for (int i = 1; i < regionList.size(); i++) {
                map.put(regionList.get(i), parentRegion);
            }
        }
        List<String> parent1List = find(region1, map);
        List<String> parent2List = find(region2, map);
        for (String p : parent1List) {
            if (parent2List.contains(p)) {
                return p;
            }
        }
        return "";
    }

    private List<String> find(String region, Map<String, String> map) {
        String parent1 = region;
        List<String> parent1List = new ArrayList<>();
        while (parent1 != null) {
            parent1List.add(parent1);
            parent1 = map.get(parent1);
        }
        return parent1List;
    }
}
