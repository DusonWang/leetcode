package com.leetcode.offer.day37;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duson
 * 作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员 people[i] 含有一份该备选人员掌握的技能列表）。
 * <p>
 * 所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。
 * <p>
 * 我们可以用每个人的编号来表示团队中的成员：例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。
 * <p>
 * 请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按任意顺序返回答案，本题保证答案存在。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
 * 输出：[0,2]
 * 示例 2：
 * <p>
 * 输入：req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= req_skills.length <= 16
 * 1 <= people.length <= 60
 * 1 <= people[i].length, req_skills[i].length, people[i][j].length <= 16
 * req_skills 和 people[i] 中的元素分别各不相同
 * req_skills[i][j], people[i][j][k] 都由小写英文字母组成
 * 本题保证「必要团队」一定存在
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-sufficient-team
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestSufficientTeam {

    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        int ns = reqSkills.length, np = people.size();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < ns; ++i) {
            map.put(reqSkills[i], i);
        }
        ArrayList<Integer>[] suff = new ArrayList[1 << ns];
        suff[0] = new ArrayList<>();
        for (int i = 0; i < np; ++i) {
            int skill = 0;
            for (String s : people.get(i)) {
                skill |= (1 << map.get(s));
            }
            for (int prev = 0; prev < suff.length; ++prev) {
                if (suff[prev] == null) {
                    continue;
                }
                int comb = prev | skill;
                if (suff[comb] == null || suff[prev].size() + 1 < suff[comb].size()) {
                    suff[comb] = new ArrayList<>(suff[prev]);
                    suff[comb].add(i);
                }
            }
        }
        List<Integer> res = suff[(1 << ns) - 1];
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private List<Integer> sol = new ArrayList<>();

    public int[] smallestSufficientTeam2(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> idx = new HashMap<>();
        int n = 0;
        for (String s : req_skills) {
            idx.put(s, n++);
        }
        int[] pe = new int[people.size()];
        for (int i = 0; i < pe.length; i++) {
            for (String p : people.get(i)) {
                int skill = idx.get(p);
                pe[i] += 1 << skill;
            }
        }
        search(0, pe, new ArrayList<>(), n);
        int[] ans = new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) {
            ans[i] = sol.get(i);
        }
        return ans;
    }

    public void search(int cur, int[] pe, List<Integer> onesol, int n) {
        if (cur == (1 << n) - 1) {
            if (sol.size() == 0 || onesol.size() < sol.size()) {
                sol = new ArrayList<>(onesol);
            }
            return;
        }
        if (sol.size() != 0 && onesol.size() >= sol.size()) {
            return;
        }
        int zeroBit = 0;
        while (((cur >> zeroBit) & 1) == 1) {
            zeroBit++;
        }
        for (int i = 0; i < pe.length; i++) {
            int per = pe[i];
            if (((per >> zeroBit) & 1) == 1) {
                onesol.add(i);
                search(cur | per, pe, onesol, n);
                onesol.remove(onesol.size() - 1);
            }
        }
    }
}
