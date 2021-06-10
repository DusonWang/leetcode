package code.code;

import java.util.*;

/**
 * ����һ���� n ����ͬԪ����ɵ��������� nums �������Ѿ��ǲ���������ݡ������㻹�ǵ� nums �е�ÿһ������Ԫ�ء�
 * <p>
 * ����һ����ά�������� adjacentPairs ����СΪ n - 1 ������ÿ�� adjacentPairs[i] = [ui, vi] ��ʾԪ�� ui �� vi �� nums �����ڡ�
 * <p>
 * ��Ŀ���ݱ�֤������Ԫ�� nums[i] �� nums[i+1] ��ɵ�����Ԫ�ضԶ������� adjacentPairs �У�������ʽ������ [nums[i], nums[i+1]] ��Ҳ������ [nums[i+1], nums[i]] ����Щ����Ԫ�ضԿ��� ������˳�� ���֡�
 * <p>
 * ���� ԭʼ���� nums ��������ڶ��ֽ�𣬷��� ��������һ�� ���ɡ�
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺adjacentPairs = [[2,1],[3,4],[3,2]]
 * �����[1,2,3,4]
 * ���ͣ��������������Ԫ�ضԶ��� adjacentPairs �С�
 * �ر�Ҫע����ǣ�adjacentPairs[i] ֻ��ʾ����Ԫ�����ڣ�������֤�� ��-�� ˳��
 * ʾ�� 2��
 * <p>
 * ���룺adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * �����[-2,4,1,-3]
 * ���ͣ������п��ܴ��ڸ�����
 * ��һ�ֽ���� [-3,1,4,-2] ��Ҳ�ᱻ������ȷ�𰸡�
 * ʾ�� 3��
 * <p>
 * ���룺adjacentPairs = [[100000,-100000]]
 * �����[100000,-100000]
 *
 * <p>
 * ��ʾ��
 * <p>
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 105
 * -105 <= nums[i], ui, vi <= 105
 * ��Ŀ���ݱ�֤����һЩ��adjacentPairs ��ΪԪ�ضԵ����� nums
 * ͨ������3,904�ύ����6,834
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class RestoreArray {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            adj.computeIfAbsent(pair[0], l -> new ArrayList<>()).add(pair[1]);
            adj.computeIfAbsent(pair[1], s -> new ArrayList<>()).add(pair[0]);
        }
        int n = adjacentPairs.length + 1;
        int k = 0;
        int[] ans = new int[n];
        for (Map.Entry<Integer, List<Integer>> e : adj.entrySet()) {
            if (e.getValue().size() == 1) {
                ans[0] = e.getKey();
                break;
            }
        }
        Integer prev = null;
        while (k < n - 1) {
            for (int next : adj.remove(ans[k])) {
                if (prev == null || next != prev) {
                    prev = ans[k];
                    ans[++k] = next;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RestoreArray restoreArray = new RestoreArray();
        System.out.println(Arrays.toString(restoreArray.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}})));
    }
}
