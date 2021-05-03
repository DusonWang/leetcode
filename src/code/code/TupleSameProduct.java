package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���� ��ͬ ��������ɵ����� nums �����㷵������?a * b = c * d ��Ԫ�� (a, b, c, d) ������������ a��b��c �� d ���� nums �е�Ԫ�أ��� a != b != c != d ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [2,3,4,6]
 * �����8
 * ���ͣ����� 8 �����������Ԫ�飺
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,2,4,5,10]
 * �����16
 * ���ͣ����� 16 �����������Ԫ�飺
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 * ʾ�� 3��
 * <p>
 * ���룺nums = [2,3,4,6,8,12]
 * �����40
 * ʾ�� 4��
 * <p>
 * ���룺nums = [2,3,5,7]
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 104
 * nums �е�����Ԫ�� ������ͬ
 * ͨ������4,740�ύ����10,284
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/tuple-with-same-product
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class TupleSameProduct {

    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = nums[i] * nums[j];
                Integer count = map.get(key);
                if (count != null) {
                    ans += count;
                    count++;
                } else {
                    count = 1;
                }
                map.put(key, count);
            }
        }
        return ans << 3;
    }
}
