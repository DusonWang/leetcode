package code.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * �����û��� LeetCode �Ĳ�����־����һ������ k ����־��һ����ά�������� logs ��ʾ������ÿ�� logs[i] = [IDi, timei] ��ʾ ID Ϊ IDi ���û��� timei ����ʱִ����ĳ��������
 * <p>
 * ����û� ����ͬʱִ�в����������û�������ͬһ������ִ�� ������� ��
 * <p>
 * ָ���û��� �û���Ծ��������user active minutes��UAM�� ����Ϊ�û��� LeetCode ִ�в����� Ψһ������ �� ��ʹһ������ִ�ж��������Ҳֻ�ܰ�һ���Ӽ�����
 * <p>
 * ����ͳ���û���Ծ�������ķֲ������ͳ�ƽ����һ������Ϊ k �� �±�� 1 ��ʼ���� ������ answer ������ÿ�� j��1 <= j <= k����answer[j] ��ʾ �û���Ծ������ ���� j ���û�����
 * <p>
 * �������������Ĵ����� answer ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5
 * �����[0,2,0,0,0]
 * ���ͣ�
 * ID=0 ���û�ִ�в����ķ��ӷֱ��ǣ�5 ��2 �� 5 ����ˣ����û����û���Ծ������Ϊ 2������ 5 ֻ����һ�Σ�
 * ID=1 ���û�ִ�в����ķ��ӷֱ��ǣ�2 �� 3 ����ˣ����û����û���Ծ������Ϊ 2
 * 2 ���û����û���Ծ���������� 2 ��answer[2] Ϊ 2 ������ answer[j] ��ֵ���� 0
 * ʾ�� 2��
 * <p>
 * ���룺logs = [[1,1],[2,2],[2,3]], k = 4
 * �����[1,1,0,0]
 * ���ͣ�
 * ID=1 ���û����ڷ��� 1 ִ�е�����������ˣ����û����û���Ծ������Ϊ 1
 * ID=2 ���û�ִ�в����ķ��ӷֱ��ǣ�2 �� 3 ����ˣ����û����û���Ծ������Ϊ 2
 * 1 ���û����û���Ծ�������� 1 ��1 ���û����û���Ծ�������� 2
 * ��ˣ�answer[1] = 1 ��answer[2] = 1 �������ֵ���� 0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= logs.length <= 104
 * 0 <= IDi <= 109
 * 1 <= timei <= 105
 * k ��ȡֵ��Χ�� [�û�������û���Ծ������, 105]
 * ͨ������5,132�ύ����7,450
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/finding-the-users-active-minutes
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindingUsersActiveMinutes {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] re = new int[k];
        for (int[] log : logs) {
            Set<Integer> set = map.getOrDefault(log[0], new HashSet<>());
            set.add(log[1]);
            map.put(log[0], set);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            re[entry.getValue().size() - 1]++;
        }
        return re;
    }
}
