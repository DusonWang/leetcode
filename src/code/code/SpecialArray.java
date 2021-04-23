package code.code;

/**
 * ����һ���Ǹ��������� nums ���������һ���� x ��ʹ�� nums ��ǡ���� x ��Ԫ�� ���ڻ��ߵ��� x ����ô�ͳ� nums ��һ�� �������� ���� x �Ǹ������ ����ֵ ��
 * <p>
 * ע�⣺ x ���� �� nums ���е�Ԫ�ء�
 * <p>
 * ������� nums ��һ�� �������� ���뷵����������ֵ x �����򣬷��� -1 ������֤�����ǣ���� nums ���������飬��ô������ֵ x �� Ψһ�� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [3,5]
 * �����2
 * ���ͣ��� 2 ��Ԫ�أ�3 �� 5�����ڻ���� 2 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [0,0]
 * �����-1
 * ���ͣ�û��������ĿҪ����������飬�ʶ�Ҳ����������ֵ x ��
 * ��� x = 0��Ӧ���� 0 ��Ԫ�� >= x����ʵ���� 2 ����
 * ��� x = 1��Ӧ���� 1 ��Ԫ�� >= x����ʵ���� 0 ����
 * ��� x = 2��Ӧ���� 2 ��Ԫ�� >= x����ʵ���� 0 ����
 * x ����ȡ�����ֵ����Ϊ nums ��ֻ������Ԫ�ء�
 * ʾ�� 3��
 * <p>
 * ���룺nums = [0,4,3,0,4]
 * �����3
 * ���ͣ��� 3 ��Ԫ�ش��ڻ���� 3 ��
 * ʾ�� 4��
 * <p>
 * ���룺nums = [3,6,7,7,0]
 * �����-1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * ͨ������8,102�ύ����12,673
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/special-array-with-x-elements-greater-than-or-equal-x
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SpecialArray {

    public int specialArray(int[] nums) {
        int res = -1;
        for (int i = 1; i <= nums.length; ++i) {
            int count = 0;
            for (int num : nums) {
                if (num >= i) {
                    count++;
                }
            }
            if (count == i) {
                res = i;
            }
        }
        return res;
    }

    public int specialArray2(int[] nums) {
        int n = nums.length, cnt = 0;
        int[] counter = new int[n + 1];
        for (int num : nums) {
            counter[Math.min(num, n)]++;
        }
        for (int i = n; i > 0; i--) {
            cnt += counter[i];
            if (cnt == i) {
                return i;
            }
        }
        return -1;
    }
}
