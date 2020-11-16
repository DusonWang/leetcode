package code.code;

import java.util.*;

/**
 * @author duson
 * ����һ������ favoriteCompanies ������ favoriteCompanies[i] �ǵ� i ���û��ղصĹ�˾�嵥���±�� 0 ��ʼ����
 * <p>
 * ���ҳ����������κ����ղصĹ�˾�嵥���Ӽ����ղ��嵥�������ظ��嵥�±ꡣ�±���Ҫ���������С�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * �����[0,1,4]
 * ���ͣ�
 * favoriteCompanies[2]=["google","facebook"] �� favoriteCompanies[0]=["leetcode","google","facebook"] ���Ӽ���
 * favoriteCompanies[3]=["google"] �� favoriteCompanies[0]=["leetcode","google","facebook"] �� favoriteCompanies[1]=["google","microsoft"] ���Ӽ���
 * ������ղ��嵥�����������κ����ղصĹ�˾�嵥���Ӽ�����ˣ���Ϊ [0,1,4] ��
 * ʾ�� 2��
 * <p>
 * ���룺favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
 * �����[0,1]
 * ���ͣ�favoriteCompanies[2]=["facebook","google"] �� favoriteCompanies[0]=["leetcode","google","facebook"] ���Ӽ�����ˣ���Ϊ [0,1] ��
 * ʾ�� 3��
 * <p>
 * ���룺favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
 * �����[0,1,2,3]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <=?favoriteCompanies.length <= 100
 * 1 <=?favoriteCompanies[i].length <= 500
 * 1 <=?favoriteCompanies[i][j].length <= 20
 * favoriteCompanies[i] �е������ַ��� ������ͬ ��
 * �û��ղصĹ�˾�嵥Ҳ ������ͬ ��Ҳ����˵���������ǰ���ĸ˳������ÿ���嵥�� favoriteCompanies[i] != favoriteCompanies[j] ��Ȼ������
 * �����ַ���������СдӢ����ĸ��
 * ͨ������3,115�ύ����6,824
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
