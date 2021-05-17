package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ���������������� nums1 �� nums2 ������ʵ��һ��֧�����������ѯ�����ݽṹ��
 * <p>
 * �ۼ� ����һ���������ӵ� nums2 ��ָ���±��ӦԪ���ϡ�
 * ���� ��ͳ������ nums1[i] + nums2[j] ����ָ��ֵ���±�� (i, j) ��Ŀ��0 <= i < nums1.length �� 0 <= j < nums2.length����
 * ʵ�� FindSumPairs �ࣺ
 * <p>
 * FindSumPairs(int[] nums1, int[] nums2) ʹ����������?nums1 �� nums2 ��ʼ�� FindSumPairs ����
 * void add(int index, int val) �� val �ӵ� nums2[index] �ϣ�����ִ�� nums2[index] += val ��
 * int count(int tot) ��������?nums1[i] + nums2[j] == tot ���±�� (i, j) ��Ŀ��
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺
 * ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
 * [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
 * �����
 * [null, 8, null, 2, 1, null, null, 11]
 * <p>
 * ���ͣ�
 * FindSumPairs findSumPairs = new FindSumPairs([1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]);
 * findSumPairs.count(7);  // ���� 8 ; �±�� (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) ���� 2 + 5 = 7 ���±�� (5,1), (5,5) ���� 3 + 4 = 7
 * findSumPairs.add(3, 2); // ��ʱ nums2 = [1,4,5,4,5,4]
 * findSumPairs.count(8);  // ���� 2 ���±�� (5,2), (5,4) ���� 3 + 5 = 8
 * findSumPairs.count(4);  // ���� 1 ���±�� (5,0) ���� 3 + 1 = 4
 * findSumPairs.add(0, 1); // ��ʱ nums2 = [2,4,5,4,5,4]
 * findSumPairs.add(1, 1); // ��ʱ nums2 = [2,5,5,4,5,4]
 * findSumPairs.count(7);  // ���� 11 ���±�� (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) ���� 2 + 5 = 7 ���±�� (5,3), (5,5) ���� 3 + 4 = 7
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums1.length <= 1000
 * 1 <= nums2.length <= 105
 * 1 <= nums1[i] <= 109
 * 1 <= nums2[i] <= 105
 * 0 <= index < nums2.length
 * 1 <= val <= 105
 * 1 <= tot <= 109
 * ������?add �� count ������ 1000 ��
 * ͨ������2,699�ύ����7,775
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/finding-pairs-with-a-certain-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindSumPairs {

    private final Map<Integer, Integer> map1;
    private final Map<Integer, Integer> map2;
    private final int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        this.nums2 = nums2;
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        map2.put(nums2[index], map2.get(nums2[index]) - 1);
        map2.put(nums2[index] + val, map2.getOrDefault(nums2[index] + val, 0) + 1);
        nums2[index] += val;
    }

    public int count(int tot) {
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(tot - entry.getKey())) {
                res += entry.getValue() * map2.get(tot - entry.getKey());
            }
        }
        return res;
    }
}
