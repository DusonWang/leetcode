package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ������������?nums�������Ƴ� ���?�����飨����Ϊ �գ���ʹ��ʣ��Ԫ�ص� ��?�ܱ� p?������ ������?���������鶼�Ƴ���
 * <p>
 * ���㷵������Ҫ�Ƴ������������ĳ��ȣ�����޷�������ĿҪ�󣬷��� -1?��
 * <p>
 * ������?����Ϊԭ������������һ��Ԫ�ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [3,1,4,2], p = 6
 * �����1
 * ���ͣ�nums ��Ԫ�غ�Ϊ 10�����ܱ� p ���������ǿ����Ƴ������� [4] ��ʣ��Ԫ�صĺ�Ϊ 6 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [6,3,5,2], p = 9
 * �����2
 * ���ͣ������޷��Ƴ��κ�һ��Ԫ��ʹ�úͱ� 9 ���������ŷ������Ƴ������� [5,2] ��ʣ��Ԫ��Ϊ [6,3]����Ϊ 9 ��
 * ʾ��?3��
 * <p>
 * ���룺nums = [1,2,3], p = 3
 * �����0
 * ���ͣ���ǡ��Ϊ 6 ���Ѿ��ܱ� 3 �����ˡ��������ǲ���Ҫ�Ƴ��κ�Ԫ�ء�
 * ʾ��? 4��
 * <p>
 * ���룺nums = [1,2,3], p = 7
 * �����-1
 * ���ͣ�û���κη���ʹ���Ƴ��������ʣ��Ԫ�صĺͱ� 7 ������
 * ʾ�� 5��
 * <p>
 * ���룺nums = [1000000000,1000000000,1000000000], p = 3
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= p <= 109
 * ͨ������2,678�ύ����10,701
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/make-sum-divisible-by-p
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinSubarray {

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int mod = 0;
        for (int num : nums) {
            mod = (mod + num) % p;
        }
        if (mod == 0) {
            return 0;
        }
        int res = n;
        int subMod = 0;
        Map<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0, -1);
        for (int i = 0; i < n; i++) {
            subMod = (subMod + nums[i]) % p;
            int target = (subMod - mod + p) % p;
            if (hashmap.containsKey(target)) {
                res = Math.min(res, i - hashmap.get(target));
                if (res == 1 && res != n) {
                    return res;
                }
            }
            hashmap.put(subMod, i);
        }
        if (res == n) {
            return -1;
        }
        return res;
    }
}
