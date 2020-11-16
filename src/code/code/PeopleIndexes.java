package code.code;

import java.util.*;

/**
 * @author duson
 * 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
 * <p>
 * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * 输出：[0,1,4]
 * 解释：
 * favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
 * favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
 * 其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
 * 示例 2：
 * <p>
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
 * 输出：[0,1]
 * 解释：favoriteCompanies[2]=["facebook","google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集，因此，答案为 [0,1] 。
 * 示例 3：
 * <p>
 * 输入：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
 * 输出：[0,1,2,3]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <=?favoriteCompanies.length <= 100
 * 1 <=?favoriteCompanies[i].length <= 500
 * 1 <=?favoriteCompanies[i][j].length <= 20
 * favoriteCompanies[i] 中的所有字符串 各不相同 。
 * 用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
 * 所有字符串仅包含小写英文字母。
 * 通过次数3,115提交次数6,824
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PeopleIndexes {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<Integer, Set<String>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            map.put(i, new HashSet<>(favoriteCompanies.get(i)));
        }
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> companies = favoriteCompanies.get(i);
            boolean found = false;
            for (Map.Entry<Integer, Set<String>> entry : map.entrySet()) {
                if (entry.getKey() == i) {
                    continue;
                }
                if (entry.getValue().containsAll(companies)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                res.add(i);
            }
        }
        return res;
    }
}
