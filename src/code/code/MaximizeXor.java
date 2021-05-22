package code.code;

import java.util.Arrays;

/**
 * ����һ���ɷǸ�������ɵ����� nums ������һ����ѯ���� queries ������ queries[i] = [xi, mi] ��
 * <p>
 * �� i ����ѯ�Ĵ��� xi ���κ� nums �����в����� mi ��Ԫ�ذ�λ���XOR���õ������ֵ�����仰˵������ max(nums[j] XOR xi) ���������� j ������ nums[j] <= mi ����� nums �е�����Ԫ�ض����� mi�����մ𰸾��� -1 ��
 * <p>
 * ����һ���������� answer ��Ϊ��ѯ�Ĵ𰸣����� answer.length == queries.length �� answer[i] �ǵ� i ����ѯ�Ĵ𰸡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * �����[3,3,7]
 * ���ͣ�
 * 1) 0 �� 1 �ǽ��е����������� 1 ��������0 XOR 3 = 3 �� 1 XOR 3 = 2 �������еĸ���ֵ�� 3 ��
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * ʾ�� 2��
 * <p>
 * ���룺nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * �����[15,-1,5]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 * ͨ������2,241�ύ����5,040
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaximizeXor {

    private static final int INF = 1 << 30;

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        // sort & de-dup
        Arrays.sort(nums);
        int len = 0;
        for (int i = 0, prev = -1; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[len++] = nums[i];
            }
        }
        // for loop
        final int querySize = queries.length;
        int[] ans = new int[querySize];
        for (int i = 0; i < querySize; i++) {
            int threshold = queries[i][1];
            int r = binarySearch(nums, 0, len, threshold) - 1;
            if (r < 0) {
                ans[i] = -1;
                continue;
            }
            int mod = INF;
            while (mod > 1 && 0 == (mod & threshold)) {
                mod >>>= 1;
            }
            ans[i] = query(nums, 0, r, mod, queries[i][0]);
        }
        return ans;
    }

    private static int query(int[] nums, int l, int r, int threshold, int x) {
        for (; threshold != 0 && l < r; threshold >>>= 1) {
            if ((threshold & nums[l]) == (threshold & nums[r])) {
                continue;
            }
            int mid = binarySearch(nums, l, r + 1, nums[l] | (threshold - 1));
            if (0 == (x & threshold)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] ^ x;
    }

    private static int binarySearch(int[] arr, int l, int r, int target) {
        return Math.abs(Arrays.binarySearch(arr, l, r, target) + 1);
    }
}
