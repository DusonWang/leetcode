package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���һ����������������Ԫ����ɣ���ÿ��������Ԫ��֮��Ĳ�ֵ����ͬ����ô������о��� �Ȳ����� ������ʽ�أ����� s �ǵȲ����У�ֻ��Ҫ���㣺����ÿ����Ч�� i �� s[i+1] - s[i] == s[1] - s[0] ��������
 * <p>
 * ���磬������Щ���� �Ȳ����� ��
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * ��������� ���ǵȲ����� ��
 * <p>
 * 1, 1, 2, 5, 7
 * ����һ���� n ��������ɵ����� nums���������� m ��������ɵ����� l �� r�������������ʾ m �鷶Χ��ѯ�����е� i ����ѯ��Ӧ��Χ [l[i], r[i]] ������������±궼�� �� 0 ��ʼ �ġ�
 * <p>
 * ���� boolean Ԫ�ع��ɵĴ��б� answer ����������� nums[l[i]], nums[l[i]+1], ... , nums[r[i]] ���� �������� �γ� �Ȳ����� ��answer[i] ��ֵ���� true������answer[i] ��ֵ���� false ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
 * �����[true,false,true]
 * ���ͣ�
 * �� 0 ����ѯ����Ӧ������ [4,6,5] ��������������Ϊ�Ȳ����� [6,5,4] ��
 * �� 1 ����ѯ����Ӧ������ [4,6,5,9] ���޷����������γɵȲ����С�
 * �� 2 ����ѯ����Ӧ������ [5,9,3,7] ��������������Ϊ�Ȳ����� [3,5,7,9] ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
 * �����[false,true,false,false,true,true]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * n == nums.length
 * m == l.length
 * m == r.length
 * 2 <= n <= 500
 * 1 <= m <= 500
 * 0 <= l[i] < r[i] < n
 * -105 <= nums[i] <= 105
 * ͨ������6,633�ύ����8,631
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/arithmetic-subarrays
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CheckArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            boolean f = true;
            int left = l[i];
            int right = r[i];
            int[] temp = Arrays.copyOfRange(nums, left, right + 1);
            Arrays.sort(temp);
            int a = (temp[right - left] - temp[0]) / (right - left);
            for (int j = right - left; j >= 0; j--) {
                if (j - 1 >= 0 && temp[j] - temp[j - 1] != a) {
                    list.add(false);
                    f = false;
                    break;
                }
            }
            if (f) {
                list.add(true);
            }
        }
        return list;
    }
}
